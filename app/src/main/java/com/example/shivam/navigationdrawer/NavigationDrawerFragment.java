package com.example.shivam.navigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NavigationDrawerFragment extends Fragment {

    DrawerLayout mDrawerLayout;
    ActionBarDrawerToggle mDrawerToggle;
    Runnable run;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }


    public void setUp(DrawerLayout layout, Toolbar toolbar) {
        mDrawerLayout = layout;
        mDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),
                mDrawerLayout,
                toolbar,
                R.string.open,
                R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        run = new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        };

        mDrawerLayout.post(run);
    }
}
