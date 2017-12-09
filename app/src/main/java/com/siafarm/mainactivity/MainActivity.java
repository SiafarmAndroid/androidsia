package com.siafarm.mainactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;

import com.siafarm.R;
import com.siafarm.gravityhelper.GravitySnapHelper;
import com.siafarm.mainactivity.adapter.Adapter;
import com.siafarm.mainactivity.adapter.SnapAdapter;
import com.siafarm.mainactivity.model.App;
import com.siafarm.mainactivity.model.Snap;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity  {

    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        mHorizontal = savedInstanceState == null || savedInstanceState.getBoolean(ORIENTATION);

        setupAdapter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setupAdapter() {
        List<App> apps = getApps();

        SnapAdapter snapAdapter = new SnapAdapter(this);
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER, "News Updates", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "MORDEN AGRI", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "VEGETABLE FARMING", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "PRODUCTS", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "SERVICES", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "GALLERY", apps));
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

}
