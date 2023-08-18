package square_location_translators;

import model.Coordinate;

import java.text.ParseException;

public abstract class SquareLocationTranslator {

    abstract public Coordinate parseString(String locationString) throws ParseException;
    public abstract String rowLabel(int rowNumber);
    public abstract String columnLabel(int rowNumber);


}


