package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        settingsTitleText = v.findViewById(R.id.settings_title_text);
        gameVolumeText = v.findViewById(R.id.game_volume_text);
        musicVolumeText = v.findViewById(R.id.music_volume_text);
        gameVolumeSlider = v.findViewById(R.id.game_volume_slider);
        musicVolumeSlider = v.findViewById(R.id.music_volume_slider);
        backButton = v.findViewById(R.id.back_button);

        gameVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Todo: set volume preference
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        musicVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Todo: set volume preference
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: end this fragment, display main menu fragment
            }
        });

        return v;
    }

}
