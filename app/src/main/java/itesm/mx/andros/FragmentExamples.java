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
                ArrayList<Integer> circleList = new ArrayList<>();
                circleList.add(R.drawable.circulo1);
                circleList.add(R.drawable.circulo2);

                ArrayAdapter<Integer> adapter = new ExamplesAdapter(getContext(), circleList);
                setListAdapter(adapter);


                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

}
