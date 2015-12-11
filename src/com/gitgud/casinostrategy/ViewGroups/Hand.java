package com.gitgud.casinostrategy.ViewGroups;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.gitgud.casinostrategy.Cards.Card;
import com.gitgud.casinostrategy.Cards.Deck;
import com.gitgud.casinostrategy.Cards.Shoe;

import java.util.ArrayList;

/**
 * Created by AJ on 12/7/2015.
 */
public class Hand extends ImprovedViewGroup {
    int handSize;
    Shoe shoe;
    ArrayList<Card> currentCards;
    public Hand(Context context, Shoe shoe, int handSize){
        super(context);
        this.handSize = handSize;
        this.shoe = shoe;
        this.currentCards = new ArrayList<>(handSize);
        for (int i = 0; i<handSize; i++){
            CardVisualization cv = new CardVisualization(context);
            Card newCard = shoe.DealCard();
            cv.setCard(newCard);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cv.hold = !cv.hold;
                    GradientDrawable gd = (GradientDrawable) cv.getBackground();
                    if (cv.hold){
                        gd.setColor(Color.CYAN);
                        gd.setCornerRadius(8);
                        gd.setStroke(3, Color.BLACK);
                    }
                    else{
                        gd.setColor(Color.WHITE);
                        gd.setCornerRadius(8);
                        gd.setStroke(3, Color.BLACK);
                    }

                }
            });
            cv.setOnLongClickListener(new OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    redealHand();
                    return true;
                }
            });
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(Color.WHITE);
            gd.setCornerRadius(8);
            gd.setStroke(3, Color.BLACK);

            cv.setBackground(gd);
            this.addView(cv);
            this.currentCards.add(i,newCard);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int availWidth = MeasureSpec.getSize(widthMeasureSpec);

        float padding = 5f * getResources().getDisplayMetrics().density;

        float aspectRatio = 1.5f;
        float x = padding;
        float y = padding;

        float width = (availWidth- ((handSize+1) * padding))/handSize;
        float height = width * aspectRatio;

        for (int i = 0; i<handSize;i++){
            this.measureView(this.getChildAt(i),(int)x,(int)y,(int)width,(int)height);
            x+=padding+width;
        }

    }

    public void redealHand()
    {
        for (int i=0; i<this.getChildCount();i++){
            CardVisualization cv = (CardVisualization)this.getChildAt(i);

            if (cv.hold == true)
                continue;
            Card newCard = shoe.DealCard();
            cv.setCard(newCard);
            this.currentCards.set(i,newCard);
        }
    }
    public ArrayList<Card> getCurrentCards(){
        return currentCards;
    }
}
