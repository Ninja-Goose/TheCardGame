package org.pltw.examples.thecardgame;

import java.util.List;

public class Player {
    private int health;
    private int energy;
    private List<Card> hand;
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

    public void turnEnergy(boolean lastTurnJack) {
        if (lastTurnJack) {
            this.energy += 25;
        } else {
            if (this.energy < 10) {
                this.energy += 20;
            } else {
                this.energy = 30;
            }
        }
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

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
