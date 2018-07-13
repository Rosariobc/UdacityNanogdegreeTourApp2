package com.example.android.tourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.Locale;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context aContext;

    public CategoryAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        aContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DowntownFragment();
        } else if (position == 1){
            return new MidtownFragment();
        } else if (position == 2) {
            return new NorthFragment();
        } else {
            return new EastFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();

        // Generate title based on item position
        switch (position){
            case 0:

                return aContext.getString(R.string.category_downtown).toUpperCase(l);
            case 1:

                return aContext.getString(R.string.category_midtown).toUpperCase(l);
            case 2:

                return aContext.getString(R.string.category_north).toUpperCase(l);
            case 3:

                return aContext.getString(R.string.category_east).toUpperCase(l);
        }
        return null;
    }
}
