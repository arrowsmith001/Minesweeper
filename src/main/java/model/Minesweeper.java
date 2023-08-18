package model;

import exceptions.MineUncoveredException;
import square_location_translators.SquareLocationTranslator;
import presentation.BoardPrinter;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Minesweeper {

    final Scanner sc = new Scanner(System.in);
    final SquareLocationTranslator locator;
    public Board board;
    private BoardPrinter boardPrinter;

    private MinesweeperOptions options = new MinesweeperOptions();


    public Minesweeper(SquareLocationTranslator locator)
    {
        this.locator = locator;
    }


    public void play()
    {
        boolean isPlaying = true;

        board = new Board(options);
        boardPrinter = new BoardPrinter(board, locator);

        do
        {
            boardPrinter.print();

            try
            {
                awaitAndHandleUserInput();
            }
            catch (MineUncoveredException mue)
            {
                System.out.println("\nGame Over\n");

                boardPrinter.print();

                isPlaying = askToPlayAgain();
            }
        }
        while(isPlaying);
    }

    static int CHAR_CODE_ENTER = 10;

    private boolean askToPlayAgain() {

        do{
            System.out.print("\nPlay again? (y/n): ");

            String input = sc.nextLine();
            switch (input.toUpperCase())
            {
                case "Y": return true;
                case "N": return false;
                default: {}
            }
        }
        while(true);
    }

    private void awaitAndHandleUserInput() throws MineUncoveredException {
        String command = sc.nextLine();
        try
        {
            final Coordinate selectedCoordinate = locator.parseString(command);
            board.selectSquare(selectedCoordinate);
        }
        catch (ParseException pe)
        {
            System.out.println("Command '" + command + "' not recognized");
        }
    }
}

enum Difficulty {
    Infantile, Easy, Medium, Hard, Impossible
}
enum BoardSize {
    Small, Medium, Large
}