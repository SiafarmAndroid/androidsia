package com.siafarm.mainactivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;

import com.siafarm.R;
import com.siafarm.gravityhelper.GravitySnapHelper;
import com.siafarm.mainactivity.adapter.Adapter;
import com.siafarm.mainactivity.model.App;

import java.util.ArrayList;
import java.util.List;


@SuppressLint("Registered")
public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        Adapter adapter = new Adapter(false, false, getApps());

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        new GravitySnapHelper(Gravity.TOP).attachToRecyclerView(mRecyclerView);
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
