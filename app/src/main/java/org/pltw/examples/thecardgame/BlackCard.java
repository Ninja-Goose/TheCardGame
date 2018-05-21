package org.pltw.examples.thecardgame;

public class BlackCard extends Card {
    private int attack;

    public BlackCard(String value, String suit, String position) {
        super(value, suit, position);
        if (value.equals("a")) {
            attack = 1;
        } else if (value.equals("j")||value.equals("q")||value.equals("k")) {
            attack = 10;
        } else {
            attack = Integer.parseInt(value);
        }

    }


    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
