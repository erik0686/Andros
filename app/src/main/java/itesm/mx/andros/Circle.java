package itesm.mx.andros;

/**
 * Created by lc on 3/05/18.
 */

public class Circle {
    private int x;
    private int y;
    private int h;
    private int k;
    private int r;

    public Circle (int x, int y, int h, int k, int r) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getK() {
        return k;
    }

    public int getR() {
        return r;
    }

    public String getCenter() {
        String center;
        center = "(" + String.valueOf(h*-1) + ", " + String.valueOf(k*-1) + ")";
        return center;
    }
}
