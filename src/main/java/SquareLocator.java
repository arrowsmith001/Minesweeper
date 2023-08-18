import java.util.ArrayList;
import java.util.List;

public abstract class SquareLocator {
    abstract public Coordinate parseString(String locationString) throws Exception;
    abstract public String coordinateToString(Coordinate coordinate);

    abstract String rowLabel(int rowNumber);
    abstract String columnLabel(int rowNumber);


}


