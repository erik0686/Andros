package itesm.mx.andros;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentEcuations extends Fragment implements View.OnClickListener, Spinner.OnItemSelectedListener{
    public boolean typeSelected = true;
    public int figSelected, eqExample;
    String[][] anCircleGen = {{"1", "1", "0", "1", "1", "0", "16"}, {"1", "1", "-1", "1", "1", "1", "4"},
            {"2", "1", "-3", "2", "1", "-5", "49"}, {"1", "1", "0", "1", "1", "-3", "100"}, {"4", "1", "-2", "4", "1", "-3", "1"}};
    String[][] anCircleStan = {{"1", "1", "0", "0", "-16", "0"}, {"1", "1", "-2", "2", "-2", "0"},
            {"2", "2", "-12", "-20", "19", "0"}, {"1", "1", "0", "-6", "-91", "0"}, {"4", "4", "-16", "-24", "51", "0"}};
    String[][] anElipseGen = {{"1", "0", "25", "1", "0", "16", "1"}, {/*Poner ejemplo sin fracciones*/},
            {"1", "0", "4", "1", "0", "16", "1"}, {"1", "-2", "9", "1", "0", "16", "1"}, {/*Poner ejemplo sin fracciones*/}};
    String[][] anElipseStan = {{"16", "25", "0", "0", "-400", "0"}, {/*Poner ejemplo sin fracciones*/},
            {"4", "1", "0", "0", "-16", "0"}, {"16", "9", "-64", "0", "-80", "0" }, {/*Poner ejemplo sin fracciones*/}};
    String[][] anParabolaGen = {{"1", "0", "1", "1", "0"}, {"1", "-1", "4", "1", "-1"}, {"1", "-6", "8", "1", "2"},
            {"1", "2", "1", "1", "-3"}, {"1", "-6", "1", "9", "0"}};
    String[][] anParabolaStan = {{"1", "0", "0", "-1", "0", "0"}, {"1", "0", "-2", "-4", "5", "0"},
            {"1", "0", "-12", "-8", "20", "0"}, {"0", "1", "-1", "4", "7", "0"}, {"0", "1", "-9", "-12", "36", "0"}};
    String[][] anHyperGen = {{"1", "0", "25", "4", "0", "25", "1"}, {"1", "-1", "9", "1", "-2", "9", "1"},
            {"1", "0", "4", "1", "0", "16", "1"}, {"1", "-2", "9", "1", "0", "16", "1"}, {/*Poner ejemplo sin fracciones*/}};
    String[][] anHyperStan = {{"1", "-4", "0", "0", "-25", "0"}, {"1", "-1", "-2", "4", "-12", "0"},
            {"4", "-1", "0", "0", "-16", "0"}, {"16", "-9", "-64", "0", "-80", "0"}, {/*Poner ejemplo sin fracciones*/}};
    int[] circleStan = {R.drawable.circuloestandar0, R.drawable.circuloestandar1,
            R.drawable.circuloestandar2, R.drawable.circuloestandar3, R.drawable.circuloestandar4};
    int[] circleGen = {R.drawable.circulogeneral0, R.drawable.circulogeneral1,
            R.drawable.circulogeneral2, R.drawable.circulogeneral3, R.drawable.circulogeneral4};
    int[] ellipseStan = {R.drawable.elipseestandar0, R.drawable.elipseestandar1,
            R.drawable.elipseestandar2, R.drawable.elipseestandar3, R.drawable.elipseestandar4};
    int[] ellipseGen = {R.drawable.elipsegeneral0, R.drawable.elipsegeneral1,
            R.drawable.elipsegeneral2, R.drawable.elipsegeneral3, R.drawable.elipsegeneral4};
    int[] parabolaStan = {R.drawable.parabolaestandar0, R.drawable.parabolaestandar1,
            R.drawable.parabolaestandar2, R.drawable.parabolaestandar3, R.drawable.parabolaestandar4};
    int[] parabolaGen = {R.drawable.parabolageneral0, R.drawable.parabolageneral1,
            R.drawable.parabolageneral2, R.drawable.parabolageneral3, R.drawable.parabolageneral4};
    int[] hyperbolaStan = {R.drawable.hiperbolaestandar0, R.drawable.hiperbolaestandar1,
            R.drawable.hiperbolaestandar2, R.drawable.hiperbolaestandar3, R.drawable.hiperbolaestandar4};
    int[] hyperbolaGen = {R.drawable.hiperbolageneral0, R.drawable.hiperbolageneral1,
            R.drawable.hiperbolageneral2, R.drawable.hiperbolageneral3, R.drawable.hiperbolageneral4};
    Button btnCalculate, btnNew, btnSolution;
    TextView tvX, tvH, tvY, tvK, tvR, tvA, tvB, tvC, tvD, tvE, tvResult;
    Spinner spinnerEquation;
    ImageView ivEquation, ivSolution;

    public FragmentEcuations() {}

    public static FragmentEcuations newInstance(){
        return new FragmentEcuations();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ecuations, container, false);
        eqExample = 0;
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        selectEquation();

        btnNew = view.findViewById(R.id.button_new);
        btnCalculate = view.findViewById(R.id.button_calcular);
        btnSolution = view.findViewById(R.id.button_solution);
        ivEquation = view.findViewById(R.id.image_equation);
        ivSolution = view.findViewById(R.id.image_solution);
        tvResult = view.findViewById(R.id.text_respuesta);

        btnNew.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
        btnSolution.setOnClickListener(this);

        tvResult.setText(R.string.EcuacionResultado);

        spinnerEquation = view.findViewById(R.id.spinner_equationType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_equations_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquation.setAdapter(adapter);
        spinnerEquation.setOnItemSelectedListener(this);

        ivEquation.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        ivSolution.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

        displayEquation();
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
        switch (view.getId()) {
            case R.id.button_new:
                eqExample++;
                if(eqExample == 5) { eqExample = 0; }
                ivSolution.setImageDrawable(null);
                tvResult.setText(R.string.EcuacionResultado);
                tvResult.setTextColor(Color.parseColor("#808080"));
                displayEquation();
                break;
            case R.id.button_calcular:
                if(figSelected == 0 && typeSelected) {calculateCircleStan(); }
                else if(figSelected == 0 && !typeSelected) {calculateCircleGen(); }

                break;
            case R.id.button_solution:
                displaySolution();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        typeSelected = i == 0 ? true : false;
        ivSolution.setImageDrawable(null);
        tvResult.setText(R.string.EcuacionResultado);
        tvResult.setTextColor(Color.parseColor("#808080"));
        selectEquation();
        displayEquation();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void selectEquation(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        StandardEquation standardEquation= StandardEquation.newInstance();
        transaction.replace(R.id.display_equation, standardEquation, "FRAGMENT EQUATION" );
        standardEquation.figSelected = figSelected;
        standardEquation.typeEquation = typeSelected;
        standardEquation.viewElements = false;
        transaction.commit();
    }

    public void displayEquation() {
        if (typeSelected) {
            if (figSelected == 0) {ivEquation.setImageResource(circleGen[eqExample]);}
            else if (figSelected == 1) {ivEquation.setImageResource(ellipseGen[eqExample]);}
            else if (figSelected == 2) {ivEquation.setImageResource(parabolaGen[eqExample]);}
            else {ivEquation.setImageResource(hyperbolaGen[eqExample]);}
        }
        else {
            if (figSelected == 0) {ivEquation.setImageResource(circleStan[eqExample]);}
            else if (figSelected == 1) {ivEquation.setImageResource(ellipseStan[eqExample]);}
            else if (figSelected == 2) {ivEquation.setImageResource(parabolaStan[eqExample]);}
            else {ivEquation.setImageResource(hyperbolaStan[eqExample]);}
        }
    }

    public void displaySolution() {
        if (!typeSelected) {
            if (figSelected == 0) {ivSolution.setImageResource(circleGen[eqExample]);}
            else if (figSelected == 1) {ivSolution.setImageResource(ellipseGen[eqExample]);}
            else if (figSelected == 2) {ivSolution.setImageResource(parabolaGen[eqExample]);}
            else {ivSolution.setImageResource(hyperbolaGen[eqExample]);}
        }
        else {
            if (figSelected == 0) {ivSolution.setImageResource(circleStan[eqExample]);}
            else if (figSelected == 1) {ivSolution.setImageResource(ellipseStan[eqExample]);}
            else if (figSelected == 2) {ivSolution.setImageResource(parabolaStan[eqExample]);}
            else {ivSolution.setImageResource(hyperbolaStan[eqExample]);}
        }
    }

    public void calculateCircleStan() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        String x, y, h, k, a, b, r;
        tvA = fr.getView().findViewById(R.id.acircle_coeficiente);
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvB = fr.getView().findViewById(R.id.bcircle_coeficiente);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvR = fr.getView().findViewById(R.id.result);
        if(tvA.getText().toString().equals("")) { a = "1";} else {a = tvH.getText().toString();}
        if(tvX.getText().toString().equals("")) { x = "1";}
            else if(tvX.getText().toString().equals("-")) {x = "-1";}
            else {x = tvX.getText().toString();}
        if(tvH.getText().toString().equals("")) { h = "0";} else {h = tvH.getText().toString();}
        if(tvB.getText().toString().equals("")) { b = "1";} else {b = tvH.getText().toString();}
        if(tvY.getText().toString().equals("")) { y = "1";}
            else if(tvY.getText().toString().equals("-")) {y = "-1";}
            else {y = tvY.getText().toString();}
        if(tvK.getText().toString().equals("")) { k = "0";} else {k = tvK.getText().toString();}
        r = tvR.getText().toString();
        String[] values = {a, x, h, b, y, k, r};
        int j = 0;
        for(int i = 0; i < 7; i++) {
            if (anCircleGen[eqExample][i].equals(values[i])) {
                j++;
            }
            else if(values[i].equals("") && anCircleGen[eqExample][i].equals("0")){
                j++;
            }
        }
        if (j == 7) {
            tvResult.setText("Correcto");
            tvResult.setTextColor(Color.parseColor("#00bd5c"));
        }
        else {
            tvResult.setText("Incorrecto");
            tvResult.setTextColor(Color.parseColor("#d71d37"));
        }
    }


    public void calculateCircleGen() {
        Fragment fr = getChildFragmentManager().findFragmentById(R.id.display_equation);
        //String x, y, h, k, a, b, r;
        String a, b, c, d, e, r;

        tvA = fr.getView().findViewById(R.id.x1_coeficiente);
        tvB = fr.getView().findViewById(R.id.y1_coeficiente);
        tvC = fr.getView().findViewById(R.id.x2_coeficiente);
        tvD = fr.getView().findViewById(R.id.y2_coeficiente);
        tvE = fr.getView().findViewById(R.id.e_coeficient);
        tvR = fr.getView().findViewById(R.id.result);


        if(tvA.getText().toString().equals("")) { a = "1";} else {a = tvA.getText().toString();}
        if(tvB.getText().toString().equals("")) { b = "1";} else {b = tvB.getText().toString();}
        if(tvC.getText().toString().equals("")) { c = "1";} else {c = tvC.getText().toString();}
        if(tvD.getText().toString().equals("")) { d = "1";} else {d = tvD.getText().toString();}
        if(tvE.getText().toString().equals("")) { e = "0";} else {e = tvE.getText().toString();}
        r = tvR.getText().toString();


        String[] values = {a,b,c,d,e,r};
        int j = 0;
        for(int i = 0; i < 6; i++) {
            if (anCircleStan[eqExample][i].equals(values[i])) {
                j++;
            }
            else if(values[i].equals("") && anCircleStan[eqExample][i].equals("0")){
                j++;
            }
        }
        if (j == 6) {
            tvResult.setText("Correcto");
            tvResult.setTextColor(Color.parseColor("#00bd5c"));
        }
        else {
            tvResult.setText("Incorrecto");
            tvResult.setTextColor(Color.parseColor("#d71d37"));
        }
    }
}
