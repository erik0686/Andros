package itesm.mx.andros;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;


public class FragmentYoutube extends Fragment {
    Button btnYoutube;
    public int figSelected;
    public static final String YOUTUBE_API_KEY = "AIzaSyDjNkE4u0pQeLmI7EmZYM423xY3M4bBWxo";

    public FragmentYoutube() {}
    public static FragmentYoutube newInstance(){
        return new FragmentYoutube();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Recursos Audiovisuales");
        View rootView = inflater.inflate(R.layout.you_tube_api, container, false);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout, youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override

            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    switch (figSelected){
                        case 0:
                            player.cueVideo("u26rAiskl54");
                            break;
                        case 1:
                            player.cueVideo("jVTZITljKUE");
                            break;
                        case 2:
                            player.cueVideo("_YOPO4mtl_s");
                            break;
                        case 3:
                            player.cueVideo("yBTdSYYUHow");
                            break;
                    }
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        return rootView;
    }
}