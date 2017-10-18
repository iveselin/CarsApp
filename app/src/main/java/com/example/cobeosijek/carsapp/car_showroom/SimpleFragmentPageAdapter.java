package com.example.cobeosijek.carsapp.car_showroom;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cobeosijek on 17/10/2017.
 */

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    private List<String> tabTitles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    public SimpleFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setTabTitles(List<String> stringList) {
        tabTitles = stringList;
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public String getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles.get(position);
    }
}
