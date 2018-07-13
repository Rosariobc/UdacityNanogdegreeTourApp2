package com.example.android.tourapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    CategoryAdapter aCategoryAdapter;
    ViewPager aViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Create an adapter that knows which fragment should be shown on each page
        aCategoryAdapter = new CategoryAdapter(this,getSupportFragmentManager());

        // Find the view pager that will allow the user to swipe between fragments
        aViewPager = (ViewPager) findViewById(R.id.pager);

        // Set the adapter onto the view pager
        aViewPager.setAdapter(aCategoryAdapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabbar);
        tabLayout.setupWithViewPager(aViewPager);
    }
}
