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
    public int figSelected;
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
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        selectEquation();

        btnNew = view.findViewById(R.id.button_new);
        btnCalculate = view.findViewById(R.id.button_calcular);
        btnSolution = view.findViewById(R.id.button_solution);

        btnNew.setOnClickListener(this);
        btnCalculate.setOnClickListener(this);
        btnSolution.setOnClickListener(this);

        spinnerEquation = view.findViewById(R.id.spinner_equationType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.spinner_equations_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEquation.setAdapter(adapter);
        spinnerEquation.setOnItemSelectedListener(this);
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
                break;
            case R.id.button_calcular:
                break;
            case R.id.button_solution:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        typeSelected = i == 0 ? true : false;
        selectEquation();
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
        transaction.commit();
    }
}
