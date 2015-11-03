package com.example.boncuk.fragmentadapterproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

import com.example.boncuk.fragmentadapterproject.fragment.Fragment1;
import com.example.boncuk.fragmentadapterproject.fragment.Fragment2;
import com.example.boncuk.fragmentadapterproject.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomFragmentPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(2);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // TODO : Something
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

       viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               // TODO : Something
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });

    }

    private class CustomFragmentPagerAdapter extends FragmentPagerAdapter{

        Fragment1 fragment1;
        Fragment2 fragment2;
        Fragment3 fragment3;

        public  CustomFragmentPagerAdapter(android.support.v4.app.FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                if(fragment1 == null){
                    fragment1 = Fragment1.getInstance();
                }
                return  fragment1;
            }else if(position == 1){
                if(fragment2 == null){
                    fragment2 = Fragment2.getInstance();
                }
                return fragment2;
            }else if(position == 2){
                if(fragment3 == null){
                    fragment3 = Fragment3.getInstance();
                }
                return fragment3;
            }else{
                return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "Title - " + String.valueOf(position);
        }

        @Override
        public int getCount() {
            return 3;
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
