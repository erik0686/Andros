package itesm.mx.andros;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by erik on 3/05/18.
 */
public class FragmentEcuations extends Fragment {
    public int figSelected;

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
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

    }


}
