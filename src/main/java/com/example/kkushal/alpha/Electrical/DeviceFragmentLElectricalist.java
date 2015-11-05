package com.example.kkushal.alpha.Electrical;

/**
 * Created by KKushal on 04-Sep-15.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kkushal.alpha.DeviceListTemplate;
import com.example.kkushal.alpha.Tab.SlidingTabLayout;
import com.example.ui.R;


public class DeviceFragmentLElectricalist extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail, container,false);

        return rootView;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);

        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getChildFragmentManager()));

        // Bind the tabs to the ViewPager
        SlidingTabLayout tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
        tabs.setViewPager(pager);
    }


    public class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        private final String[] TITLES = { "CIRCUIT BREAKERS", "ENCLOSURE", "FANS"};

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int arg0) {

            switch (arg0) {

                case 0:
                    return new CircuitBreakersList();

                case 1:
                    return new EnclosuresList();

                case 2:
                    return new FansList();

            }
            return new DeviceListTemplate("b");
        }



    }


}