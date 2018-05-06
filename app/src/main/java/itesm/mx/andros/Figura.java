package itesm.mx.andros;

import java.math.BigDecimal;

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
        center = "(" + String.valueOf(truncateDecimal((((h*-1)/(double)x)),2)    ) + ", " + String.valueOf(truncateDecimal(((k*-1)/(double)y),2)) + ")";
        return center;
    }

    public String getVertex() {
        String vertex;
        vertex = "(" + String.valueOf(h) + ", " + String.valueOf(k) + ")";
        return vertex;
    }

    public String getFocusEllipse(){
        String foco;
        foco = "(" + String.valueOf(truncateDecimal(((h*-1)/(double)x),2)) + ", " + truncateDecimal((((k*-1)/(double)y) + sqrt(abs(abs(a)-abs(b))) ),2) + ")";
        return foco;
    }

    public String getFocusHiperbola(){
        String foco;
        foco = "(" + String.valueOf(((h*-1)/(double)x)+sqrt(abs(abs(a)+abs(b)))) + ", " +(((k*-1)/(double)y)  ) + ")";
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
        vertex = "(" + String.valueOf(truncateDecimal(valorX,2)) + ", " + String.valueOf(truncateDecimal((x*valorX*valorX + h*valorX + k),2)) + ")";
        return vertex;
    }

    public String getFocusParabola(){
        String focus;
        focus = "(" + String.valueOf(truncateDecimal(((h*-1)/(double)(2*x)),2)) + ", " + String.valueOf(truncateDecimal(((4*x*k - (h*h) + 1)/ (double)(4*x)),2) ) + ")";
        return focus;
    }

    public double getDirectrixParabola(){

        return truncateDecimal(((4*x*k - (h*h) - 1)/ (double)(4*x) ),2).doubleValue();
    }

    public double getLadoRecto(){

        return truncateDecimal((4 * getDistanciaFocal()),2).doubleValue();
    }

    public double getDistanciaFocal(){
        double verticeX = (h*-1)/(double)(2*x);
        double verticeY = x*verticeX*verticeX + h*verticeX + k;

        double focoX = ((h*-1)/(double)(2*x));
        double focoY = ((4*x*k - (h*h) + 1)/ (double)(4*x));

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

    public String getCenterHiperbola() {
        String center;
        center = "(" + String.valueOf(truncateDecimal((((h*-1)/(double)x)),2)    ) + ", " + String.valueOf(truncateDecimal(((k*-1)/(double)y),2)) + ")";
        return center;
    }

    private static BigDecimal truncateDecimal(double x,int numberofDecimals)
    {
        if ( x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_FLOOR);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }
}
