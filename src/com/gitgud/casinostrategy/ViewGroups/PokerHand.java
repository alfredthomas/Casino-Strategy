package com.gitgud.casinostrategy.ViewGroups;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import com.gitgud.casinostrategy.Cards.Deck;
import com.gitgud.casinostrategy.Cards.Shoe;

/**
 * Created by AJ on 12/7/2015.
 */
public class PokerHand extends ImprovedViewGroup {
    public PokerHand(Context context, Shoe shoe){
        super(context);

        for (int i = 0; i<5; i++){
            CardVisualization cv = new CardVisualization(context);
            cv.setCard(shoe.DealCard());
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cv.setCard(shoe.DealCard());
                }
            });
            this.addView(cv);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(paint);
    }
}
