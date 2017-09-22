package com.iteso.seccion10;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar)findViewById(R.id.activity_main_toolbar);
        viewPager=(ViewPager)findViewById(R.id.activity_main_viewpager);
        tabLayout =(TabLayout)findViewById(R.id.activity_main_tabs);
        SectionAdapter sectionAdapter = new SectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(sectionAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public class SectionAdapter extends FragmentPagerAdapter{
        public SectionAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentTechnology();
                case 1:
                    return new FragmentHome();
                case 2:
                    return new FragmentElectronics();
                default:
                    return new FragmentTechnology();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return  getString(R.string.tab1);
                case 1:
                    return  getString(R.string.tab2);
                case 2:
                    return  getString(R.string.tab3);
            }

            return super.getPageTitle(position);
        }
    }

    public static class PlaceHolder extends Fragment{
        public static PlaceHolder newInstance(){
            return new PlaceHolder();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_main,container,false);
        }
    }
}
