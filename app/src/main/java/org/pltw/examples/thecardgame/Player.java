package org.pltw.examples.thecardgame;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Player {
    private int health;
    private int energy;
    private List<Card> hand;
    private List<RedCard> redCardsInPlay;
    private List<BlackCard> blackCardsInPlay;
    private boolean turn;
    private int lastTurnJackValue;

    private ImageView farRightBlackCardImageView;
    private ImageView midRightBlackCardImageView;
    private ImageView centerBlackCardImageView;
    private ImageView midLeftBlackCardImageView;
    private ImageView farLeftBlackCardImageView;
    private ImageView farRightRedCardImageView;
    private ImageView midRightRedCardImageView;
    private ImageView centerRedCardImageView;
    private ImageView midLeftRedCardImageView;
    private ImageView farLeftRedCardImageView;
    private TextView dataTextView;
    private String dataText;



    public Player(int health, int energy, List<Card> hand, boolean turn) {
        this.health = health;
        this.energy = energy;
        this.hand = hand;
        this.turn = turn;
    }

    public Player() {
        health = 50;
        energy = 0;
    }


    public void damage(int damage) {
        this.health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void removeEnergy(int energy) {
        this.energy -= energy;
    }

    public void addTurnEnergy(int lastTurnJackValue) {
        if (this.energy < 10) {
            this.energy += 20;
        } else {
            this.energy = 30;
        }
        this.energy += lastTurnJackValue;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<RedCard> getRedCardsInPlay() {
        return redCardsInPlay;
    }

    public void setRedCardsInPlay(List<RedCard> redCardsInPlay) {
        this.redCardsInPlay = redCardsInPlay;
    }

    public List<BlackCard> getBlackCardsInPlay() {
        return blackCardsInPlay;
    }

    public void setBlackCardsInPlay(List<BlackCard> blackCardsInPlay) {
        this.blackCardsInPlay = blackCardsInPlay;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getLastTurnJackValue() {
        return lastTurnJackValue;
    }

    public void setLastTurnJackValue(int lastTurnJackValue) {
        this.lastTurnJackValue = lastTurnJackValue;
    }


    public ImageView getFarRightBlackCardImageView() {
        return farRightBlackCardImageView;
    }

    public void setFarRightBlackCardImageView(ImageView farRightBlackCardImageView) {
        this.farRightBlackCardImageView = farRightBlackCardImageView;
    }

    public ImageView getMidRightBlackCardImageView() {
        return midRightBlackCardImageView;
    }

    public void setMidRightBlackCardImageView(ImageView midRightBlackCardImageView) {
        this.midRightBlackCardImageView = midRightBlackCardImageView;
    }

    public ImageView getCenterBlackCardImageView() {
        return centerBlackCardImageView;
    }

    public void setCenterBlackCardImageView(ImageView centerBlackCardImageView) {
        this.centerBlackCardImageView = centerBlackCardImageView;
    }

    public ImageView getMidLeftBlackCardImageView() {
        return midLeftBlackCardImageView;
    }

    public void setMidLeftBlackCardImageView(ImageView midLeftBlackCardImageView) {
        this.midLeftBlackCardImageView = midLeftBlackCardImageView;
    }

    public ImageView getFarLeftBlackCardImageView() {
        return farLeftBlackCardImageView;
    }

    public void setFarLeftBlackCardImageView(ImageView farLeftBlackCardImageView) {
        this.farLeftBlackCardImageView = farLeftBlackCardImageView;
    }

    public ImageView getFarRightRedCardImageView() {
        return farRightRedCardImageView;
    }

    public void setFarRightRedCardImageView(ImageView farRightRedCardImageView) {
        this.farRightRedCardImageView = farRightRedCardImageView;
    }

    public ImageView getMidRightRedCardImageView() {
        return midRightRedCardImageView;
    }

    public void setMidRightRedCardImageView(ImageView midRightRedCardImageView) {
        this.midRightRedCardImageView = midRightRedCardImageView;
    }

    public ImageView getCenterRedCardImageView() {
        return centerRedCardImageView;
    }

    public void setCenterRedCardImageView(ImageView centerRedCardImageView) {
        this.centerRedCardImageView = centerRedCardImageView;
    }

    public ImageView getMidLeftRedCardImageView() {
        return midLeftRedCardImageView;
    }

    public void setMidLeftRedCardImageView(ImageView midLeftRedCardImageView) {
        this.midLeftRedCardImageView = midLeftRedCardImageView;
    }

    public ImageView getFarLeftRedCardImageView() {
        return farLeftRedCardImageView;
    }

    public void setFarLeftRedCardImageView(ImageView farLeftRedCardImageView) {
        this.farLeftRedCardImageView = farLeftRedCardImageView;
    }

    public TextView getDataTextView() {
        return dataTextView;
    }

    public void setDataTextView(TextView dataTextView) {
        this.dataTextView = dataTextView;
    }

    public String getDataText() {
        return dataText;
    }

    public void setDataText(String dataText) {
        this.dataText = dataText;
    }
}
