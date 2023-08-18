import java.util.Scanner;

public class Minesweeper {

    final SquareLocator locator;
    public Board board;
    private BoardPrinter boardPrinter;

    final Scanner sc = new Scanner(System.in);

    public Minesweeper(SquareLocator locator)
    {
        this.locator = locator;

    }
    // TODO: Replace square Hashmap with double array
// TODO: Board print
    public void play()
    {
        board = new Board(locator, new MinesweeperOptions());
        boardPrinter = new BoardPrinter(board);

        while(true)
        {
            String s = sc.nextLine();
            boardPrinter.draw();
            System.out.println("12");
        }
    }
}

enum Difficulty {
    Infantile, Easy, Medium, Hard, Impossible
}
enum BoardSize {
    Small, Medium, Large
}