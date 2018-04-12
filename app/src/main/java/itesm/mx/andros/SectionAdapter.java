package itesm.mx.andros;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by erik on 11/04/18.
 */

public class SectionAdapter extends ArrayAdapter<Section> {
    TextView tvTitulo;
    TextView tvDescription;
    ImageView ivImagen;


    public SectionAdapter(Context context, ArrayList<Section> sections){
        super(context, 0, sections);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Section section = getItem(position);

        View view = convertView;

        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.main_menu_row, parent, false);
        }
        tvTitulo = view.findViewById(R.id.menu_title);
        tvDescription = view.findViewById(R.id.menu_description);
        ivImagen = view.findViewById(R.id.menu_image);
        tvTitulo.setText(section.getTitle());
        tvDescription.setText(section.getDescription());
        ivImagen.setImageResource(section.getIdImagen());

        return view;
    }
}
