package org.pltw.examples.thecardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PlayScreenFragment extends Fragment {

    private final String TAG = this.getClass().getName();

    private TextView playScreenTitle;
    private Button againstABotButton;
    private Button oneDeviceButton;
    private Button internetButton;
    private Button backButton;

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
        final View v = inflater.inflate(R.layout.fragment_play_screen, container, false);

        playScreenTitle = v.findViewById(R.id.play_title_text);
        againstABotButton = v.findViewById(R.id.against_a_bot);
        oneDeviceButton = v.findViewById(R.id.two_on_one_device);
        internetButton = v.findViewById(R.id.on_the_internet);
        backButton = v.findViewById(R.id.back_button_play);

        againstABotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: start game screen activity with bot option
            }
        });

        oneDeviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), GameActivity.class);
                startActivity(intent);
            }
        });

        internetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: start matchmaking service, start game screen with internet opt.
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Play screen back button pressed, starting main menu fragment");
                FragmentManager manager = getFragmentManager();
                MainMenuFragment menuFragment = new MainMenuFragment();
                manager.beginTransaction()
                        .replace(R.id.main_menu_fragment_display, menuFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return v;
    }

}
