package com.gitgud.casinostrategy;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.gitgud.casinostrategy.Cards.Shoe;
import com.gitgud.casinostrategy.ViewGroups.CardVisualization;
import com.gitgud.casinostrategy.ViewGroups.Dashboard;
import com.gitgud.casinostrategy.ViewGroups.ImprovedViewGroup;
import com.gitgud.casinostrategy.ViewGroups.Hand;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Shoe singleShoe = new Shoe(1,true);
//        CardVisualization cv = new CardVisualization(this);
//        cv.setCard(singleShoe.DealCard());
//        cv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cv.setCard(singleShoe.DealCard());
//            }
//        });
//        cv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        this.setContentView(cv);
        Dashboard dashboard = new Dashboard(this,singleShoe,5);

        this.setContentView(dashboard);

    }
}
