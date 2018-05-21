package org.pltw.examples.thecardgame;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
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

    private HorizontalScrollView userHandScrollView;
    private LinearLayout userHandLinearLayout;

    private CardInfoFragment fragment;

    private Player user;
    private Player opponent;

    private boolean endGame;
    private String gameType;
    private Button endTurnButton;
    private boolean isSecondTurn;


    public GameActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager manager = getSupportFragmentManager();
        fragment = new CardInfoFragment();
        //fragment.setCard(generateNewCard());
        // Todo: get the card from the image view

        manager.beginTransaction()
                .add(R.id.card_display_fragment, fragment)
                .hide(fragment)
                .commit();

        setContentView(R.layout.activity_game);

        opponent.setFarRightBlackCardImageView((ImageView) findViewById(R.id.opponentFarRightBlackImageView));
        opponent.setMidRightBlackCardImageView((ImageView) findViewById(R.id.opponentMidRightBlackImageView));
        opponent.setCenterBlackCardImageView((ImageView)  findViewById(R.id.opponentCenterBlackImageView));
        opponent.setMidLeftBlackCardImageView((ImageView)  findViewById(R.id.opponentMidLeftBlackImageView));
        opponent.setFarLeftBlackCardImageView((ImageView)  findViewById(R.id.opponentFarLeftBlackImageView));
        user.setFarRightBlackCardImageView((ImageView)  findViewById(R.id.userFarRightBlackImageView));
        user.setMidRightBlackCardImageView((ImageView)  findViewById(R.id.userMidRightBlackImageView));
        user.setCenterBlackCardImageView((ImageView)  findViewById(R.id.userCenterBlackImageView));
        user.setMidLeftBlackCardImageView((ImageView)  findViewById(R.id.userMidLeftBlackImageView));
        user.setFarLeftBlackCardImageView((ImageView)  findViewById(R.id.userFarLeftBlackImageView));
        opponent.setFarRightRedCardImageView((ImageView)  findViewById(R.id.opponentFarRightRedImageView));
        opponent.setMidRightRedCardImageView((ImageView)  findViewById(R.id.opponentMidRightRedImageView));
        opponent.setCenterRedCardImageView((ImageView)  findViewById(R.id.opponentCenterRedImageView));
        opponent.setMidLeftRedCardImageView((ImageView)  findViewById(R.id.opponentMidLeftRedImageView));
        opponent.setFarLeftRedCardImageView((ImageView)  findViewById(R.id.opponentFarLeftRedImageView));
        user.setFarRightRedCardImageView((ImageView)  findViewById(R.id.userFarRightRedImageView));
        user.setMidRightRedCardImageView((ImageView)  findViewById(R.id.userMidRightRedImageView));
        user.setCenterRedCardImageView((ImageView)  findViewById(R.id.userCenterRedImageView));
        user.setMidLeftRedCardImageView((ImageView)  findViewById(R.id.userMidLeftRedImageView));
        user.setFarLeftRedCardImageView((ImageView)  findViewById(R.id.userFarLeftRedImageView));
        opponent.getFarRightBlackCardImageView().setVisibility(View.INVISIBLE);
        opponent.getMidRightBlackCardImageView().setVisibility(View.INVISIBLE);
        opponent.getCenterBlackCardImageView().setVisibility(View.INVISIBLE);
        opponent.getMidLeftBlackCardImageView().setVisibility(View.INVISIBLE);
        opponent.getFarLeftBlackCardImageView().setVisibility(View.INVISIBLE);
        user.getFarRightBlackCardImageView().setVisibility(View.INVISIBLE);
        user.getMidRightBlackCardImageView().setVisibility(View.INVISIBLE);
        user.getCenterBlackCardImageView().setVisibility(View.VISIBLE); //test
        user.getMidLeftBlackCardImageView().setVisibility(View.VISIBLE); //test
        user.getFarLeftBlackCardImageView().setVisibility(View.INVISIBLE);
        opponent.getFarRightRedCardImageView().setVisibility(View.VISIBLE); //test
        opponent.getMidRightRedCardImageView().setVisibility(View.INVISIBLE);
        opponent.getCenterRedCardImageView().setVisibility(View.VISIBLE); //test
        opponent.getMidLeftRedCardImageView().setVisibility(View.INVISIBLE);
        opponent.getFarLeftRedCardImageView().setVisibility(View.INVISIBLE);
        user.getFarRightRedCardImageView().setVisibility(View.INVISIBLE);
        user.getMidRightRedCardImageView().setVisibility(View.INVISIBLE);
        user.getCenterRedCardImageView().setVisibility(View.INVISIBLE);
        user.getMidLeftRedCardImageView().setVisibility(View.INVISIBLE);
        user.getFarLeftRedCardImageView().setVisibility(View.INVISIBLE);


        user.setDataTextView((TextView) findViewById(R.id.userDataTextView));
        opponent.setDataTextView((TextView) findViewById(R.id.opponentDataTextView));

        userHandScrollView = findViewById(R.id.userHandScrollView);
        userHandLinearLayout = findViewById(R.id.userHandLinearLayout);

        user = new Player();
        opponent = new Player();
        endTurnButton = findViewById(R.id.end_turn_button);
        user.setLastTurnJackValue(0);

        user.setEnergy(20);
        user.setHealth(50);
        opponent.setEnergy(20);
        opponent.setHealth(50);
        user.setDataText(getString(R.string.user_data,user.getEnergy(),user.getHealth()));
        opponent.setDataText(getString(R.string.opponent_data,opponent.getEnergy(),opponent.getHealth()));


        //Start the Game
        for (int i = 0; i < 5; i++) {
            user.getHand().add(drawCard(true));
            opponent.getHand().add(drawCard(false));
        }
        takeTurn(true);

        //endGame = false;
        gameType = "two on one"; //Todo: use intents to implement the setting of the game type

        //Todo: add the mechanics for the player taking a turn

        endTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(gameType) {
                    case ("two on one"):
                        if (isSecondTurn) {
                            attack();
                        } else {
                            swapPlayers();
                        }
                        takeTurn(true);

                        break;
                    case ("bot"):
                        //will implement later
                        break;
                    case ("internet"):
                        //will implement later
                        break;
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
        switch (val) {
            case (1):
                value = "a";
                break;
            case (11):
                value = "j";
                break;
            case (12):
                value = "q";
                break;
            case (13):
                value = "k";
                break;
            default:
                value = Integer.toString(val);
                break;
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
            user.addTurnEnergy(user.getLastTurnJackValue());
            user.setLastTurnJackValue(0);
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
            opponent.addTurnEnergy(opponent.getLastTurnJackValue());
            opponent.setLastTurnJackValue(0);
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

                    if (blackCard.isJack) {

                    }


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


    private void updateTextView(boolean isUser) {
        if (isUser) {
            user.setDataText(getString(R.string.user_data,user.getEnergy(),user.getHealth()));
            user.getDataTextView().setText(user.getDataText());
        } else {
            opponent.setDataText(getString(R.string.opponent_data,opponent.getEnergy(),opponent.getHealth()));
            opponent.getDataTextView().setText(opponent.getDataText());
        }
    }


    
    private void displayCard(int id) {
        ImageView imageViewClicked = findViewById(id);
        //Log.i(TAG, "Image view clicked: " + id + ", drawable: " + imageViewClicked.getDrawable().toString());
        FragmentManager manager = getSupportFragmentManager();
        Card card = generateNewCard();
        fragment.setCard(card);// Todo: get the card from the image view

        manager.beginTransaction()
                .replace(R.id.card_display_fragment, fragment)
                .show(fragment)
                .addToBackStack(null)
                .commit();

        //wait for click off and stop fragment
    }

    public void playedCardClicked(View v) {
        displayCard(v.getId());
    }

}
