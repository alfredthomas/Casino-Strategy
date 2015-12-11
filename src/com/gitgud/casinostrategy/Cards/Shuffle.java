package com.gitgud.casinostrategy.Cards;

import java.util.ArrayList;

/**
 * Created by AJ on 12/10/2015.
 */
public class Shuffle {
    public enum Method{
        Hand, Automatic, Random
    }
    public static ArrayList<Card> Shuffle(Shoe shoe, Method type){
        switch (type)
        {
            case Hand:return handShuffle(shoe);
            case Automatic:return automaticShuffle(shoe);
            case Random:return randomShuffle(shoe);
        }
        return shoe.shoe;
    }
    public static ArrayList<Card> handShuffle(Shoe shoe){
        //disperse remaining cards into top middle and bottom of deck accordingly
        //break into 6 piles and take a little off the tops of 3 piles and shuffle with the same from the other three piles
        //shuffle until shoe is finished and then repeat entire process again


        //get discard pile
        int discardIndex = shoe.cardPointer;
        return shoe.shoe;
    }
    public static ArrayList<Card> automaticShuffle(Shoe shoe){
        return shoe.shoe;
    }
    public static ArrayList<Card> randomShuffle(Shoe shoe){
        //randomly select a position on old shoe
        //randomly select a position in the new shoe

        ArrayList<Card> newShoe = new ArrayList<Card>();
        ArrayList<Integer> newShoeIndexes = new ArrayList<Integer>();
        ArrayList<Integer> oldShoeIndexes = new ArrayList<Integer>();

        for (int i=0; i<shoe.shoe.size();i++)
        {
            //fill arrays so we can add/replace later
            oldShoeIndexes.add(i);
            newShoeIndexes.add(i);
            newShoe.add(null);
        }

        while(oldShoeIndexes.size()>0)
        {
            //generate random number for old shoe
            int oldIndex = (int)(Math.random()*oldShoeIndexes.size());
            //generate random number for new shoe
            int newIndex = (int)(Math.random()*newShoeIndexes.size());

            newShoe.set(newShoeIndexes.get(newIndex),shoe.shoe.get(oldShoeIndexes.get(oldIndex)));

            oldShoeIndexes.remove(oldIndex);
            newShoeIndexes.remove(newIndex);

        }
        if (newShoe.contains(null))
            return shoe.shoe;
        return newShoe;
    }

}
