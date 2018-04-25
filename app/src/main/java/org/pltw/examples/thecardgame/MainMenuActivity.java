package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainMenuActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Log.i(TAG, "Main menu onCreate() called");
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.main_menu_fragment_display);
        Log.i(TAG, "Found the fragment display");

        if (fragment==null) {
            fragment = new MainMenuFragment();
            Log.i(TAG, "Created new fragment");
            manager.beginTransaction()
                    .add(R.id.main_menu_fragment_display, fragment)
                    .commit();
            Log.i(TAG, "Started fragment");
        }
    }
}
