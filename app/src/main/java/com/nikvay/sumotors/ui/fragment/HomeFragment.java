package com.nikvay.sumotors.ui.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.HomeActivity;
import com.nikvay.sumotors.ui.adapter.HomeAdapter;
import com.nikvay.sumotors.ui.module.HomeModule;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    Context mContext;


    RecyclerView recycler_view_home;
    ArrayList<HomeModule> homeModuleArrayList = new ArrayList<>();
    HomeAdapter homeAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mContext = getActivity();

        find_All_IDs(view);


//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        recycler_view_home.setLayoutManager(gridLayoutManager);
        recycler_view_home.setHasFixedSize(true);

        dashboard();


        event();

        return view;

    }//========== End onCreate () ==============

    private void dashboard() {
        //Set data to module
        homeModuleArrayList.add(new HomeModule("1", R.drawable.ic_vector_h_hrms, "HRMS"));
        homeModuleArrayList.add(new HomeModule("2", R.drawable.ic_vector_h_reports, "Inventory"));
        homeModuleArrayList.add(new HomeModule("3", R.drawable.ic_vector_h_sales, "Sales"));
        homeModuleArrayList.add(new HomeModule("4", R.drawable.ic_vector_h_purchase, "Purchase"));
        homeModuleArrayList.add(new HomeModule("5", R.drawable.ic_vector_h_product, "Product"));
        homeModuleArrayList.add(new HomeModule("6", R.drawable.ic_vector_h_customer, "Customer"));
        homeModuleArrayList.add(new HomeModule("7", R.drawable.ic_vector_h_reports, "Report"));

        homeAdapter = new HomeAdapter(mContext, homeModuleArrayList);
        recycler_view_home.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

        adapterOnClick();
    }

    private void adapterOnClick() {
        homeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onAdapterClick(HomeModule homeModule, int position) {
                String id = homeModule.getId();

                switch (id) {
                    case "1":
                        ((HomeActivity) mContext).replaceFragment(new HRMSFragment());
                        break;
                    case "2":
                        ((HomeActivity) mContext).replaceFragment(new ProductListFragment());
                        break;
                    case "3":
                        ((HomeActivity) mContext).replaceFragment(new ProductListFragment());
                        break;
                    case "4":
                        ((HomeActivity) mContext).replaceFragment(new ProductListFragment());
                        break;
                    case "5":
                        ((HomeActivity) mContext).replaceFragment(new ProductListFragment());
                        break;
                    case "6":
                        ((HomeActivity) mContext).replaceFragment(new ProductListFragment());
                        break;
                    case "7":
                        ((HomeActivity) mContext).replaceFragment(new ReportsFragment());
                        break;
                }
            }
        });
    }

    private void find_All_IDs(View view) {
        recycler_view_home = view.findViewById(R.id.recycler_view_home);


    }


    private void event() {


    }

}
