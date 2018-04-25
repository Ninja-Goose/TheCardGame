package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PlayScreenFragment extends Fragment {

    private TextView playScreenTitle;
    private Button againstABotButton;
    private Button oneDeviceButton;
    private Button internetButton;

    public PlayScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_play_screen, container, false);

        playScreenTitle = v.findViewById(R.id.play_title_text);
        againstABotButton = v.findViewById(R.id.against_a_bot);
        oneDeviceButton = v.findViewById(R.id.two_on_one_device);
        internetButton = v.findViewById(R.id.on_the_internet);

        againstABotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: start game screen activity with bot option
            }
        });

        oneDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: start game screen with two on one device option
            }
        });

        internetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: start matchmaking service, start game screen with internet opt.
            }
        });

        return v;
    }

}
