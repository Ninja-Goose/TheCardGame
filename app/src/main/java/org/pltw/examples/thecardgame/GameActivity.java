package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity { //Main gameplay logic

    Random random = new Random();

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

    private HorizontalScrollView userHandScrollView;
    private LinearLayout userHandLinearLayout;

    private List<Card> userHand;
    private List<Card> opponentHand;

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
        opponentFarRightBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentMidRightBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentCenterBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentMidLeftBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentFarLeftBlackCardImageView.setVisibility(View.INVISIBLE);
        userFarRightBlackCardImageView.setVisibility(View.INVISIBLE);
        userMidRightBlackCardImageView.setVisibility(View.INVISIBLE);
        userCenterBlackCardImageView.setVisibility(View.INVISIBLE);
        userMidLeftBlackCardImageView.setVisibility(View.INVISIBLE);
        userFarLeftBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentFarRightRedCardImageView.setVisibility(View.INVISIBLE);
        opponentMidRightRedCardImageView.setVisibility(View.INVISIBLE);
        opponentCenterRedCardImageView.setVisibility(View.INVISIBLE);
        opponentMidLeftRedCardImageView.setVisibility(View.INVISIBLE);
        opponentFarLeftRedCardImageView.setVisibility(View.INVISIBLE);
        userFarRightRedCardImageView.setVisibility(View.INVISIBLE);
        userMidRightRedCardImageView.setVisibility(View.INVISIBLE);
        userCenterRedCardImageView.setVisibility(View.INVISIBLE);
        userMidLeftRedCardImageView.setVisibility(View.INVISIBLE);
        userFarLeftRedCardImageView.setVisibility(View.INVISIBLE);


        userDataTextView = findViewById(R.id.userDataTextView);
        opponentDataTextView = findViewById(R.id.opponentDataTextView);

        userHandScrollView = findViewById(R.id.userHandScrollView);
        userHandLinearLayout = findViewById(R.id.userHandLinearLayout);




    }

    private Card generateNewCard() {
        boolean color = random.nextBoolean();
        boolean suit = random.nextBoolean();
        int val = random.nextInt(12)+1;
        String value;
        String cardSuit;
        if (val == 1) {
            value = "a";
        } else if (val == 11) {
            value = "j";
        } else if (val == 12) {
            value = "q";
        } else if (val == 13) {
            value = "k";
        } else {
            value = Integer.toString(val);
        }

        if (color) {
            if (suit) {
                cardSuit = "h";
            } else {
                cardSuit = "d";
            }
            return new RedCard(value, cardSuit, "hand");
        } else {
            if (suit) {
                cardSuit = "s";
            } else {
                cardSuit = "c";
            }
            return new BlackCard(value, cardSuit, "hand");
        }


    }

    private void drawCard(List<Card> hand) {
        Card card = generateNewCard();
        ImageView imageView = new ImageView(userHandLinearLayout.getContext());
        imageView.setImageResource(getResources().getIdentifier(card.getImageSource(),"drawable", getPackageName()));
        imageView.setVisibility(View.VISIBLE);
        card.setImageDisplay(imageView);

    }
}
