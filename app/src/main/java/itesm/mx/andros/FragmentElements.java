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
    TextView tvX, tvH, tvY, tvK, tvR, tvFoco, tvCentro, tvDirectriz, tvDistFoc, tvEjeMa, tvEjeMe,
    tvDir, tvDF, tvFo, tvEMA, tvEME, tvCen, tvA, tvB;

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
        tvFo = view.findViewById(R.id.text_foco);
        tvCen = view.findViewById(R.id.text_centro);
        tvDir = view.findViewById(R.id.text_directriz);
        tvDF = view.findViewById(R.id.text_distanciafocal);
        tvEMA = view.findViewById(R.id.text_ejemayor);
        tvEME = view.findViewById(R.id.text_ejemenor);

        btnCalculate = view.findViewById(R.id.button_calcular);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        displayElements();

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
                    calculateEllipse();
                    break;
                case 2:
                    calculateParabola();
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

    public void displayElements(){
        switch (figSelected) {
            case 0:
                tvCen.setText("Centro: ");
                tvEMA.setText("Diámetro: ");
                tvFo.setVisibility(View.INVISIBLE);
                tvFoco.setVisibility(View.INVISIBLE);
                tvDir.setVisibility(View.INVISIBLE);
                tvDirectriz.setVisibility(View.INVISIBLE);
                tvDistFoc.setVisibility(View.INVISIBLE);
                tvDF.setVisibility(View.INVISIBLE);
                tvEME.setVisibility(View.INVISIBLE);
                tvEjeMe.setVisibility(View.INVISIBLE);
                break;
            case 1:
                tvCen.setText("Centro: ");
                tvEMA.setText("Eje Mayor: ");
                tvEME.setText("Eje Menor: ");
                tvFo.setVisibility(View.INVISIBLE);
                tvFoco.setVisibility(View.INVISIBLE);
                tvDir.setVisibility(View.INVISIBLE);
                tvDirectriz.setVisibility(View.INVISIBLE);
                tvDistFoc.setVisibility(View.INVISIBLE);
                tvDF.setVisibility(View.INVISIBLE);
                break;
            case 2:
                tvCen.setText("Vértice");
                tvEMA.setText("Lado Recto");
                tvFo.setVisibility(View.VISIBLE);
                tvFoco.setVisibility(View.VISIBLE);
                tvDir.setVisibility(View.VISIBLE);
                tvDirectriz.setVisibility(View.VISIBLE);

                tvDistFoc.setVisibility(View.INVISIBLE);
                tvDF.setVisibility(View.INVISIBLE);
                tvEME.setVisibility(View.INVISIBLE);
                tvEjeMe.setVisibility(View.INVISIBLE);
                break;
            case 3:
                tvEMA.setText("Eje Focal");

                tvDir.setVisibility(View.INVISIBLE);
                tvDirectriz.setVisibility(View.INVISIBLE);
                tvDistFoc.setVisibility(View.INVISIBLE);
                tvDF.setVisibility(View.INVISIBLE);
                tvEME.setVisibility(View.INVISIBLE);
                tvEjeMe.setVisibility(View.INVISIBLE);
                break;
        }
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

            Figura circle = new Figura(x, y, h, k, r, 0, 0);

            tvCentro.setText(circle.getCenter());
            tvEjeMa.setText(String.valueOf(circle.getDiameter()));
        } else {
            Toast.makeText(getContext(), "El coeficiente de X tiene que ser igual que el coeficiente de Y", Toast.LENGTH_LONG).show();
        }
    }

    public void calculateEllipse() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvA = fr.getView().findViewById(R.id.x_div);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvB = fr.getView().findViewById(R.id.y_div);

        tvR = fr.getView().findViewById(R.id.result);

        if(tvX.getText().toString().equals(tvY.getText().toString())) {
            int x = Integer.parseInt(tvX.getText().toString());
            int h = Integer.parseInt(tvH.getText().toString());
            int a = Integer.parseInt(tvA.getText().toString());
            int y = Integer.parseInt(tvY.getText().toString());
            int k = Integer.parseInt(tvK.getText().toString());
            int r = Integer.parseInt(tvR.getText().toString());
            int b = Integer.parseInt(tvB.getText().toString());


            Figura circle = new Figura(x, y, h, k, r, a, b);

            tvCentro.setText(circle.getCenter());
            tvEjeMa.setText(String.valueOf(circle.getEjeMayor()));
            tvEjeMe.setText(String.valueOf(circle.getEjeMenor()));

        } else {
            Toast.makeText(getContext(), "El coeficiente de X tiene que ser igual que el coeficiente de Y", Toast.LENGTH_LONG).show();
        }
    }

    public void calculateParabola() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvA = fr.getView().findViewById(R.id.a_coeficiente);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);

        if(tvX.getText().toString().equals(tvY.getText().toString())) {
            int x = Integer.parseInt(tvX.getText().toString());
            int h = Integer.parseInt(tvH.getText().toString());
            int a = Integer.parseInt(tvA.getText().toString());
            int y = Integer.parseInt(tvY.getText().toString());
            int k = Integer.parseInt(tvK.getText().toString());


            Figura parabola = new Figura(x, y, h, k, 0, a, 0);

            tvFoco.setText(parabola.getFoco());
            tvCentro.setText(parabola.getVertexParabola());

            tvDirectriz.setText(String.valueOf(parabola.getDirectriz()));
            tvEjeMa.setText(String.valueOf(parabola.getLadoRecto()));

        } else {
            Toast.makeText(getContext(), "El coeficiente de X tiene que ser igual que el coeficiente de Y", Toast.LENGTH_LONG).show();
        }
    }
}
