package org.pltw.examples.thecardgame;

public abstract class Card {
    private String imageSource;
    private String value; //lowercase
    private String suit; //lowercase
    private String position;
    private int cost;


    public Card() {
    }

    public Card(String imageSource, String value, String suit, String position, int cost) {
        this.imageSource = imageSource;
        this.value = value;
        this.suit = suit;
        this.position = position;
        this.cost = cost;
    }

    public Card(String value, String suit, String position) {
        //for jokers, value = "rj" or "bj" and suit = ""
        imageSource = "card_" + value + suit + ".png";
        this.value = value;
        this.suit = suit;
        this.position = position;
        if (value.equals("j")||value.equals("q")||value.equals("k")||value.equals("a")) {
            cost = 15;
        } else if (value.equals("rj")||value.equals("bj")) {
            cost = 0;
        } else {
            cost = Integer.getInteger(value);
        }
    }

}
