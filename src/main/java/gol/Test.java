package gol;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        System.out.println("== Game ==");

        // 1 1 1
        // 0 0 0
        List<Cell> cells = new ArrayList<Cell>();

        cells.add(new Cell(new Position2d(0, 0), true));
        cells.add(new Cell(new Position2d(0, 1), true));
        cells.add(new Cell(new Position2d(0, 2), true));
        cells.add(new Cell(new Position2d(1, 0), false));
        cells.add(new Cell(new Position2d(1, 1), false));
        cells.add(new Cell(new Position2d(1, 2), false));

        Game game = new Game(cells);
        game.calculateNextGeneration();

        // 0 1 0
        // 0 1 0
        System.out.println("Cell 0 0 is: " + cells.get(0).isAlive());
        System.out.println("Cell 0 1 is: " + cells.get(1).isAlive());
        System.out.println("Cell 0 2 is: " + cells.get(2).isAlive());
        System.out.println("Cell 1 0 is: " + cells.get(3).isAlive());
        System.out.println("Cell 1 1 is: " + cells.get(4).isAlive());
        System.out.println("Cell 1 2 is: " + cells.get(5).isAlive());


        System.out.println("== 3D Game ==");
        // 1 1 1 | 0 0 0
        // 0 0 0 | 0 0 0

        cells = new ArrayList<Cell>();
        cells.add(new Cell(new Position3d(0, 0, 0), true));
        cells.add(new Cell(new Position3d(0, 1, 0), true));
        cells.add(new Cell(new Position3d(0, 2, 0), true));

        cells.add(new Cell(new Position3d(1, 0, 0), false));
        cells.add(new Cell(new Position3d(1, 1, 0), false));
        cells.add(new Cell(new Position3d(1, 2, 0), false));

        cells.add(new Cell(new Position3d(0, 0, 1), false));
        cells.add(new Cell(new Position3d(0, 1, 1), false));
        cells.add(new Cell(new Position3d(0, 2, 1), false));

        cells.add(new Cell(new Position3d(1, 0, 1), false));
        cells.add(new Cell(new Position3d(1, 1, 1), false));
        cells.add(new Cell(new Position3d(1, 2, 1), false));


        game = new Game(cells);
        game.calculateNextGeneration();


        // 0 1 0 | 0 1 0
        // 0 1 0 | 0 1 0

        System.out.println("Cell 0 0 0 is: " + cells.get(0).isAlive());
        System.out.println("Cell 0 1 0 is: " + cells.get(1).isAlive());
        System.out.println("Cell 0 2 0 is: " + cells.get(2).isAlive());
        System.out.println("Cell 1 0 0 is: " + cells.get(3).isAlive());
        System.out.println("Cell 1 1 0 is: " + cells.get(4).isAlive());
        System.out.println("Cell 1 2 0 is: " + cells.get(5).isAlive());

        System.out.println("Cell 0 0 1 is: " + cells.get(6).isAlive());
        System.out.println("Cell 0 1 1 is: " + cells.get(7).isAlive());
        System.out.println("Cell 0 2 1 is: " + cells.get(8).isAlive());
        System.out.println("Cell 1 0 1 is: " + cells.get(9).isAlive());
        System.out.println("Cell 1 1 1 is: " + cells.get(10).isAlive());
        System.out.println("Cell 1 2 1 is: " + cells.get(11).isAlive());


    }
}
