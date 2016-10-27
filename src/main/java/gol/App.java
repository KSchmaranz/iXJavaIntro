package gol;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();

        GridPane gameField = new GridPane();
        List<Cell> cells = readCells();
        List<Label> cellLabels = new ArrayList<>();
        for (Cell cell : cells) {
            String labelStr = cell.isAlive() ? "1" : "0";
            Position2d position = (Position2d) cell.getPosition();
            Label label = new Label(labelStr);
            gameField.add(label, position.getX(), position.getY());
            cellLabels.add(label);
        }
        root.setCenter(gameField);

        Button nextButton = new Button("Calculate Next Generation");
        root.setBottom(nextButton);

        final Game game = new Game(cells);
        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                game.calculateNextGeneration();
                for (int cellIdx = 0; cellIdx < cells.size(); cellIdx++) {
                    Cell cell = cells.get(cellIdx);
                    Label label = cellLabels.get(cellIdx);
                    label.setText(cell.isAlive() ? "1" : "0");
                }
            }
        });

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private List<Cell> readCells() {
        List<Cell> cells = new ArrayList<>();
        File gameFieldFile = new File("src/main/java/gol/gamefield.txt");
        try (BufferedReader gameFieldReader =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(gameFieldFile)))) {
            String line;
            int row = 0;
            while ((line = gameFieldReader.readLine()) != null) {
                parseLine(line, cells, row);
                row++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find: " + gameFieldFile.getPath());
        } catch (IOException | IllegalCellException e) {
            System.err.println("Could not read: " + gameFieldFile.getPath() + " " + e.getMessage());
        }
        return cells;
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
