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

    public String getVertex() {
        String vertex;
        vertex = "(" + String.valueOf(h) + ", " + String.valueOf(k) + ")";
        return vertex;
    }

    public String getVertexParabola() {
        String vertex;
        vertex = "(" + String.valueOf((double)(h*-1) / (double)x) + ", " + String.valueOf(((double)(k*-1) / (double)(y))) + ")";
        return vertex;
    }

    public double getDirectriz(){
        return ((double) k / y) - (((double) a * y) / 4);
    }

    public String getFoco(){
        String foco;
        foco = "(" + String.valueOf((double)((h*-1) / x )) + ", " + String.valueOf(((double) k / y) + (((double) a * y) / 4)) + ")";
        return foco;
    }

    public float getDistanciaFocal(){

        return a;
    }

    public double getDiameter(){
        return Math.sqrt(r) * 2;
    }

    public double getEjeMayor(){
        if (2*a > 2*b) {
            return 2 * a;
        }else{
            return 2*b;
        }
    }

    public double getEjeMenor(){
        if (2*b < 2*a) {
            return 2 * b;
        }else{
            return 2*a;
        }
    }

    public double getLadoRecto(){
        double laRo = ((double)(k*-1) / (double)(y));

        return 4 * a;
    }
}
