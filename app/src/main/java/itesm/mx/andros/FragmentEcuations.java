package itesm.mx.andros;

import android.content.Context;
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

public class FragmentEcuations extends Fragment implements View.OnClickListener, Spinner.OnItemSelectedListener{
    public boolean typeSelected = true;
    public int figSelected, eqExample;
    String[][] anCircleGen = {{"1", "1", "0", "1", "1", "0", "16"}, {"1", "1", "-1", "1", "1", "1", "4"},
            {"2", "1", "-3", "2", "1", "-5", "49"}, {"1", "1", "0", "1", "1", "-3", "100"}, {"4", "1", "-2", "4", "1", "-3", "1"}};
    String[][] anCircleStan = {{"1", "1", "0", "0", "16", "0"}, {"1", "1", "-2", "2", "-2", "0"},
            {"2", "2", "-12", "-20", "19", "0"}, {"1", "1", "0", "-6", "-91", "0"}, {"4", "4", "-16", "-24", "51", "0"}};
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
    TextView tvX, tvH, tvY, tvK, tvR, tvA, tvB, tvResult;
    Spinner spinnerEquation;
    ImageView ivEquation, ivSolution;

    public FragmentEcuations() {
    }

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

        btnNew.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
        btnSolution.setOnClickListener(this);

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
                displayEquation();
                break;
            case R.id.button_calcular:
                if(figSelected == 0 && typeSelected) { calculateCircleStan(); }
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
        selectEquation();
        displayEquation();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

   /* void eqValues() {
        anCircleGen =
    }*/

    public void selectEquation(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        StandardEquation standardEquation= StandardEquation.newInstance();
        transaction.replace(R.id.display_equation, standardEquation, "FRAGMENT EQUATION" );
        standardEquation.figSelected = figSelected;
        standardEquation.typeEquation = typeSelected;
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
        tvX = fr.getView().findViewById(R.id.x1_coeficiente);
        tvH = fr.getView().findViewById(R.id.x2_coeficiente);
        tvY = fr.getView().findViewById(R.id.y1_coeficiente);
        tvK = fr.getView().findViewById(R.id.y2_coeficiente);
        tvR = fr.getView().findViewById(R.id.result);
    }
}
