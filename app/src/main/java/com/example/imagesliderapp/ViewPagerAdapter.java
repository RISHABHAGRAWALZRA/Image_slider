package com.example.imagesliderapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<CityImageFragment> fragments;
    private ArrayList<String> titles=new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments=new ArrayList<>();
        titles.add("First");
        titles.add("Second");
        titles.add("Third");
        titles.add("Fourth");
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setFragments(ArrayList<CityImageFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }
}
