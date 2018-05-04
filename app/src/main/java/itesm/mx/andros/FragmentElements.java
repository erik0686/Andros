package itesm.mx.andros;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentElements extends Fragment implements View.OnClickListener {
    public int figSelected;
    Button btnCalculate;
    TextView tvX, tvH, tvY, tvK, tvR, tvFoco, tvCentro, tvDirectriz, tvDistFoc, tvEjeMa, tvEjeMe;

    public FragmentElements() {
    }

    public static FragmentElements newInstance(){
        return new FragmentElements();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_elements, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        selectEquation();

        tvFoco = view.findViewById(R.id.answer_foco);
        tvCentro = view.findViewById(R.id.answer_centro);
        tvDirectriz = view.findViewById(R.id.answer_directriz);
        tvDistFoc = view.findViewById(R.id.answer_distanciafocal);
        tvEjeMa = view.findViewById(R.id.answer_ejemayor);
        tvEjeMe = view.findViewById(R.id.answer_ejemenor);

        btnCalculate = view.findViewById(R.id.button_calcular);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_calcular) {
            switch (figSelected) {
                case 0:
                    calculateCircle();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }

   public void selectEquation(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        StandardEquation standardEquation= StandardEquation.newInstance();
        transaction.replace(R.id.display_equation, standardEquation, "FRAGMENT FORMULARIO" );
        standardEquation.figSelected = figSelected;
        transaction.commit();
    }

    public void calculateCircle() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvR = fr.getView().findViewById(R.id.result);

        if(tvX.getText().toString().equals(tvY.getText().toString())) {
            int x = Integer.parseInt(tvX.getText().toString());
            int h = Integer.parseInt(tvH.getText().toString());
            int y = Integer.parseInt(tvY.getText().toString());
            int k = Integer.parseInt(tvK.getText().toString());
            int r = Integer.parseInt(tvR.getText().toString());

            Circle circle = new Circle(x, h, y, k, r);

            tvCentro.setText(circle.getCenter());
        } else {
            Toast.makeText(getContext(), "El coeficiente de X tiene que ser igual que el coeficiente de Y", Toast.LENGTH_LONG).show();
        }
    }
}
