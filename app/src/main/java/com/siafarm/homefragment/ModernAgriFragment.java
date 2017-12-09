package com.siafarm.homefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.siafarm.R;
import com.siafarm.homefragment.adapter.Modern_agri_adapter;
import com.siafarm.homefragment.model.modern_agri_data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhivya_v on 12/1/2017.
 */

public class ModernAgriFragment extends Fragment {

    private RecyclerView mRecyclerView;
    Modern_agri_adapter adapter;

    public ModernAgriFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.modern_agri_layout, container, false);
        mRecyclerView = view. findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        List<modern_agri_data> apps = new ArrayList<>();
        apps.add(new modern_agri_data("Agri", R.drawable.baimg, 4.6f));
        apps.add(new modern_agri_data("Siafarm", R.drawable.bgimg, 4.8f));
        apps.add(new modern_agri_data("Agri", R.drawable.bgimggg, 4.5f));
        apps.add(new modern_agri_data("Siafarm", R.drawable.brimgg, 4.2f));
        apps.add(new modern_agri_data("Agri", R.drawable.baimg, 4.6f));
        adapter = new Modern_agri_adapter(apps,getContext());
        mRecyclerView.setAdapter(adapter);

        return view;

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
