package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity{ //Main gameplay logic

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

    private Player user;
    private Player opponent;

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

    //Todo: associate card image views with specific cards?

    //Todo: Game loop
    //      know game type (internet, bot, two on one)
    //      implement end turn button
    //      player.turnEnergy(lastTurnJack = true/false?)

    //Todo: when card in scroll area clicked, wait for another click to specify where the card should go and place it there
    //      remove energy cost from player (player.removeEnergy(energy)) if they have enough


    public void displayCard(int id) {
        //Todo: get the card associated with an image view id
        //Todo: Start new fragment(?) to display enlarged card and info
        //wait for click off and stop fragment
    }

    public void playedCardClicked(View v) {

        //displayCard(v.getId())?

        /*switch (v.getId()) {
            case R.id.opponentFarLeftRedImageView: //opponent cards, red cards
                //code
                break;
            case R.id.opponentMidLeftRedImageView:
                //code
                break;
            case R.id.opponentCenterRedImageView:
                //code
                break;
            case R.id.opponentMidRightRedImageView:
                //code
                break;
            case R.id.opponentFarRightRedImageView:
                //code
                break;
            case R.id.opponentFarLeftBlackImageView: //black cards
                //code
                break;
            case R.id.opponentMidLeftBlackImageView:
                //code
                break;
            case R.id.opponentCenterBlackImageView:
                //code
                break;
            case R.id.opponentMidRightBlackImageView:
                //code
                break;
            case R.id.opponentFarRightBlackImageView:
                //code
                break;


            case R.id.userFarLeftRedImageView: //player cards, red cards
                //code
                break;
            case R.id.userMidLeftRedImageView:
                //code
                break;
            case R.id.userCenterRedImageView:
                //code
                break;
            case R.id.userMidRightRedImageView:
                //code
                break;
            case R.id.userFarRightRedImageView:
                //code
                break;
            case R.id.userFarLeftBlackImageView: //black cards
                //code
                break;
            case R.id.userMidLeftBlackImageView:
                //code
                break;
            case R.id.user:
                //code
                break;
            case R.id.opponentFarRightBlackImageView:
                //code
                break;
            case R.id.opponentFarRightBlackImageView:
                //code
                break;

        }*/
    } // in xml, set android on click property to "playedCardClicked"

}
