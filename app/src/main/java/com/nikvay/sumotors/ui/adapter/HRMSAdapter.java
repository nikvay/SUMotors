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
import com.nikvay.sumotors.ui.module.HRMSModule;

import java.util.ArrayList;

public class HRMSAdapter extends RecyclerView.Adapter<HRMSAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<HRMSModule> hrmsModuleArrayList;
    private OnItemClickListener listener;

    public HRMSAdapter(Context mContext, ArrayList<HRMSModule> hrmsModuleArrayList) {
        this.mContext = mContext;
        this.hrmsModuleArrayList = hrmsModuleArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item_hrms_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final HRMSModule hrmsModule = hrmsModuleArrayList.get(position);

        String id = hrmsModule.getId();
        int image = hrmsModule.getImage();
        String name = hrmsModule.getName();

        holder.iv_hrms_image.setImageResource(image);
        holder.tv_hrms_name.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAdapterClick(hrmsModule, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hrmsModuleArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_hrms_image;
        TextView tv_hrms_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_hrms_image = itemView.findViewById(R.id.iv_hrms_image);
            tv_hrms_name = itemView.findViewById(R.id.tv_hrms_name);
        }
    }

    //=====================================================
    public interface OnItemClickListener {
        void onAdapterClick(HRMSModule hrmsModule, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
