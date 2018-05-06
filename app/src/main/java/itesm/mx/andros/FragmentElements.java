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
    TextView tvX, tvH, tvY, tvK, tvR, tvA, tvB, tvRow1Answer, tvRow2Answer, tvRow3Answer,
            tvRow4Answer, tvRow5Answer, tvRow6Answer, tvRow1, tvRow2, tvRow3, tvRow4, tvRow5, tvRow6;

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

        tvRow1Answer = view.findViewById(R.id.answer_foco);
        tvRow2Answer = view.findViewById(R.id.answer_centro);
        tvRow3Answer = view.findViewById(R.id.answer_directriz);
        tvRow4Answer = view.findViewById(R.id.answer_distanciafocal);
        tvRow5Answer = view.findViewById(R.id.answer_ejemayor);
        tvRow6Answer = view.findViewById(R.id.answer_ejemenor);
        tvRow1 = view.findViewById(R.id.text_foco);
        tvRow2 = view.findViewById(R.id.text_centro);
        tvRow3 = view.findViewById(R.id.text_directriz);
        tvRow4 = view.findViewById(R.id.text_distanciafocal);
        tvRow5 = view.findViewById(R.id.text_ejemayor);
        tvRow6 = view.findViewById(R.id.text_ejemenor);

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
                    calculateHyperbola();
                    break;
            }
        }
    }

    public void selectEquation(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        StandardEquation standardEquation= StandardEquation.newInstance();
        transaction.replace(R.id.display_equation, standardEquation, "FRAGMENT FORMULARIO" );
        standardEquation.figSelected = figSelected;
        standardEquation.typeEquation = figSelected == 3 ? false : true;
        transaction.commit();
    }

    public void displayElements(){
        switch (figSelected) {
            case 0:
                tvRow1.setText("Centro: ");
                tvRow2.setText("Diámetro: ");
                tvRow2Answer.setHint("n");

                tvRow3.setVisibility(View.INVISIBLE);
                tvRow3Answer.setVisibility(View.INVISIBLE);
                tvRow4.setVisibility(View.INVISIBLE);
                tvRow4Answer.setVisibility(View.INVISIBLE);
                break;
            case 1:
                tvRow1.setText("Centro: ");
                tvRow2.setText("Foco: ");
                tvRow3.setText("Eje Mayor: ");
                tvRow4.setText("Eje Menor: ");
                break;
            case 2:
                tvRow1.setText("Vértice: ");
                tvRow2.setText("Foco: ");
                tvRow3.setText("Directriz: ");
                tvRow4.setText("Lado Recto: ");
                break;
            case 3:
                tvRow1.setText("Vértice: ");
                tvRow2.setText("Foco: ");
                tvRow3.setText("Centro: ");
                tvRow3Answer.setHint("(x, y)");
                tvRow4.setText("Lado Recto: ");
                break;
        }
        tvRow5.setVisibility(View.INVISIBLE);
        tvRow5Answer.setVisibility(View.INVISIBLE);
        tvRow6.setVisibility(View.INVISIBLE);
        tvRow6Answer.setVisibility(View.INVISIBLE);
    }

    public void calculateCircle() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvR = fr.getView().findViewById(R.id.result);

        int x, h, y, k, r;

        if (tvH.getText().toString().equals("-") || tvK.getText().toString().equals("-")){
            Toast.makeText(getContext(), "Valor inválido en alguno de los campos: H ó K",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvX.getText().toString().equals(tvY.getText().toString())) {
            if(tvR.getText().toString().equals("") || tvR.getText().toString().equals("0")) {
                Toast.makeText(getContext(), "El Radio cuadrado debe ser mayor a 0", Toast.LENGTH_LONG).show();
            }
            else {
                if(tvX.getText().toString().equals("")) { x = 1;}
                    else if(tvX.getText().toString().equals("-")) {x = -1;}
                    else {x = Integer.parseInt(tvX.getText().toString());}
                if(tvH.getText().toString().equals("")) { h = 0;} else {h = Integer.parseInt(tvH.getText().toString());}
                if(tvY.getText().toString().equals("")) { y = 1;}
                    else if(tvY.getText().toString().equals("-")) {y = -1;}
                    else {y = Integer.parseInt(tvY.getText().toString());}
                if(tvK.getText().toString().equals("")) { k = 0;} else {k = Integer.parseInt(tvK.getText().toString());}
                r = Integer.parseInt(tvR.getText().toString());
                Figura circle = new Figura(x, y, h, k, r, 0, 0);
                tvRow1Answer.setText(circle.getCenter());
                tvRow2Answer.setText(String.valueOf(circle.getDiameter()));
            }
        }
        else {
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

        if(tvA.getText().toString().equals("0") || tvB.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "Los valores de A y B no pueden ser 0",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvX.getText().toString().equals("0") || tvY.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "Los coeficientes de X y Y no pueden ser 0",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvR.getText().toString().equals("") || tvR.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "La igualdad debe ser un valor mayor a 0 (positivo)",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvH.getText().toString().equals("-") || tvK.getText().toString().equals("-") ||
                tvA.getText().toString().equals("-") || tvB.getText().toString().equals("-")){
            Toast.makeText(getContext(), "Valor inválido en alguno de los campos: A, B, H ó K",
                    Toast.LENGTH_LONG).show();
        }
        else {
            int x, h, a, y, k, b, r;
            if(tvX.getText().toString().equals("")) { x = 1;}
                else if(tvX.getText().toString().equals("-")) {x = -1;}
                else {x = Integer.parseInt(tvX.getText().toString());}
            if(tvH.getText().toString().equals("")) { h = 0;} else {h = Integer.parseInt(tvH.getText().toString());}
            if(tvA.getText().toString().equals("")) { a = 1;}
                else {a = Integer.parseInt(tvA.getText().toString());}
            if(tvY.getText().toString().equals("")) { y = 1;}
                else if(tvY.getText().toString().equals("-")) {y = -1;}
                else {y = Integer.parseInt(tvY.getText().toString());}
            if(tvK.getText().toString().equals("")) { k = 0;} else {k = Integer.parseInt(tvK.getText().toString());}
            if(tvB.getText().toString().equals("")) { b = 1;}
                else {b = Integer.parseInt(tvB.getText().toString());}
            r = Integer.parseInt(tvR.getText().toString());

            Figura elipse = new Figura(x, y, h, k, r, a, b);

            tvRow1Answer.setText(elipse.getCenter());
            tvRow2Answer.setText(elipse.getFoco());
            tvRow3Answer.setText(String.valueOf(elipse.getEjeMayor()));
            tvRow4Answer.setText(String.valueOf(elipse.getEjeMenor()));
        }
    }

    public void calculateParabola() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvK = fr.getView().findViewById(R.id.k_coeficiente);

        if(tvX.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "El coeficiente de X^2 debe ser diferente a 0", Toast.LENGTH_LONG).show();
        }
        else if (tvK.getText().toString().equals("-")){
            Toast.makeText(getContext(), "Valor inválido en K", Toast.LENGTH_LONG).show();
        }
        else {
            int x, h, k;

            if(tvX.getText().toString().equals("")) { x = 1;}
                else if(tvX.getText().toString().equals("-")) {x = -1;}
                else {x = Integer.parseInt(tvX.getText().toString());}
            if(tvH.getText().toString().equals("")) { h = 1;}
                else if(tvH.getText().toString().equals("-")) {h = -1;}
                else {h = Integer.parseInt(tvH.getText().toString());}
            if(tvK.getText().toString().equals("")) { k = 0;} else {k = Integer.parseInt(tvK.getText().toString());}

            Figura parabola = new Figura(x, 0, h, k, 0, 0, 0);

            tvRow1Answer.setText(parabola.getVertexParabola());
            tvRow2Answer.setText(parabola.getFoco());
            tvRow3Answer.setText(String.valueOf(parabola.getDirectriz()));
            tvRow4Answer.setText(String.valueOf(parabola.getLadoRecto()));
        }
    }

    public void calculateHyperbola() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvA = fr.getView().findViewById(R.id.x_div);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvB = fr.getView().findViewById(R.id.y_div);

        tvR = fr.getView().findViewById(R.id.result);

        if(tvA.getText().toString().equals("0") || tvB.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "Los valores de A y B no pueden ser 0",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvX.getText().toString().equals("0") || tvY.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "Los coeficientes de X y Y no pueden ser 0",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvR.getText().toString().equals("") || tvR.getText().toString().equals("0")) {
            Toast.makeText(getContext(), "La igualdad debe ser un valor mayor a 0 (positivo)",
                    Toast.LENGTH_LONG).show();
        }
        else if (tvH.getText().toString().equals("-") || tvK.getText().toString().equals("-") ||
                tvA.getText().toString().equals("-") || tvB.getText().toString().equals("-")){
            Toast.makeText(getContext(), "Valor inválido en alguno de los campos: A, B, H ó K",
                    Toast.LENGTH_LONG).show();
        }
        else {
            int x, h, a, y, k, b, r;
            if(tvX.getText().toString().equals("")) { x = 1;}
                else if(tvX.getText().toString().equals("-")) {x = -1;}
                else {x = Integer.parseInt(tvX.getText().toString());}
            if(tvH.getText().toString().equals("")) { h = 0;} else {h = Integer.parseInt(tvH.getText().toString());}
            if(tvA.getText().toString().equals("")) { a = 1;}
                else {a = Integer.parseInt(tvA.getText().toString());}
            if(tvY.getText().toString().equals("")) { y = 1;}
                else if(tvY.getText().toString().equals("-")) {y = -1;}
                else {y = Integer.parseInt(tvY.getText().toString());}
            if(tvK.getText().toString().equals("")) { k = 0;} else {k = Integer.parseInt(tvK.getText().toString());}
            if(tvB.getText().toString().equals("")) { b = 1;}
             else {b = Integer.parseInt(tvB.getText().toString());}
            r = Integer.parseInt(tvR.getText().toString());

            Figura hyperbola = new Figura(x, y, h, k, r, a, b);

            tvRow1Answer.setText(hyperbola.getVertex());
            tvRow2Answer.setText(hyperbola.getFoco());
            tvRow3Answer.setText(hyperbola.getCenter());
            tvRow4Answer.setText(String.valueOf(hyperbola.getLadoRecto()));
        }
    }
}
