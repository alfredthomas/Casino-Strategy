package com.gitgud.casinostrategy.Cards;

import java.util.ArrayList;

/**
 * Created by AJ on 5/9/2015.
 */
public class Shoe {
    public ArrayList<Card> shoe;
    public Shoe(int decks, boolean jokers){
        shoe = new ArrayList<>(Deck.getSize(jokers)*decks);
        for(int i= 0; i< decks; i++){
            Deck deck = new Deck(jokers);
            shoe.addAll(deck.deck);
        }
    }

}
