package com.gitgud.casinostrategy.Cards;

import java.util.ArrayList;

/**
 * Created by AJ on 5/9/2015.
 */
public class Deck {
    public ArrayList<Card> deck;
    public enum Suit {
        Clubs, Diamonds, Hearts,Spades
    }
    public enum Rank{
        Ace, Two, Three, Four, Five, Six, Seven,
        Eight, Nine, Ten, Jack, Queen, King, Joker
    }
    public Deck(boolean jokers){
        deck = new ArrayList<>(52);
        for(Suit suit: Suit.values()){
            for (Rank rank: Rank.values()){
                //only allow jokers if requested and only for Spades and Hearts
                if (rank == Rank.Joker && jokers && (suit==Suit.Clubs||suit == Suit.Diamonds))
                    continue;
                deck.add(new Card(suit,rank));
            }
        }
    }
    public static int getSize(boolean jokers){
        if (jokers)
            return 54;
        return 52;
    }
}
