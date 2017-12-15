package com.siafarm.homeactivity;

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
 * Created by loganathan_k on 12/10/2017.
 */

public class ContactFragment extends Fragment {

    Modern_agri_adapter adapter;

    public ContactFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contact_layout, container, false);


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
