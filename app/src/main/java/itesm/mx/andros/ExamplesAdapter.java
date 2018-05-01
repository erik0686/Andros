package itesm.mx.andros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;


public class ExamplesAdapter extends ArrayAdapter<Integer> {

    ImageView ivExample;

    public ExamplesAdapter(Context context, ArrayList<Integer> examples){
        super(context, 0, examples);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){


        View view = convertView;

        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.example_row, parent, false);
        }
        ivExample = view.findViewById(R.id.row_example_image);
        if(position == 0){
            ivExample.setImageResource(R.drawable.circulo1);

        }
        if(position == 1){
            ivExample.setImageResource(R.drawable.circulo2);

        }

        return view;
    }

}


