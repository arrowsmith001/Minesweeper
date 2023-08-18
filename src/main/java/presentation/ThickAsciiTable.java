package presentation;

public class ThickAsciiTable extends AsciiTableStringSet {

    @Override
    public String topLeftCorner() {
        return "╔";
    }

    @Override
    public String topRightCorner() {
        return "╗";
    }

    @Override
    public String bottomLeftCorner() {
        return "╚";
    }

    @Override
    public String bottomRightCorner() {
        return "╝";
    }

    @Override
    public String junction() {
        return "╬";
    }

    @Override
    public String leftJunction() {
        return "╠";
    }

    @Override
    public String rightJunction() {
        return "╣";
    }

    @Override
    public String topJunction() {
        return "╦";
    }

    @Override
    public String bottomJunction() {
        return "╩";
    }

    @Override
    public String floor() {
        return "═";
    }

    @Override
    public String wall() {
        return "║";
    }
}
