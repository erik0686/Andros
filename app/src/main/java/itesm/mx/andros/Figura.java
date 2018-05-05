package itesm.mx.andros;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

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
        center = "(" + String.valueOf((h*-1)/(double)x) + ", " + String.valueOf((k*-1)/(double)y) + ")";
        return center;
    }

    public String getVertex() {
        String vertex;
        vertex = "(" + String.valueOf(h) + ", " + String.valueOf(k) + ")";
        return vertex;
    }

    public String getFocusEllipse(){
        String foco;
        foco = "(" + String.valueOf((h*-1)/(double)x) + ", " +(((k*-1)/(double)y) + sqrt(abs(abs(a)-abs(b))) ) + ")";
        return foco;
    }


    public double getDiameter(){
        return Math.sqrt(r)/x * 2;
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

    // METODOS DE PARABOLA

    public String getVertexParabola(){
        String vertex;
        double valorX = (h*-1)/(double)(2*x);
        vertex = "(" + String.valueOf(valorX) + ", " + String.valueOf(x*valorX*valorX + h*valorX + k) + ")";
        return vertex;
    }

    public String getFocusParabola(){
        String focus;
        focus = "(" + String.valueOf((h*-1)/(double)(2*x)) + ", " + String.valueOf((4*x*k - (h*h) + 1)/ (double)(4*x) ) + ")";
        return focus;
    }

    public double getDirectrixParabola(){
        return (double)((4*x*k - (h*h) - 1)/ (double)(4*x) );
    }

    public double getLadoRecto(){

        return 4 * getDistanciaFocal();
    }

    public double getDistanciaFocal(){
        double verticeX = (h*-1)/(double)(2*x);
        double verticeY = 4*x*k - ((h*h) / (double)(4*x) );

        double focoX = ((h*-1)/(double)(2*x));
        double focoY = (4*x*k - (h*h) + (1/ (double)(4*x) ));

        if( (verticeY > 0 && focoY < 0)  ){
            return  verticeY - focoY;
        }
        else if (verticeY < 0 && focoY > 0){
            return  focoY - verticeY;
        }
        else {
            return abs(verticeY - focoY);
        }


    }
}
