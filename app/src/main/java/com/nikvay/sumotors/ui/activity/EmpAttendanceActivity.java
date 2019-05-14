package com.nikvay.sumotors.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.adapter.StudentPAListAdapter;
import com.nikvay.sumotors.ui.module.StudentPAListModule;
import com.nikvay.sumotors.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EmpAttendanceActivity extends AppCompatActivity {

    public GregorianCalendar cal_month, cal_month_copy;

    private TextView tv_month, txt_present_count_std, txt_absent_count_std;
    LinearLayout ll_prevMonth, ll_nextMonth;

    String monthName;
    GridView gridview;
    ArrayList<StudentPAListModule> studentPAListModuleArrayList = new ArrayList<>();
    private StudentPAListAdapter studentPAListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_attendance);

        find_All_IDs();

        events();


        StudentPAListModule.date_collection_arr=new ArrayList<StudentPAListModule>();
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-04-08" ,"Diwali","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-04-08" ,"Holi","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-05-08" ,"Statehood Day","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-05-08" ,"Republic Unian","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-05-09" ,"ABC","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-06-15" ,"demo","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2019-06-26" ,"weekly off","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2020-07-08" ,"Events","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2020-03-16" ,"Dasahara","Holiday","this is holiday"));
        StudentPAListModule.date_collection_arr.add( new StudentPAListModule("2020-03-09" ,"Christmas","Holiday","this is holiday"));



        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        studentPAListAdapter = new StudentPAListAdapter(this, cal_month,StudentPAListModule.date_collection_arr);


        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

        events();

        gridview.setAdapter(studentPAListAdapter);

    }


    private void find_All_IDs() {
        gridview = findViewById(R.id.gv_calendar);
        tv_month = findViewById(R.id.tv_month);
        ll_prevMonth = findViewById(R.id.ll_prevMonth);
        ll_nextMonth = findViewById(R.id.ll_nextMonth);
    }
    private void events() {
        ll_prevMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 4&&cal_month.get(GregorianCalendar.YEAR)==2019) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(EmpAttendanceActivity.this, "Available for ( 2019-2030 ) 10 Year only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setPreviousMonth();
                    refreshCalendar();
                }


            }
        });

        ll_nextMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cal_month.get(GregorianCalendar.MONTH) == 5&&cal_month.get(GregorianCalendar.YEAR)==2030) {
                    //cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
                    Toast.makeText(EmpAttendanceActivity.this, "Available for ( 2019-2030 ) 10 Year only.", Toast.LENGTH_SHORT).show();
                }
                else {
                    setNextMonth();
                    refreshCalendar();
                }
            }
        });
    }

    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1), cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1), cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH, cal_month.get(GregorianCalendar.MONTH) - 1);
        }
    }

    public void refreshCalendar() {
        studentPAListAdapter.refreshDays();
        studentPAListAdapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}