import square_location_translators.AlphaNumericTranslator;
import model.Minesweeper;

public class Main {

    public static void main(String[] args)
    {
        Minesweeper minesweeper = new Minesweeper(new AlphaNumericTranslator());
        minesweeper.play();
    }
}