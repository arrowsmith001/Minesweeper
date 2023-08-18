package presentation;

public class PlaceHolderAsciiTable extends AsciiTableStringSet {

    @Override
    public String topLeftCorner() {
        return "";
    }

    @Override
    public String topRightCorner() {
        return "";
    }

    @Override
    public String bottomLeftCorner() {
        return "";
    }

    @Override
    public String bottomRightCorner() {
        return "";
    }

    @Override
    public String junction() {
        return "";
    }

    @Override
    public String leftJunction() {
        return wall();
    }

    @Override
    public String rightJunction() {
        return wall();
    }

    @Override
    public String topJunction() {
        return floor();
    }

    @Override
    public String bottomJunction() {
        return floor();
    }

    @Override
    public String floor() {
        return "_";
    }

    @Override
    public String wall() {
        return "|";
    }
}
