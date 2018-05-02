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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public boolean isShielded() {
        return shielded;
    }

    public void setShielded(boolean shielded) {
        this.shielded = shielded;
    }
}
