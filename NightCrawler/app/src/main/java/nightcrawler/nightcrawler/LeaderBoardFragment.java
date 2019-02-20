package nightcrawler.nightcrawler;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


public class LeaderBoardFragment extends Fragment {
    private static final String TAG = "LeaderBoardFragment";
    private List<String> leaderBoard;
    public LeaderBoardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_leader_board, container, false);
        Log.d(TAG, "onCreate called");
        RecyclerView leaderBoardRecyclerView =v.findViewById(R.id.leader_board_recycler_view);
        Activity activity = getActivity();

        if(activity != null) {
            leaderBoardRecyclerView.setLayoutManager(new LinearLayoutManager(activity));
            List<String> adapter = new LinkedList<>();
            adapter.add("Seth");
            adapter.add("Adam Champion");
            adapter.add("Berkay");
            adapter.add("Ryan");
            adapter.add("Brutus Buckeye");
            adapter.add("Sad man 1");
            adapter.add("XXxPu55y_51Ay3RxXX");
            adapter.add("ur mum lul xD");
            adapter.add("Hey at least I tried");
            adapter.add("Dr. Suess");
            adapter.add("Slow man 87");
            adapter.add("Who could it be now");
            adapter.add("7878787");
            LeaderBoardAdapter LeaderBoardAdapter = new LeaderBoardAdapter(adapter);

            leaderBoardRecyclerView.setAdapter(LeaderBoardAdapter);
            leaderBoardRecyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        return v;
    }


    private class LeaderBoardHolder extends RecyclerView.ViewHolder {

        private TextView leaderBoardTextView;
        LeaderBoardHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_leader_board, parent, false));

            leaderBoardTextView = itemView.findViewById(R.id.leader_board_entry);
        }

        void bind(String str) {
            leaderBoardTextView.setText(str);
        }
    }



    private class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardHolder> {
        private List<String> leaderBoard;

        LeaderBoardAdapter(List<String> list) {
            leaderBoard = list;
        }

        @NonNull
        @Override
        public LeaderBoardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new LeaderBoardHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull LeaderBoardHolder leaderBoardHolder, int i) {
            leaderBoardHolder.bind(leaderBoard.get(i));
        }


        @Override
        public int getItemCount() {
            return leaderBoard.size();
        }
    }

}
