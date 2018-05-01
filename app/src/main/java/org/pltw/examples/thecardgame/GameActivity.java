package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity { //Main gameplay logic

    //create variables linked to all of the image views

    private ImageView opponentFarRightBlackCardImageView;
    private ImageView opponentMidRightBlackCardImageView;
    private ImageView opponentCenterBlackCardImageView;
    private ImageView opponentMidLeftBlackCardImageView;
    private ImageView opponentFarLeftBlackCardImageView;
    private ImageView userFarRightBlackCardImageView;
    private ImageView userMidRightBlackCardImageView;
    private ImageView userCenterBlackCardImageView;
    private ImageView userMidLeftBlackCardImageView;
    private ImageView userFarLeftBlackCardImageView;
    private ImageView opponentFarRightRedCardImageView;
    private ImageView opponentMidRightRedCardImageView;
    private ImageView opponentCenterRedCardImageView;
    private ImageView opponentMidLeftRedCardImageView;
    private ImageView opponentFarLeftRedCardImageView;
    private ImageView userFarRightRedCardImageView;
    private ImageView userMidRightRedCardImageView;
    private ImageView userCenterRedCardImageView;
    private ImageView userMidLeftRedCardImageView;
    private ImageView userFarLeftRedCardImageView;

    private TextView userDataTextView;
    private TextView opponentDataTextView;

    private HorizontalScrollView userHand;

    public GameActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        opponentFarRightBlackCardImageView = findViewById(R.id.opponentFarRightBlackImageView);
        opponentMidRightBlackCardImageView = findViewById(R.id.opponentMidRightBlackImageView);
        opponentCenterBlackCardImageView = findViewById(R.id.opponentCenterBlackImageView);
        opponentMidLeftBlackCardImageView = findViewById(R.id.opponentMidLeftBlackImageView);
        opponentFarLeftBlackCardImageView = findViewById(R.id.opponentFarLeftBlackImageView);
        userFarRightBlackCardImageView = findViewById(R.id.userFarRightBlackImageView);
        userMidRightBlackCardImageView = findViewById(R.id.userMidRightBlackImageView);
        userCenterBlackCardImageView = findViewById(R.id.userCenterBlackImageView);
        userMidLeftBlackCardImageView = findViewById(R.id.userMidLeftBlackImageView);
        userFarLeftBlackCardImageView = findViewById(R.id.userFarLeftBlackImageView);
        opponentFarRightRedCardImageView = findViewById(R.id.opponentFarRightRedImageView);
        opponentMidRightRedCardImageView = findViewById(R.id.opponentMidRightRedImageView);
        opponentCenterRedCardImageView = findViewById(R.id.opponentCenterRedImageView);
        opponentMidLeftRedCardImageView = findViewById(R.id.opponentMidLeftRedImageView);
        opponentFarLeftRedCardImageView = findViewById(R.id.opponentFarLeftRedImageView);
        userFarRightRedCardImageView = findViewById(R.id.userFarRightRedImageView);
        userMidRightRedCardImageView = findViewById(R.id.userMidRightRedImageView);
        userCenterRedCardImageView = findViewById(R.id.userCenterRedImageView);
        userMidLeftRedCardImageView = findViewById(R.id.userMidLeftRedImageView);
        userFarLeftRedCardImageView = findViewById(R.id.userFarLeftRedImageView);

        userDataTextView = findViewById(R.id.userDataTextView);
        opponentDataTextView = findViewById(R.id.opponentDataTextView);

        userHand = findViewById(R.id.userHandScrollView);





    }
}
