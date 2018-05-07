package itesm.mx.andros;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentInstrucciones extends Fragment {

    TextView tvInstruccionesFormulario, tvInstruccionesEjemplos, tvInstruccionesElementos,tvInstruccionesEcuaciones,tvInstruccionesInnovacion;
    TextView tvInstruccionesTextoFormulario, tvInstruccionesTextoEjemplos, tvInstruccionesTextoElementos,tvInstruccionesTextoEcuaciones,tvInstruccionesTextoInnovacion;


    public FragmentInstrucciones() {
    }

    public static FragmentInstrucciones newInstance(){
        return new FragmentInstrucciones();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Instrucciones");
        View view = inflater.inflate(R.layout.fragment_instructions, container, false);

        tvInstruccionesFormulario = view.findViewById(R.id.tituloFormulario);
        tvInstruccionesEjemplos = view.findViewById(R.id.tituloEjemplos);
        tvInstruccionesElementos = view.findViewById(R.id.tituloElementos);
        tvInstruccionesEcuaciones = view.findViewById(R.id.tituloEcuaciones);
        tvInstruccionesInnovacion = view.findViewById(R.id.tituloInnovacion);

        tvInstruccionesTextoFormulario = view.findViewById(R.id.textoFormulario);
        tvInstruccionesTextoEjemplos = view.findViewById(R.id.textoEjemplos);
        tvInstruccionesTextoElementos = view.findViewById(R.id.textoElementos);
        tvInstruccionesTextoEcuaciones = view.findViewById(R.id.textoEcuaciones);
        tvInstruccionesTextoInnovacion = view.findViewById(R.id.textoInnovacion);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        tvInstruccionesFormulario.setText("Formulario");
        tvInstruccionesEjemplos.setText("Ejemplos Guiados");
        tvInstruccionesElementos.setText("Elementos de Gráfica");
        tvInstruccionesEcuaciones.setText("Transformar Ecuaciones");
        tvInstruccionesInnovacion.setText("Recursos Audiovisuales");

        tvInstruccionesTextoFormulario.setText(R.string.InstruccionesFormulario);
        tvInstruccionesTextoEjemplos.setText(R.string.InstruccionesEjemplos);
        tvInstruccionesTextoElementos.setText(R.string.InstruccionesElementos);
        tvInstruccionesTextoEcuaciones.setText(R.string.InstruccionesEcuaciones);
        tvInstruccionesTextoInnovacion.setText(R.string.InstruccionesInnovacion);
    }
}
