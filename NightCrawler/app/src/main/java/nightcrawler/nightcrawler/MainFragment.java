package nightcrawler.nightcrawler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "MainFragment";

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        Button newGameButton = v.findViewById(R.id.newGameButton);
        Button leaderBoardButton = v.findViewById(R.id.leaderBoardButton);
        ImageButton settingsButton = v.findViewById(R.id.settingsButton);
        newGameButton.setOnClickListener(this);
        leaderBoardButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
        Log.d(TAG, "onCreateView called");

        return v;
    }


    public void onClick(View v){
        Activity activity = getActivity();
        if(activity != null){
            switch(v.getId()){
                case R.id.newGameButton:
                    startActivity(new Intent(activity.getApplicationContext(), GameActivity.class));
                    break;

                case R.id.leaderBoardButton:
                    startActivity(new Intent(activity.getApplicationContext(), LeaderBoardActivity.class));
                    break;
                case R.id.settingsButton:
                    startActivity(new Intent(activity.getApplicationContext(),SettingsActivity.class));
            }
        }

    }


}
