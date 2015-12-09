package com.gitgud.casinostrategy.ViewGroups;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.gitgud.casinostrategy.Cards.Card;
import com.gitgud.casinostrategy.Cards.Deck;
import com.gitgud.casinostrategy.R;

/**
 * Created by AJ on 5/12/2015.
 */
public class CardVisualization extends View {
    Card card;
    Paint paint = new Paint();
    public CardVisualization(Context context){
        super(context);
    }
    public CardVisualization(Context context,Card card){
        super(context);
        this.card = card;
    }
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (card == null)
            return;
        paint.setTextSize(100);
        int x = getWidth();
        int y = getHeight();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        //draw card rank in top left and bottom right
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setColor(Color.BLACK);
        canvas.drawText(card.getRankString(), 0, 0 + paint.getTextSize(), paint);

        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(card.getRankString(), canvas.getWidth() - paint.measureText(card.getRankString()), canvas.getHeight(), paint);



        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(card.getSuitColor());
        canvas.drawText(card.getSuitString(),(canvas.getWidth()/2)-(paint.measureText(card.getSuitString())/2),(canvas.getHeight()/2)+(paint.getTextSize()/2),paint);




//        // Use Color.parseColor to define HTML colors
//        paint.setColor(Color.parseColor("#CD5C5C"));
//        canvas.drawCircle(x / 2, y / 2, radius, paint);

        //draw suit in proper color
    }

    public void setCard(Card card){
        this.card = card;
        this.invalidate();
   }

}
