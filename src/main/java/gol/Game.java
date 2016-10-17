package gol;

import java.util.List;

public class Game {

    private List<Cell> cells;

    public Game(List<Cell> cells) {
        this.cells = cells;
    }

    public void calculateNextGeneration() {
        for (Cell cell : cells) {
            int numberOfLivingNeigbours = 0;
            for (Cell potentialNeigbours : cells) {
                double distance = cell.getPosition().distanceFrom(
                        potentialNeigbours.getPosition());
                if (potentialNeigbours.isAlive() &&
                        distance > 0.0 && distance < 2.0) {
                    numberOfLivingNeigbours++;
                }
            }
            cell.setLivingNeighbours(numberOfLivingNeigbours);
        }

        for (Cell cell : cells) {
            cell.calculateNextGeneration();
        }
    }
}
