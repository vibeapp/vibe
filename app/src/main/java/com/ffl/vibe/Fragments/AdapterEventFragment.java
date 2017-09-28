package com.ffl.vibe.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by PJS on 9/22/2017.
 */

public class AdapterEventFragment extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private Context context;
    public AdapterEventFragment(FragmentManager fm, Context context)
    {
        super(fm);

    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position)
    {
        // return AllEventFragment.newInstance(position +1);
        switch (position)
        {
            case 0:
                return AllEventFragment.newInstance(position+1);
            case 1:
                return LiveFragment.newInstance(position+1);
            case 2:
                return MyeventFragment.newInstance(position+1);
            case 3:
                return ClubFragment.newInstance(position+1);
            default:
                return  null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        //return tabTitles[position];
        switch (position) {
            case 0:
                return "All Event";
            case 1:
                return "Live";
            case 2:
                return "My Event";
            case 3:
                return "Club";
        }
        return null;
    }
}
