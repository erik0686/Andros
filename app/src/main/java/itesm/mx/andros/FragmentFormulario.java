package itesm.mx.andros;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragmentFormulario extends Fragment {

    ImageView Imagen_formulas;


    public FragmentFormulario() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        Imagen_formulas = view.findViewById(R.id.formulario);
        Imagen_formulas.setImageResource(R.drawable.formulas);
        return view;
    }
}
