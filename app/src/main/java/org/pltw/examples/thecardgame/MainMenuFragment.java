package org.pltw.examples.thecardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class MainMenuFragment extends Fragment {



    private final String TAG = this.getClass().getName();

    private TextView playText;
    private TextView settingsText;
    private TextView logOutText;
    private TextView rulesText;

    public MainMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "Main Menu Fragment onCreateView() called");
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        playText = v.findViewById(R.id.play_text);
        settingsText = v.findViewById(R.id.settings_text);
        logOutText = v.findViewById(R.id.log_out_text);
        rulesText = v.findViewById(R.id.rules_text);

        playText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Play button pressed, starting fragment");
                FragmentManager manager = getFragmentManager();
                PlayScreenFragment playFragment = new PlayScreenFragment();
                manager.beginTransaction()
                        .replace(R.id.main_menu_fragment_display, playFragment)
                        .addToBackStack(null)
                        .commit();

                //start play fragment
            }
        });

        settingsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Settings button pressed, starting fragment");
                FragmentManager manager = getFragmentManager();
                SettingsFragment settingsFragment = new SettingsFragment();
                manager.beginTransaction()
                        .replace(R.id.main_menu_fragment_display, settingsFragment)
                        .addToBackStack(null)
                        .commit();
                //start settings fragment
            }
        });

        rulesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Rules button pressed, starting fragment");
                FragmentManager manager = getFragmentManager();
                RulesFragment rulesFragment = new RulesFragment();
                manager.beginTransaction()
                        .replace(R.id.main_menu_fragment_display, rulesFragment)
                        .addToBackStack(null)
                        .commit();
                //start rules fragment
            }
        });

        logOutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.UserService.logout(new AsyncCallback<Void>() {
                    @Override
                    public void handleResponse(Void v) {
                        Log.i(TAG, "Successful logout");
                    }
                    @Override
                    public void handleFault(BackendlessFault backendlessFault) {
                        Log.i(TAG, "Server reported an error on logout:" + backendlessFault.getMessage());
                    }
                });
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }


}
