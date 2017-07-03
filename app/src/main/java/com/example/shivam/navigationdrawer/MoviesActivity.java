package com.example.shivam.navigationdrawer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MoviesActivity extends AppCompatActivity {

    ScrollViewX fadeScrollView;
    LinearLayout container;
    ImageView ivBackground;

    int thresholdDistance = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        ivBackground = (ImageView) findViewById(R.id.iv_background);
        ivBackground.setAlpha(0f);
        container = (LinearLayout) findViewById(R.id.container);
        addTextViews(container);
        fadeScrollView = (ScrollViewX) findViewById(R.id.fade_scroll_view);
        fadeScrollView.setOnScrollChangeListener(new ScrollViewX.OnScrollChangeListener() {

            @Override
            public void onScrollChanged(ScrollViewX view, int l, int t, int oldL, int oldT) {
                ivBackground.setAlpha(getAlphaForImageBackground(view.getScrollY()));
            }

            private float getAlphaForImageBackground(int scrollY) {
                int minimumDistance = 0, maxDistance = thresholdDistance;
                if (scrollY > maxDistance) {
                    return 1f;
                } else if (scrollY < minimumDistance) {
                    return 0f;
                } else {
                    return ((255.0f / maxDistance) * scrollY) / 255f;
                }
            }
        });
    }

    private void addTextViews(LinearLayout li) {

        for (int i = 0; i < 26; i++) {
            TextView textView = new TextView(this);
            textView.setText(String.valueOf(i));
            textView.setTextSize(20);
            textView.setTextColor(Color.WHITE);
            textView.setWidth(ScrollView.LayoutParams.MATCH_PARENT);
            textView.setAlpha(0.5f);
            textView.setHeight(200);
            textView.setBackgroundColor(Color.parseColor("#50000000"));
            textView.setGravity(Gravity.CENTER);
            li.addView(textView);

        }
    }
}

