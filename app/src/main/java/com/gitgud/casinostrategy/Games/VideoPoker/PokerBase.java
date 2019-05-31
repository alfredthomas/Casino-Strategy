package com.gitgud.casinostrategy.Games.VideoPoker;

import com.gitgud.casinostrategy.Cards.Card;
import com.gitgud.casinostrategy.Cards.Deck;
import com.gitgud.casinostrategy.ViewGroups.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
     String result;
        if(isRoyal(cards))
            result = "Royal Flush";
        else if(isStraightFlush(cards))
            result = "Straight Flush";
        else if(isFourOfKind(cards))
            result = "Four of a Kind";
        else if(isFullHouse(cards))
            result = "Full House";
        else if(isFlush(cards))
            result = "Flush";
        else if(isStraight(cards))
            result = "Straight";
        else if(isThreeOfAKind(cards))
            result = "Three of a Kind";
        else if(isTwoPair(cards))
            result = "Two Pair";
        else if(isPair(cards))
            result = "Pair";
        else
            result = "Nothing";


        return result;
    }
    public static boolean isRoyal(ArrayList<Card> cards){
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);
        if(isFlush(cards)&&(sortedCards[9].size()==1 && sortedCards[10].size()==1 && sortedCards[11].size()==1 &&sortedCards[0].size()==1))
            return true;
        return false;
    }
    public static boolean isStraightFlush(ArrayList<Card> cards){
        if(isFlush(cards) && isStraight(cards))
            return true;
        return false;
    }
    public static boolean isFourOfKind(ArrayList<Card> cards){
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);
        for(int i = 0; i<14; i++)
        {
            if (sortedCards[i].size() == 4)
                return true;
        }
        return false;
    }
    public static boolean isFullHouse(ArrayList<Card> cards){
        if(isThreeOfAKind(cards)&&isPair(cards))
            return true;
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
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);

        //find first card (not an ace)
        int first=-1;
        for(int i = 1; i<14;i++)
        {
            if (sortedCards[i].size()==1)
            {
                first = i;
                break;
            }
        }
        if(first==-1)
            return  false;
        for(int i = first; i<first+5; i++)
        {
            //if the first found card is a 2 or a 10 and we are on the last card to check
            if(i == first+4 && (first==1 || first == 9) && containsAce(sortedCards))
                return true;

            else if(i<sortedCards.length &&sortedCards[i].size()==1)
                continue;
            else
                return false;
        }

        return true;
    }
    public static boolean isThreeOfAKind(ArrayList<Card> cards){
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);
        for(int i = 0; i<14; i++)
        {
            if (sortedCards[i].size() == 3)
                return true;
        }
        return false;
    }
    public static boolean isTwoPair(ArrayList<Card> cards){
        boolean anotherPair = false;
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);
        for(int i = 0; i<14; i++)
        {
            if (sortedCards[i].size() == 2 && anotherPair)
                return true;
            else if(sortedCards[i].size() == 2 && !anotherPair)
                anotherPair = true;
        }
        return false;
    }
    public static boolean isPair(ArrayList<Card> cards){
        ArrayList<Card>[] sortedCards = sortedCardsByRank(cards);
        for(int i = 0; i<14; i++)
        {
            if (sortedCards[i].size() == 2)
                return true;
        }
        return false;
    }
    public static Deck.Rank whichPair(ArrayList<Card> cards)
    {
        return Deck.Rank.Joker;
    }
    public static boolean containsAce(ArrayList<Card>[] sortedCards)
    {
        if(sortedCards[0].size()>0)
            return true;
        return false;
    }
    public static boolean containsJoker(ArrayList<Card>[] sortedCards)
    {
        if(sortedCards[13].size()>0)
            return true;
        return false;
    }
    private static ArrayList<Card>[] sortedCardsByRank(ArrayList<Card> cards){
        ArrayList<Card>[] sortedHand = new ArrayList[14];
        for(int i= 0; i<14; i++)
        {
            sortedHand[i] = new ArrayList<>();
        }
        for (Card card:cards)
        {
            switch (card.getRank())
            {
                case Ace: sortedHand[0].add(card);break;
                case Two: sortedHand[1].add(card);break;
                case Three: sortedHand[2].add(card);break;
                case Four: sortedHand[3].add(card);break;
                case Five: sortedHand[4].add(card);break;
                case Six: sortedHand[5].add(card);break;
                case Seven: sortedHand[6].add(card);break;
                case Eight: sortedHand[7].add(card);break;
                case Nine: sortedHand[8].add(card);break;
                case Ten: sortedHand[9].add(card);break;
                case Jack: sortedHand[10].add(card);break;
                case Queen: sortedHand[11].add(card);break;
                case King: sortedHand[12].add(card);break;
                case Joker: sortedHand[13].add(card);break;
            }
        }
        return sortedHand;
    }
    private static void sortByRank(ArrayList<Card> cards)
    {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card card, Card t1) {
                if(card.getRank().ordinal()<t1.getRank().ordinal())
                    return -1;
                else if (card.getRank().ordinal()>t1.getRank().ordinal())
                    return 1;
                else
                    return 0;
            }
        });
    }
    private static ArrayList<Deck.Rank> getCardRanks(ArrayList<Card> cards){
        ArrayList<Deck.Rank> cardRanks = new ArrayList<>(cards.size());
        for(int i = 0; i<cards.size();i++){
            cardRanks.add(i,cards.get(i).getRank());
        }
        return cardRanks;
    }
}
