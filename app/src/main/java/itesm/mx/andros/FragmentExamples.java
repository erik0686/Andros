package itesm.mx.andros;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class FragmentExamples extends ListFragment {
    ListView lvExamples;
    public int figSelected;

    public FragmentExamples() {
    }

    public static FragmentExamples newInstance(){return new FragmentExamples();}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Ejemplos Guiados");
        View view = inflater.inflate(R.layout.fragment_examples, container, false);

//        lvExamples.setImageResource(R.drawable.formulas);


        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        lvExamples = getListView();

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        fillListView(figSelected);
    }

    public void fillListView(int selected){
        switch (selected){
            case 0:
                int[] drawables_circulo = new int[2];

                ArrayList<Integer> circleList = new ArrayList<>();
                circleList.add(R.drawable.circulo1);
                circleList.add(R.drawable.circulo2);

                drawables_circulo[0] = R.drawable.circulo1;
                drawables_circulo[1] = R.drawable.circulo2;

                ArrayAdapter<Integer> adapter_circulo = new ExamplesAdapter(getContext(), circleList, drawables_circulo);
                setListAdapter(adapter_circulo);
                break;
            case 1:
                int[] drawables_elipse = new int[2];
                ArrayList<Integer> elipseList = new ArrayList<>();
                elipseList.add(R.drawable.elipse_eg1);
                elipseList.add(R.drawable.elipse_eg2);

                drawables_elipse[0] = R.drawable.elipse_eg1;
                drawables_elipse[1] = R.drawable.elipse_eg2;


                ArrayAdapter<Integer> adapter_elipse = new ExamplesAdapter(getContext(), elipseList, drawables_elipse);
                setListAdapter(adapter_elipse);
                break;
            case 2:
                int[] drawables_parabola = new int[2];
                ArrayList<Integer> parabolaList = new ArrayList<>();
                parabolaList.add(R.drawable.parabola1);
                parabolaList.add(R.drawable.parabola2);

                drawables_parabola[0] = R.drawable.parabola1;
                drawables_parabola[1] = R.drawable.parabola2;


                ArrayAdapter<Integer> adapter_parabola = new ExamplesAdapter(getContext(), parabolaList, drawables_parabola);
                setListAdapter(adapter_parabola);
                break;
            case 3:
                int[] drawables_hiperbola = new int[2];
                ArrayList<Integer> hiperbolaList = new ArrayList<>();
                hiperbolaList.add(R.drawable.hiperbola1);
                hiperbolaList.add(R.drawable.hiperbola2);

                drawables_hiperbola[0] = R.drawable.hiperbola1;
                drawables_hiperbola[1] = R.drawable.hiperbola2;


                ArrayAdapter<Integer> adapter_hiperbola = new ExamplesAdapter(getContext(), hiperbolaList, drawables_hiperbola);
                setListAdapter(adapter_hiperbola);
                break;
        }
    }

}
