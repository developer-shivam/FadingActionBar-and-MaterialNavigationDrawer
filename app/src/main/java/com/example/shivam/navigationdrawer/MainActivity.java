package com.example.shivam.navigationdrawer;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ColorDrawable colorDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DrawerLayout layout = (DrawerLayout) findViewById(R.id.mainDrawer);

        colorDrawable = new ColorDrawable();
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        colorDrawable.setColor(Color.rgb(0, 0, 0));
        colorDrawable.setAlpha(0);
        toolbar.setBackgroundDrawable(colorDrawable);
        toolbar.setTitle(Html.fromHtml("<b><font color='#ffffff'>Navigation Drawer</font></b>"));
        toolbar.setSubtitle(Html.fromHtml("<font color='#ffffff'>Material Navigation Drawer</font>"));

        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        addTextViews(ll);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        ScrollViewX scrollView = (ScrollViewX) findViewById(R.id.scroll_view);
        scrollView.setOnScrollChangeListener(new ScrollViewX.OnScrollChangeListener() {
            @Override
            public void onScrollChanged(ScrollViewX view, int l, int t, int oldl, int oldt) {
                colorDrawable.setAlpha(getAlphaforActionBar(view.getScrollY()));
            }

            private int getAlphaforActionBar(int scrollY) {
                int minDist = 0,maxDist = 650;
                if(scrollY>maxDist){
                    return 255;
                }
                else if(scrollY<minDist){
                    return 0;
                }
                else {
                    int alpha = 0;
                    alpha = (int)  ((255.0/maxDist)*scrollY);
                    return alpha;
                }
            }
        });
        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDrawer);
        navigationDrawerFragment.setUp(layout, toolbar);

    }

    private void addTextViews(LinearLayout li) {

        for (int i = 0; i < 26; i++) {
            TextView tv1 = new TextView(this);
            tv1.setText(String.valueOf(i));
            tv1.setTextSize(10);
            tv1.setWidth(500);
            tv1.setHeight(500);
            tv1.setBackgroundColor(Color.rgb(255-10*i, 255-10*i, 255-10*i)); //just for fun , varying back grounds
            tv1.setGravity(Gravity.CENTER);
            li.addView(tv1);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
