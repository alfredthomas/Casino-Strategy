package com.gitgud.casinostrategy.Cards;

import java.util.ArrayList;

/**
 * Created by AJ on 5/9/2015.
 */
public class Shoe {
    int cardPointer;
    public enum shuffleMethod{
        Hand, Automatic, Random
    }
    public ArrayList<Card> shoe;
    public Shoe(int decks){
        this(decks,false);
    }
    public Shoe(int decks, boolean jokers){
        shoe = new ArrayList<>(Deck.getSize(jokers)*decks);
        for(int i= 0; i< decks; i++){
            Deck deck = new Deck(jokers);
            shoe.addAll(deck.deck);
        }
        this.cardPointer= 0;
    }
    public Card DealCard(){
        if (cardPointer >= this.shoe.size()){
            //shuffle

            //for now we will loop
            this.cardPointer = 0;
        }
        Card toDeal = shoe.get(this.cardPointer);
        this.cardPointer++;
        return toDeal;
    }


}
