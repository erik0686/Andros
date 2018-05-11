package itesm.mx.andros;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;


public class FragmentFormulario extends Fragment {

    ImageView Imagen_formulas;
    PhotoViewAttacher pvaAttacher;


    public FragmentFormulario() {
    }

    public static FragmentFormulario newInstance(){
        return new FragmentFormulario();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Formulario");
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);

        Imagen_formulas = view.findViewById(R.id.formulario);
        Imagen_formulas.setImageResource(R.drawable.formulas);
        pvaAttacher = new PhotoViewAttacher(Imagen_formulas);
        return view;
    }
}
