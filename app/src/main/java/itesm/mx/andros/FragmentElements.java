package itesm.mx.andros;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentElements extends Fragment {
    public int figSelected;


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
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

   public void selectEquation(){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        StandardEquation standardEquation= StandardEquation.newInstance();
        transaction.replace(R.id.display_equation, standardEquation, "FRAGMENT FORMULARIO" );
        standardEquation.figSelected = figSelected;
        transaction.commit();
    }
}
