package com.nikvay.sumotors.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.activity.EmployeeDetailsActivity;
import com.nikvay.sumotors.ui.module.HRMSEmpDeptModule;

import java.util.ArrayList;

public class HRMSEmpDeptAdapter extends RecyclerView.Adapter<HRMSEmpDeptAdapter.MyViewHolder> {
    Context mContext;
    ArrayList<HRMSEmpDeptModule> hrmsEmpDeptModuleArrayList;

    public HRMSEmpDeptAdapter(Context mContext, ArrayList<HRMSEmpDeptModule> hrmsEmpDeptModuleArrayList) {
        this.mContext = mContext;
        this.hrmsEmpDeptModuleArrayList = hrmsEmpDeptModuleArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_item_hrms_emp_dept_adapter, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final HRMSEmpDeptModule hrmsEmpDeptModule = hrmsEmpDeptModuleArrayList.get(position);

        String name = hrmsEmpDeptModule.getEmp_name();

        holder.tv_hrms_emp_dept_name.setText(name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, EmployeeDetailsActivity.class);
                Bundle b = new Bundle();
                b.putParcelable("EMP_MODULE", hrmsEmpDeptModule);
                intent.putExtras(b); //pass bundle to your intent
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hrmsEmpDeptModuleArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_hrms_emp_dept_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_hrms_emp_dept_name = itemView.findViewById(R.id.tv_hrms_emp_dept_name);
        }
    }
}
