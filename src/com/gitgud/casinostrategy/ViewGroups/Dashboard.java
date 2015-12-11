package com.gitgud.casinostrategy.ViewGroups;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import com.gitgud.casinostrategy.Cards.Shoe;
import com.gitgud.casinostrategy.Cards.Shuffle;

/**
 * Created by AJ on 12/10/2015.
 */
public class Dashboard extends ImprovedViewGroup {
    int handSize;
    Shoe shoe;
    public Dashboard (Context context,Shoe shoe,int handSize){
        super(context);
        this.shoe = shoe;
        this.handSize=handSize;
        Button dealButton = new Button(context);

        Hand hand = new Hand(context,shoe,handSize);
        this.addView(hand);

        dealButton.setText("Deal");
        dealButton.setBackgroundColor(Color.WHITE);
        dealButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hand.redealHand();
            }
        });
        Button shuffleButton = new Button(context);
        shuffleButton.setText("Shuffle");
        shuffleButton.setBackgroundColor(Color.WHITE);
        shuffleButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                shoe.replaceShoe(Shuffle.Shuffle(shoe, Shuffle.Method.Random));
            }
        });

        this.addView(dealButton);
        this.addView(shuffleButton);
        this.setBackgroundColor(Color.rgb(0, 153, 0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int padding = (int)(5 * getResources().getDisplayMetrics().density);
        this.measureView(this.getChildAt(0), 0, 0, MeasureSpec.getSize(widthMeasureSpec), (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.8));
        this.measureView(this.getChildAt(1), (int)(MeasureSpec.getSize(widthMeasureSpec)*.75)-300, (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.75),300,200 );
        this.measureView(this.getChildAt(2), (int)(MeasureSpec.getSize(widthMeasureSpec)*.75) + padding, (int) (MeasureSpec.getSize(heightMeasureSpec) * 0.75) , 300, 200);



    }
}
