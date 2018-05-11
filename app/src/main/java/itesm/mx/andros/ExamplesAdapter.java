package itesm.mx.andros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;


public class ExamplesAdapter extends ArrayAdapter<Integer> {

    ImageView ivExample;
    private int [] array_figuras;
    public PhotoViewAttacher pvaAttacher;

    public ExamplesAdapter(Context context, ArrayList<Integer> examples, int[] int_array_drawable){
        super(context, 0, examples);
        array_figuras = int_array_drawable;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        View view = convertView;

        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.example_row, parent, false);
        }
        ivExample = view.findViewById(R.id.row_example_image);

        ivExample.setImageResource(array_figuras[position]);

        pvaAttacher = new PhotoViewAttacher(ivExample);

        return view;
    }

}


