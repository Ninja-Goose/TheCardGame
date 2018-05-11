package org.pltw.examples.thecardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity { //Main gameplay logic

    Random random = new Random();

    final String TAG = this.getClass().getName();

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

    private Player user;
    private Player opponent;

    private boolean endGame;
    private String gameType;
    private Button endTurnButton;
    private boolean secondTurn;
    private int lastTurnJackValue;

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
        userCenterBlackCardImageView.setVisibility(View.VISIBLE); //test
        userMidLeftBlackCardImageView.setVisibility(View.VISIBLE); //test
        userFarLeftBlackCardImageView.setVisibility(View.INVISIBLE);
        opponentFarRightRedCardImageView.setVisibility(View.VISIBLE); //test
        opponentMidRightRedCardImageView.setVisibility(View.INVISIBLE);
        opponentCenterRedCardImageView.setVisibility(View.VISIBLE); //test
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

        user = new Player();
        opponent = new Player();
        endTurnButton = findViewById(R.id.end_turn_button);
        lastTurnJackValue = 0;


        //Start the Game
        for (int i = 0; i < 5; i++) {
            user.getHand().add(drawCard(true));
            opponent.getHand().add(drawCard(false));
        }
        takeTurn(true);

        //endGame = false;
        gameType = "two on one"; //Todo: use intents to implement the setting of the game type

        /*
        while (!endGame) {
            //Todo: implement game loop if necessary
            //      know game type (internet, bot, two on one)
            //      implement end turn button
            //      player.addTurnEnergy(lastTurnJackValue = true/false?)

            if (gameType.equals("two on one")) {
                Player temp = new Player();

                user = takeTurn(user, true);




            } else if (gameType.equals("bot")) {
                //will implement later
            } else if (gameType.equals("internet")) {
                //will implement later
            }

        }
        */
        endTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameType.equals("two on one")) {
                    if (secondTurn) {
                        attack();
                    } else {
                        swapPlayers();
                    }
                    takeTurn(true);

                } else if (gameType.equals("bot")) {
                    //will implement later
                } else if (gameType.equals("internet")) {
                    //will implement later
                }
            }
        });





        //Todo: when card in scroll area clicked, wait for another click to specify where the card should go and place it there
        //      remove energy cost from player (player.removeEnergy(energy)) if they have enough

        //Todo: associate card image views with specific cards?

    }
    private Card generateNewCard() {
        boolean color = random.nextBoolean();
        boolean suit = random.nextBoolean();
        int val = random.nextInt(12) + 1;
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


    private Card drawCard(boolean isUser) {
        Card card = generateNewCard();
        if (isUser) {
            ImageView imageView = new ImageView(userHandLinearLayout.getContext());
            imageView.setImageResource(getResources().getIdentifier(card.getImageSource(), "drawable", getPackageName()));
            imageView.setVisibility(View.VISIBLE);
            /*imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handCardClick();
                }
            });*/
            card.setImageDisplay(imageView);
        }
        return card;
    }

    private void takeTurn(boolean isUser) {
        if (isUser) {
            int numberOfJacks = 0;
            for (Card card : user.getRedCardsInPlay()) {
                if (card.isJack()) {
                    numberOfJacks++;
                }
            }
            for (int i = 0; i < numberOfJacks + 2; i++) {
                user.getHand().add(drawCard(true));
            }
            user.addTurnEnergy(lastTurnJackValue);
            lastTurnJackValue = 0;
        } else { //only applicable with bot
            int numberOfJacks = 0;
            for (Card card : opponent.getRedCardsInPlay()) {
                if (card.isJack()) {
                    numberOfJacks++;
                }
            }
            for (int i = 0; i < numberOfJacks + 2; i++) {
                opponent.getHand().add(drawCard(false));
            }
            opponent.addTurnEnergy(lastTurnJackValue);
            lastTurnJackValue = 0;
            //need to add the bot playing cards
        }
    }

    private void swapPlayers() {
        Player temp;
        temp = user;
        user = opponent;
        opponent = temp;
        //Todo: update all of the ImageViews and TextViews
    }


    private void attack() {
        for (BlackCard blackCard : opponent.getBlackCardsInPlay()) { //checks whether two cards are in the same lane
            for (RedCard redCard : user.getRedCardsInPlay()) {
                if (redCard.getPosition().equals(blackCard.getPosition())) {
                    if (!redCard.isShielded()) {
                        if (!redCard.isInvincible()) {
                            redCard.setHealth(redCard.getHealth() - blackCard.getAttack());
                        }
                    } else {
                        redCard.setShielded(false);
                    }
                    //Todo: implement face card and 10 specials
                    if (redCard.getHealth()<=0) {
                        //Todo: disconnect red card from ImageView
                        user.setHealth(user.getHealth()+redCard.getHealth());
                        user.getRedCardsInPlay().remove(redCard);
                    }
                    //Todo: disconnect black card from ImageView
                    opponent.getBlackCardsInPlay().remove(blackCard);
                }
            }
        }
        for (BlackCard blackCard : user.getBlackCardsInPlay()) { //checks whether two cards are in the same lane
            for (RedCard redCard : opponent.getRedCardsInPlay()) {
                if (redCard.getPosition().equals(blackCard.getPosition())) {
                    if (!redCard.isShielded()) {
                        if (!redCard.isInvincible()) {
                            redCard.setHealth(redCard.getHealth() - blackCard.getAttack());
                        }
                    } else {
                        redCard.setShielded(false);
                    }
                    //Todo: implement face card and 10 specials
                    if (redCard.getHealth()<=0) {
                        //Todo: disconnect red card from ImageView
                        opponent.setHealth(user.getHealth()+redCard.getHealth());
                        opponent.getRedCardsInPlay().remove(redCard);
                    }
                    //Todo: disconnect black card from ImageView
                    user.getBlackCardsInPlay().remove(blackCard);
                }
            }
        }
        for (BlackCard blackCard : user.getBlackCardsInPlay()) {
            opponent.setHealth(opponent.getHealth()-blackCard.getAttack());
        }
        for (BlackCard blackCard : opponent.getBlackCardsInPlay()) {
            user.setHealth(user.getHealth()-blackCard.getAttack());
        }
        //Todo: update TextViews for user and opponent health
        if (opponent.getHealth()<=0) {
            //Todo: implement toast to display user winning
        } else if (user.getHealth()<=0) {
            //Todo: implement toast to display user losing
        }
    }



    
    private void displayCard(int id) {
        ImageView imageViewClicked = findViewById(id);
        Log.i(TAG, "Image view clicked: " + id + ", drawable: " + imageViewClicked.getDrawable().toString());
        Intent i = new Intent();

        //Todo: get the card associated with an image view id
        //Todo: Start new fragment(?) to display enlarged card and info
        //wait for click off and stop fragment
    }

    public void playedCardClicked(View v) {

        displayCard(v.getId());

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
