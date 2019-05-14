package com.nikvay.sumotors.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.module.HomeModule;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<HomeModule> homeModuleArrayList;
    private OnItemClickListener listener;

    public HomeAdapter(Context mContext, ArrayList<HomeModule> homeModuleArrayList) {
        this.mContext = mContext;
        this.homeModuleArrayList = homeModuleArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item_home_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HomeModule homeModule = homeModuleArrayList.get(position);

        String id = homeModule.getId();
        int image = homeModule.getImage();
        String name = homeModule.getName();

        holder.iv_home_image.setImageResource(image);
        holder.tv_home_name.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAdapterClick(homeModule, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeModuleArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_home_image;
        TextView tv_home_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_home_image = itemView.findViewById(R.id.iv_home_image);
            tv_home_name = itemView.findViewById(R.id.tv_home_name);
        }
    }

    //=====================================================
    public interface OnItemClickListener {
        void onAdapterClick(HomeModule homeModule, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
