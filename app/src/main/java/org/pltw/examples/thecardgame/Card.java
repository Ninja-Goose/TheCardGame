package org.pltw.examples.thecardgame;

import android.widget.ImageView;

public abstract class Card {
    private String imageSource;
    private String value; //lowercase
    private String suit; //lowercase
    private String position;
    private int cost;
    private ImageView imageDisplay;


    public Card() {
    }

    public Card(String imageSource, String value, String suit, String position, int cost, ImageView imageDisplay) {
        this.imageSource = imageSource;
        this.value = value;
        this.suit = suit;
        this.position = position;
        this.cost = cost;
        this.imageDisplay = imageDisplay;
    }

    public Card(String value, String suit, String position) {
        //for jokers, value = "rj" or "bj" and suit = ""
        imageSource = "card_" + value + suit;
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


    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ImageView getImageDisplay() {
        return imageDisplay;
    }

    public void setImageDisplay(ImageView imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
}
