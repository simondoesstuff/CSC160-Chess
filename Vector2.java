package simonwalker;

public class Vector2 {
    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    // ---


    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}
