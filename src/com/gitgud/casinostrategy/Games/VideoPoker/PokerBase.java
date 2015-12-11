package com.gitgud.casinostrategy.Games.VideoPoker;

import com.gitgud.casinostrategy.Cards.Card;
import com.gitgud.casinostrategy.Cards.Deck;
import com.gitgud.casinostrategy.ViewGroups.Hand;

import java.util.ArrayList;

/**
 * Created by alfredthomas on 12/11/15.
 */
public class PokerBase {
    /*
        HIERARCHY:
            Royal Flush
            Straight Flush
            Four of a kind
            full house
            flush
            straight
            three of a kind
            two pair
            pair
            nothing
    */

    public static String analyzeHand(ArrayList<Card> cards){
     String result= null;


        return result;
    }
    public static boolean isRoyal(ArrayList<Card> cards){

        if(isFlush(cards))
            return true;
        return false;
    }
    public static boolean isStraightFlush(ArrayList<Card> cards){
        if(isFlush(cards) && isStraight(cards))
            return true;
        return false;
    }
    public static boolean isFourOfKind(ArrayList<Card> cards){

        return false;
    }
    public static boolean isFullHouse(ArrayList<Card> cards){

        return false;
    }
    public static boolean isFlush(ArrayList<Card> cards){
        Deck.Suit suit = cards.get(0).getSuit();
        for(int i=0; i< cards.size();i++){
            if(cards.get(i).getSuit()!= suit)
                    return false;
        }
        return true;
    }
    public static boolean isStraight(ArrayList<Card> cards){

        return false;
    }
    public static boolean isThreeOfAKind(ArrayList<Card> cards){

        return false;
    }
    public static boolean isTwoPair(ArrayList<Card> cards){

        return false;
    }
    public static boolean isPair(ArrayList<Card> cards){

        return false;
    }
    private static ArrayList<Card> sortedCards(ArrayList<Card> cards){
        return null;
    }
    private static ArrayList<Deck.Rank> getCardRanks(ArrayList<Card> cards){
        ArrayList<Deck.Rank> cardRanks = new ArrayList<>(cards.size());
        for(int i = 0; i<cards.size();i++){
            cardRanks.add(i,cards.get(i).getRank());
        }
        return cardRanks;
    }
}
