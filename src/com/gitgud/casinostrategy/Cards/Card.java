package com.gitgud.casinostrategy.Cards;

/**
 * Created by AJ on 5/9/2015.
 */
public class Card {

    Deck.Suit suit;
    Deck.Rank rank;
    public Card(Deck.Suit suit, Deck.Rank rank){
        this.suit = suit;
        this.rank = rank;
    }
    public int getValue()
    {
        switch (rank){
            case Ace:return 11;
            case Two:return 2;
            case Three:return 3;
            case Four:return 4;
            case Five:return 5;
            case Six:return 6;
            case Seven:return 7;
            case Eight:return 8;
            case Nine:return 9;
            case Ten:return 10;
            case Jack:return 10;
            case Queen:return 10;
            case King:return 10;
            default:return -1;
        }
    }
}
