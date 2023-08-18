package square_location_translators;

import model.Coordinate;

import java.text.ParseException;

public class AlphaNumericTranslator extends SquareLocationTranslator {


    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Coordinate parseString(String locationString) throws ParseException {

        if (locationString.length() != 2) throw new ParseException("Unexpected location string", 0);

        String initialPart = Character.toString(locationString.charAt(0));
        String latterPart = locationString.substring(1);

        try {
            int row = ALPHABET.indexOf(initialPart.toUpperCase());
            if(row < 0) throw new ParseException("Row '"+initialPart+"' was not found", 0);

            int col = Integer.parseInt(latterPart);
            return new Coordinate(row, col);

        } catch (Exception e) {
            throw new ParseException("'" + latterPart + "' is not a number", 0);
        }
    }


    @Override
    public String rowLabel(int rowNumber) {
        return Character.toString(ALPHABET.charAt(rowNumber));
    }

    @Override
    public String columnLabel(int rowNumber) {
        return Integer.toString(rowNumber);
    }


}
