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

public class ModernAgriFragment extends Fragment {

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
        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setHasFixedSize(true);

        List<modern_agri_data> apps = new ArrayList<>();
        apps.add(new modern_agri_data( R.drawable.vegsia1));
        apps.add(new modern_agri_data( R.drawable.vegsia2));
        apps.add(new modern_agri_data( R.drawable.vegsia3));
        apps.add(new modern_agri_data( R.drawable.vegsia4));
        apps.add(new modern_agri_data( R.drawable.vegsia5));
        apps.add(new modern_agri_data( R.drawable.vegsia6));
        apps.add(new modern_agri_data( R.drawable.vegsia7));
        apps.add(new modern_agri_data( R.drawable.vegsia8));
        apps.add(new modern_agri_data( R.drawable.vegsia9));
        apps.add(new modern_agri_data( R.drawable.vegsia10));
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
