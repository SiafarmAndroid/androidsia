package com.siafarm.homefragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siafarm.R;
import com.siafarm.gravityhelper.GravitySnapHelper;
import com.siafarm.homefragment.utils.AutoScrollViewPager;
import com.siafarm.mainactivity.adapter.Adapter;
import com.siafarm.mainactivity.adapter.SnapAdapter;
import com.siafarm.mainactivity.model.App;
import com.siafarm.mainactivity.model.Snap;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static final String ORIENTATION = "orientation";
    private AutoScrollViewPager viewPager;
    private int layoutsCount = 4;
    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initViews(view);
        setViewPagerAdapter();


        if (savedInstanceState == null) {
            mHorizontal = true;
        } else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }
        setupAdapter();
        return view;
    }

    private void setViewPagerAdapter() {

        viewPager.startAutoScroll();
        viewPager.setInterval(3000);
        viewPager.setCycle(true);
        viewPager.setStopScrollWhenTouch(true);

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }

    private void initViews(View view) {
        viewPager = view.findViewById(R.id.view_pager);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);
    }




    private void setupAdapter() {
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter(getActivity());
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER, getResources().getString(R.string.news_updated), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.modern_agri), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.vegetable_farming), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.products), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.services), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.gallery), apps));
            mRecyclerView.setAdapter(snapAdapter);
        } else {
            Adapter adapter = new Adapter(false, false, apps);
            mRecyclerView.setAdapter(adapter);
            new GravitySnapHelper(Gravity.TOP, false, new GravitySnapHelper.SnapListener() {
                @Override
                public void onSnap(int position) {
                    Log.d("Snapped", position + "");
                }
            }).attachToRecyclerView(mRecyclerView);
        }
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("Agri", R.drawable.baimg, 4.6f));
        apps.add(new App("Siafarm", R.drawable.bgimg, 4.8f));
        apps.add(new App("Agri", R.drawable.bgimggg, 4.5f));
        apps.add(new App("Siafarm", R.drawable.brimgg, 4.2f));
        apps.add(new App("Agri", R.drawable.baimg, 4.6f));
        return apps;
    }

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        public void run() {
            int position = viewPager.getCurrentItem();
            if (position >= 3) {
                position = 0;
            } else {
                position = position + 1;
            }
            if (position < layoutsCount) {
                viewPager.setCurrentItem(position, true);
                handler.postDelayed(runnable, 20000);
            } else {
            }
        }
    };


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (handler != null) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 20000);
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.help_guide_slides_container, container, false);
            switch (position) {
                case 0:
                    view.setBackgroundResource(R.drawable.baimg);
                    break;
                case 1:
                    view.setBackgroundResource(R.drawable.bgimg);
                    break;
                case 2:
                    view.setBackgroundResource(R.drawable.bgimggg);
                    break;
                case 3:
                    view.setBackgroundResource(R.drawable.brimgg);
                    break;

            }
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layoutsCount;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
