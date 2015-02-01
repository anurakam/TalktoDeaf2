package project.talktodeaf.videogame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import project.talktodeaf.main.R;

    public class GameVideoThirdFragment extends Fragment {
        // Store instance variables
        private String title;
        private int page;

        // newInstance constructor for creating fragment with arguments
        public static GameVideoThirdFragment newInstance(int page, String title) {
            GameVideoThirdFragment fragmentThird = new GameVideoThirdFragment();
            Bundle args = new Bundle();
            args.putInt("someInt", page);
            args.putString("someTitle", title);
            fragmentThird.setArguments(args);
            return fragmentThird;
        }

        // Store instance variables based on arguments passed
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            page = getArguments().getInt("someInt", 2);
            title = getArguments().getString("someTitle");
        }

        // Inflate the view for the fragment based on layout XML
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_game_video_third, container, false);
            //TextView tvLabel = (TextView) view.findViewById(R.id.tvLabel);
            //tvLabel.setText(page + " -- " + title);
            return view;
        }
    }