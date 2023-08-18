public class AlphaNumericSquareLocator extends SquareLocator {

    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Coordinate parseString(String locationString) throws Exception {

        if (locationString.length() != 2) throw new Exception("Unexpected location string");

        String latterPart = locationString.substring(1);

        try {
            int row = ALPHABET.indexOf(locationString.charAt(0));
            int col = Integer.parseInt(latterPart);
            return new Coordinate(row, col);
        } catch (Exception e) {
            throw new Exception("'" + latterPart + "' is not a number");
        }
    }

    @Override
    public String coordinateToString(Coordinate coordinate) {
        return rowLabel(coordinate.row) + columnLabel(coordinate.column);
    }

    @Override
    String rowLabel(int rowNumber) {
        return Character.toString(ALPHABET.charAt(rowNumber));
    }

    @Override
    String columnLabel(int rowNumber) {
        return Integer.toString(rowNumber);
    }


}
