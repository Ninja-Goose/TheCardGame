package org.pltw.examples.thecardgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    private final String TAG = this.getClass().getName();
    public static String GAME_VOLUME;
    public static String MUSIC_VOLUME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        SharedPreferences sharedPreferences =
                this.getApplicationContext().getSharedPreferences(GAME_VOLUME, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(GAME_VOLUME, 50);
        editor.putInt(MUSIC_VOLUME, 50);
        editor.commit();

        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = fragment = new MainMenuFragment();

        manager.beginTransaction()
                .add(R.id.main_menu_fragment_display, fragment).
                commit();

    }
}
