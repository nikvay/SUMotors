package com.nikvay.sumotors.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.activity.HRMSTypeActivity;
import com.nikvay.sumotors.ui.activity.ReportEmployeeActivity;

public class ReportsFragment  extends Fragment {

    Context mContext;
    RelativeLayout rel_emp_reports,rel_leave_reports,rel_attendance_reports,rel_salary_reports,rel_pf_tds_report;

    public ReportsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reports, container, false);
        mContext = getActivity();

        find_All_IDs(view);

        event();

        return view;

    }//========== End onCreate () ==============

    private void find_All_IDs(View view) {
        rel_emp_reports = view.findViewById(R.id.rel_emp_reports);
        rel_leave_reports = view.findViewById(R.id.rel_leave_reports);
        rel_attendance_reports = view.findViewById(R.id.rel_attendance_reports);
        rel_salary_reports = view.findViewById(R.id.rel_salary_reports);
        rel_pf_tds_report = view.findViewById(R.id.rel_pf_tds_report);
    }


    private void event() {

        rel_emp_reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(mContext, ReportEmployeeActivity.class);
                startActivity(intent);
            }
        });

    }

}
