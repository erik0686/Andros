package itesm.mx.andros;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lc on 3/05/18.
 */

public class StandardEquation extends Fragment {
    public int figSelected;

    public StandardEquation() {
    }

    public static StandardEquation newInstance(){
        return new StandardEquation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(selectEquation(), container, false);
        return view;
    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

    public  int selectEquation() {
        switch (figSelected) {
            case 0:
                return R.layout.standard_circle;
            case 1:
                return R.layout.standard_ellipse;
            case 2:
                return R.layout.standard_parabola;
            case 3:
                return R.layout.standard_hyperbola;
        }
        return 0;
    }
}
