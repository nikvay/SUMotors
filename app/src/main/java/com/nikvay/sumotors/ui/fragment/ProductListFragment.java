package com.nikvay.sumotors.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikvay.sumotors.R;

public class ProductListFragment   extends Fragment {

    Context mContext;

    public ProductListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        mContext = getActivity();

        find_All_IDs(view);

        event();

        return view;

    }//========== End onCreate () ==============

    private void find_All_IDs(View view) {
//        recycler_view_home = view.findViewById(R.id.recycler_view_home);


    }


    private void event() {


    }

}
