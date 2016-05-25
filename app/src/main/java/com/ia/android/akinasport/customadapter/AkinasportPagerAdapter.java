package com.ia.android.akinasport.customadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Arnaud on 12/05/2016.
 */
public class AkinasportPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;

    public AkinasportPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.mFragments.get(position);
    }

    @Override
    public int getCount() {

        return this.mFragments.size();
    }

    @Override
    public int getItemPosition(Object object) {
        int index = mFragments.indexOf (object);
        if (index == -1)
            return POSITION_NONE;
        else
            return index;
    }


    public void addFragment(Fragment view, int index) {
        mFragments.add(index, view);
        notifyDataSetChanged();
    }

    public void addFragmentAtLast(Fragment view)
    {
        mFragments.add(view);
        notifyDataSetChanged();
    }

    public void removeView(int index) {
        mFragments.remove(index);
        notifyDataSetChanged();
    }
}
