package model;

import exceptions.MineUncoveredException;

import java.util.LinkedList;
import java.util.List;

public class Square
{

    public Square(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    final Coordinate coordinate;

    final List<Square> neighbors = new LinkedList<Square>();

    public void addNeighbor(Square squareToAdd) {
        neighbors.add(squareToAdd);
    }


    public boolean hasMine;
    public boolean isFlagged;
    public boolean isRevealed;

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean getHasMine() {
        return hasMine;
    }

    public int getNeighborMineCount() {
        return (int) neighbors.stream().filter((s) -> s.hasMine).count();
    }

    public void select() throws MineUncoveredException {

        // Any selected square will reveal itself
        isRevealed = true;

        // If this square has a mine, the game ends
        if(hasMine) throw new MineUncoveredException();

        // If this square has any neighboring mines, selection process stops
        if(hasNeighboringMines()) return;

        // For all neighbors, select them if:
        //      - They have no mine
        //      - They aren't already revealed - this prevents infinite loops
        for (Square neighbor : neighbors)
        {
            if(!neighbor.hasMine && !neighbor.isRevealed)
            {
                neighbor.select();
            }
        }
    }

    protected boolean hasNeighboringMines() {
        return getNeighborMineCount() > 0;
    }

}
