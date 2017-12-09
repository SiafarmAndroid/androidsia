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
import com.siafarm.homefragment.adapter.Adapter;
import com.siafarm.homefragment.adapter.SnapAdapter;
import com.siafarm.homefragment.model.App;
import com.siafarm.homefragment.model.Snap;
import com.siafarm.homefragment.utils.AutoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    public static final String ORIENTATION = "orientation";
    private AutoScrollViewPager viewPager;
    private int layoutsCount = 3;
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
        mHorizontal = savedInstanceState == null || savedInstanceState.getBoolean(ORIENTATION);
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
        List<App> modernapps = getModernApps();
        SnapAdapter snapAdapter = new SnapAdapter(getActivity());
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER, getResources().getString(R.string.news_updated), apps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.modern_agri), modernapps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.vegetable_farming), modernapps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.products), modernapps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.services), modernapps));
            snapAdapter.addSnap(new Snap(Gravity.START, getResources().getString(R.string.gallery), modernapps));
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
        apps.add(new App( R.drawable.news1));
        apps.add(new App( R.drawable.news2));
        apps.add(new App( R.drawable.news3));
        return apps;
    }
    private List<App> getModernApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App( R.drawable.vegsia1));
        apps.add(new App( R.drawable.vegsia3 ));
        apps.add(new App( R.drawable.vegsia3 ));
        apps.add(new App( R.drawable.vegsia4 ));
        apps.add(new App( R.drawable.vegsia5 ));
        apps.add(new App( R.drawable.vegsia6 ));
        apps.add(new App( R.drawable.vegsia7 ));
        apps.add(new App( R.drawable.vegsia8 ));
        apps.add(new App( R.drawable.vegsia9 ));
        apps.add(new App( R.drawable.vegsia10 ));
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
            }
        }
    };


  /*  private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }*/

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

        MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = null;
            if (layoutInflater != null)
                view = layoutInflater.inflate(R.layout.help_guide_slides_container, container, false);
            switch (position) {
                case 0:
                    if (view != null) view.setBackgroundResource(R.drawable.banner_new1);
                    break;
                case 1:
                    if (view != null) view.setBackgroundResource(R.drawable.banner_new2);
                    break;
                case 2:
                    if (view != null) view.setBackgroundResource(R.drawable.banner_new3);
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
