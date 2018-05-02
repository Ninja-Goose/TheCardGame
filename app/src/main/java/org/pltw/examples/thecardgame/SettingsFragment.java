package org.pltw.examples.thecardgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    private final String TAG = this.getClass().getName();

    private TextView settingsTitleText;
    private TextView gameVolumeText;
    private TextView musicVolumeText;
    private SeekBar gameVolumeSlider;
    private SeekBar musicVolumeSlider;
    private Button backButton;

    public SettingsFragment() {
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
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        settingsTitleText = v.findViewById(R.id.settings_title_text);
        gameVolumeText = v.findViewById(R.id.game_volume_text);
        musicVolumeText = v.findViewById(R.id.music_volume_text);
        gameVolumeSlider = v.findViewById(R.id.game_volume_slider);
        musicVolumeSlider = v.findViewById(R.id.music_volume_slider);
        backButton = v.findViewById(R.id.back_button);

        final SharedPreferences sharedPreferences =
                getActivity().getApplicationContext().getSharedPreferences(MainMenuActivity.GAME_VOLUME, Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor = sharedPreferences.edit();

        gameVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editor.putInt(MainMenuActivity.GAME_VOLUME, i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.commit();
                Log.i(TAG, "GAME_VOLUME = " + Integer.toString(sharedPreferences.getInt(MainMenuActivity.GAME_VOLUME, 50)));
            }
        });

        musicVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                editor.putInt(MainMenuActivity.MUSIC_VOLUME, i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.commit();
                Log.i(TAG, "MUSIC_VOLUME = " + Integer.toString(sharedPreferences.getInt(MainMenuActivity.MUSIC_VOLUME, 50)));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: end this fragment, display main menu fragment
                Log.i(TAG, "Settings back button pressed, starting main menu fragment");
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
