package com.gitgud.casinostrategy.Cards;

import android.graphics.Color;

/**
 * Created by AJ on 5/9/2015.
 */
public class Card {
    Deck.Suit suit;
    Deck.Rank rank;
    String rankString;
    String suitString;
    int suitColor;
    int value;

    public Card(Deck.Suit suit, Deck.Rank rank){
        this.suit = suit;
        this.rank = rank;

        switch (suit){
            case Clubs:suitString=""+(char)'\u2663'; suitColor=Color.BLACK; break;
            case Diamonds:suitString=""+(char)'\u2666';suitColor=Color.RED;break;
            case Spades:suitString=""+(char)'\u2660';suitColor=Color.BLACK;break;
            case Hearts:suitString=""+(char)'\u2665';suitColor=Color.RED;break;
        }
        switch (rank){
            case Ace:value=11;rankString="A";break;
            case Two:value=2;rankString="2";break;
            case Three:value=3;rankString="3";break;
            case Four:value=4;rankString="4";break;
            case Five:value=5;rankString="5";break;
            case Six:value=6;rankString="6";break;
            case Seven:value=7;rankString="7";break;
            case Eight:value=8;rankString="8";break;
            case Nine:value=9;rankString="9";break;
            case Ten:value=10;rankString="10";break;
            case Jack:value=10;rankString="J";break;
            case Queen:value=10;rankString="Q";break;
            case King:value=10;rankString="K";break;
            case Joker:value=-1;rankString="Joker";break;
        }
    }
    public int getValue()
    {
        return this.value;
    }

    public Deck.Suit getSuit() {
        return suit;
    }
    public String getSuitString(){
        return this.suitString;
    }
    public Deck.Rank getRank() {
        return this.rank;
    }
    public String getRankString() {
        return this.rankString;
    }
    public int getSuitColor(){
        return this.suitColor;
    }
}
