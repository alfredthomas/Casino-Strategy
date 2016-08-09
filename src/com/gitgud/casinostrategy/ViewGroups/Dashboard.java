package com.gitgud.casinostrategy.ViewGroups;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gitgud.casinostrategy.Cards.Shoe;
import com.gitgud.casinostrategy.Cards.Shuffle;
import com.gitgud.casinostrategy.Games.VideoPoker.PokerBase;

/**
 * Created by AJ on 12/10/2015.
 */
public class Dashboard extends ImprovedViewGroup {
    int handSize;
    Shoe shoe;
    TextView result;
    Button dealButton;
    Hand hand;
    Button shuffleButton;
    public Dashboard (Context context,Shoe shoe,int handSize){
        super(context);
        this.shoe = shoe;
        this.handSize=handSize;
        dealButton = new Button(context);

        hand = new Hand(context,shoe,handSize);
        this.addView(hand);
        result = new TextView(this.getContext());
        result.setText(PokerBase.analyzeHand(hand.getCurrentCards()));
        result.setTypeface(null, Typeface.BOLD_ITALIC);
        result.setTextSize(25f);
        result.setTextColor(Color.WHITE);
        result.setGravity(Gravity.CENTER);
        dealButton.setText("Deal");
        dealButton.setBackgroundColor(Color.WHITE);
        dealButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hand.redealHand();
                result.setText(PokerBase.analyzeHand(hand.getCurrentCards()));
            }
        });
        shuffleButton = new Button(context);
        shuffleButton.setText("Shuffle");
        shuffleButton.setBackgroundColor(Color.WHITE);
        shuffleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hand.deselectAll();
                shoe.replaceShoe(Shuffle.Shuffle(shoe, Shuffle.Method.Random));
                dealButton.callOnClick();
            }
        });

        this.addView(dealButton);
        this.addView(shuffleButton);
        this.addView(result);
        this.setBackgroundColor(Color.rgb(0, 153, 0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int padding = (int)(5 * getResources().getDisplayMetrics().density);
        this.measureView(result,0,0,MeasureSpec.getSize(widthMeasureSpec),(int)(MeasureSpec.getSize(heightMeasureSpec) * 0.1));
        this.measureView(hand, 0, (int)(MeasureSpec.getSize(heightMeasureSpec) * 0.1), MeasureSpec.getSize(widthMeasureSpec), (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.8));
        this.measureView(dealButton, (int)(MeasureSpec.getSize(widthMeasureSpec)*.75)-300, (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.75),300,200 );
        this.measureView(shuffleButton, (int)(MeasureSpec.getSize(widthMeasureSpec)*.75) + padding, (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.75) , 300, 200);



    }
}
