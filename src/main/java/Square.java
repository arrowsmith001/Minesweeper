import java.util.ArrayList;
import java.util.Iterator;
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
    public boolean isVisible;

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean getHasMine() {
        return hasMine;
    }
}
