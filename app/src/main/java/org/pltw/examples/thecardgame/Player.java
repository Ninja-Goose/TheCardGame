package org.pltw.examples.thecardgame;

import java.util.List;

public class Player {
    private int health;
    private int energy;
    private List<Card> hand;
    private List<RedCard> redCardsInPlay;
    private List<BlackCard> blackCardsInPlay;
    private boolean turn;

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
}
