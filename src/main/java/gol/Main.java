package gol;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File gameFieldFile = new File("src/main/java/gol/gamefield.txt");
        try (BufferedReader gameFieldReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(gameFieldFile)))) {
            String line;
            int row = 0;
            List<Cell> cells = new ArrayList<>();
            while ((line = gameFieldReader.readLine()) != null) {
                parseLine(line, cells, row);
                row++;
            }

            Game game = new Game(cells);
            printCells(cells);
            for (int idx = 0; idx < 10; idx++) {
                game.calculateNextGeneration();
                printCells(cells);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Could not find: " + gameFieldFile.getPath());
        } catch (IOException | IllegalCellException e) {
            System.err.println("Could not read: " + gameFieldFile.getPath() + " " + e.getMessage());
        }
    }

    private static void printCells(List<Cell> cells) {
        System.out.println("==========================");
        for (int idx = 0; idx < cells.size(); idx++) {
            System.out.print(cells.get(idx).isAlive() ? 1 : 0);
            System.out.print(" ");
            if ((idx + 1) % 8 == 0) {
                System.out.println();
            }
        }
    }

    private static void parseLine(String line, List<Cell> cells, int row) {
        String[] cellString = line.trim().split(" ");
        for (int column = 0; column < cellString.length; column++) {
            boolean alive;

            if (cellString[column].equals("0"))
                alive = false;
            else if (cellString[column].equals("1"))
                alive = true;
            else
                throw new IllegalCellException("Row: " + row + ", column: " + column);

            Cell cell = new Cell(new Position2d(row, column), alive);
            cells.add(cell);
        }
    }
}
