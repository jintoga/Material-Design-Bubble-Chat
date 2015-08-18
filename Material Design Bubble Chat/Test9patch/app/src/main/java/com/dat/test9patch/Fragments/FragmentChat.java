package com.dat.test9patch.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dat.test9patch.FragmentsConversations.FragmentConversation1;
import com.dat.test9patch.FragmentsConversations.FragmentConversation2;
import com.dat.test9patch.FragmentsConversations.FragmentConversation3;
import com.dat.test9patch.R;
import com.dat.test9patch.ViewPagerAdapter;

public class FragmentChat extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        getIDs(view);
        setEvents();
        return view;
    }

    private void getIDs(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.my_viewpager);
        setViewPager(viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.my_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setEvents() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFrag(new FragmentConversation1(), "Friend 1");
        adapter.addFrag(new FragmentConversation2(), "Friend 2");
        adapter.addFrag(new FragmentConversation3(), "Friend 3");
        adapter.addFrag(new FragmentConversation2(), "Friend 4");
        adapter.addFrag(new FragmentConversation3(), "Friend 5");
        adapter.addFrag(new FragmentConversation2(), "Friend 6");
        adapter.addFrag(new FragmentConversation3(), "Friend 7");
        adapter.addFrag(new FragmentConversation2(), "Friend 8");
        adapter.addFrag(new FragmentConversation3(), "Friend 9");
        viewPager.setAdapter(adapter);
    }

}
