package itesm.mx.andros;

/**
 * Created by LC on 5/3/2018.
 */

public class Figura {
    private int x;
    private int y;
    private int h;
    private int k;
    private int r;
    private int a;
    private int b;

    public Figura (int x, int y, int h, int k, int r, int a, int b) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.k = k;
        this.r = r;
        this.a = a;
        this.b = b;
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

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public String getCenter() {
        String center;
        center = "(" + String.valueOf(h*-1) + ", " + String.valueOf(k*-1) + ")";
        return center;
    }
}
