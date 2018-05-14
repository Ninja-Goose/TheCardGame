package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RulesFragment extends Fragment {

    private final String TAG = this.getClass().getName();
    private Button backButton;

    public RulesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_rules, container, false);


        backButton = v.findViewById(R.id.back_button_rules);


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
