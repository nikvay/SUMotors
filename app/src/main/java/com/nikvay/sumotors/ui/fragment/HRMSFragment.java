package com.nikvay.sumotors.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.activity.HRMSTypeActivity;
import com.nikvay.sumotors.ui.adapter.HRMSAdapter;
import com.nikvay.sumotors.ui.module.HRMSModule;

import java.util.ArrayList;

public class HRMSFragment extends Fragment {

    Context mContext;

    RecyclerView recycler_view_hrms;
    ArrayList<HRMSModule> hrmsModuleArrayList = new ArrayList<>();
    HRMSAdapter hrmsAdapter;


    public HRMSFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hrms, container, false);
        mContext = getActivity();

        find_All_IDs(view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        recycler_view_hrms.setLayoutManager(gridLayoutManager);
        recycler_view_hrms.setHasFixedSize(true);

        hrmsDashboard();

        return view;

    }//========== End onCreate () ==============

    private void find_All_IDs(View view) {
        recycler_view_hrms = view.findViewById(R.id.recycler_view_hrms);

    }

    private void hrmsDashboard() {
        //Set data to module
        hrmsModuleArrayList.add(new HRMSModule("1", R.drawable.ic_vector_hrms_employee, "Employee"));

        hrmsAdapter = new HRMSAdapter(mContext, hrmsModuleArrayList);
        recycler_view_hrms.setAdapter(hrmsAdapter);
        hrmsAdapter.notifyDataSetChanged();

        adapterOnClick();
    }

    private void adapterOnClick() {
        hrmsAdapter.setOnItemClickListener(new HRMSAdapter.OnItemClickListener() {
            @Override
            public void onAdapterClick(HRMSModule hrmsModule, int position) {
                String id = hrmsModule.getId();
                Intent intent;
                switch (id) {
                    case "1":
                        intent = new Intent(mContext, HRMSTypeActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
