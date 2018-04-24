package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.main_menu_fragment_display);

        if (fragment==null) {
            fragment = new MainMenuFragment();
            manager.beginTransaction()
                    .add(R.id.main_menu_fragment_display, fragment)
                    .commit();
        }
    }
}
