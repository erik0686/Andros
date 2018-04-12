package itesm.mx.andros;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by erik on 11/04/18.
 */

public class MenuSection extends Application {

    private ArrayList<Section> listaSections;
    public void setListaSections() { listaSections = getListaSections(); }
    public Section getElectrodomestico(int index) { return listaSections.get(index); }

    public ArrayList<Section> getListaSections(){
        Section section;
        listaSections = new ArrayList<Section>();


        section = new Section(1, "Formulario", "Consulta las ecuaciones que usarás a lo largo de esta aplicación", 1);
        listaSections.add(section);

        section = new Section(2, "Ejemplos Guiados", "Revisa algunos ejemplos con soluciones de las secciones cónicas", 2);
        listaSections.add(section);

        section = new Section(3, "Elementos de gráficas", "Identifica los elementos de una gráfica a partir de su ecuación", 3);
        listaSections.add(section);

        section = new Section(4, "Transformar ecuaciones", "Transforma ecuaciones de su forma estandar a general y viceversa", 4);
        listaSections.add(section);

        section = new Section(5, "Innovación", "Grafica tus propias ecuaciones en esta seccion de innovación", 5);
        listaSections.add(section);

        section = new Section(1, "Instrucciones", "En esta sección puedes encontrar las instrucciones del funcionamiento del resto de las secciones de esta App", 6);
        listaSections.add(section);


        return listaSections;
    }
}
