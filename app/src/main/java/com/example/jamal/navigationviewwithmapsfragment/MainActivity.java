package com.example.jamal.navigationviewwithmapsfragment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ViewPager viewPager;
    static int fragmentPosition=-1;
    MainActivity.Adapter adapter;
    String[] tabsTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new MainActivity.Adapter(getSupportFragmentManager());
        if(getIntent()!=null && getIntent().getIntExtra("fragmentPosition",-1)!=-1){
            fragmentPosition= getIntent().getIntExtra("fragmentPosition",-1);
            setupViewPager(viewPager);
            viewPager.setCurrentItem(fragmentPosition);
            adapter.notifyDataSetChanged();

        }else{
            setupViewPager(viewPager);
        }
    }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        tabsTitles=new String[]{"Map","Profile"};
        adapter.addFragment(new MapFragement(), "Map ");
        adapter.addFragment(new ProfileFragment(),"Profile");

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setTitle(tabsTitles[position]);
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }
            @Override
            public void onPageScrollStateChanged(int pos) {
                // TODO Auto-generated method stub

            }
        });
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




}

