package com.example.eggapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.eggapplication.databinding.ActivityReadyBinding;

public class Ready extends AppCompatActivity {
    private ActivityReadyBinding binding;
    //FragmentPagerAdapter adapterViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityReadyBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        final FragmentPagerAdapter adapterViewPager;
        setContentView(view);


        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        binding.vpPager.setAdapter(adapterViewPager);

/*        for(int i=0;i<Egg.READY.length;i++){
            tv.setText(Egg.READY[i]);
        }*/


    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return BoilMethod1.newInstance(0, "Page # 1");
                case 1:
                    return BoilMethod2.newInstance(1, "Page # 2");
                case 2:
                    return Start.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }


}
