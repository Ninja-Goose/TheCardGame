package org.pltw.examples.thecardgame;

public class RedCard extends Card {
    private int health;
    private boolean invincible;
    private boolean shielded;

    public RedCard(String value, String suit, String position) {
        super(value, suit, position);
        if (value.equals("a")) {
            health = 1;
        } else if (value.equals("j")||value.equals("q")||value.equals("k")) {
            health = 10;
        } else {
            health = Integer.getInteger(value);
        }
    }
}
