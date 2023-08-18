import java.util.Iterator;
import java.util.List;

public class BoardPrinter
{
    static int resolution = 3;
    public BoardPrinter(Board board)
    {
        this.board = board;
    }

    final Board board;

    public void draw()
    {
        System.out.print("╔");

        final Iterator<List<Square>> rowIterator = board.getRowIterator();
        while(rowIterator.hasNext())
        {
            final Iterator<Square> squareIterator = rowIterator.next().iterator();
            while(squareIterator.hasNext())
            {
                drawSquare(squareIterator.next());
            }

            System.out.println();
        }
    }

    private void drawSquare(Square square)
    {
        for (int i = 0; i < resolution; i++)
        {
            System.out.print("═");
        }
        System.out.print("╦");
    }
}
