package com.nikvay.sumotors.ui.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nikvay.sumotors.R;
import com.nikvay.sumotors.network.ApiClient;
import com.nikvay.sumotors.network.ApiInterface;
import com.nikvay.sumotors.ui.adapter.HRMSEmpDeptAdapter;
import com.nikvay.sumotors.ui.module.DesignationListModule;
import com.nikvay.sumotors.ui.module.HRMSEmpDeptModule;
import com.nikvay.sumotors.ui.module.SuccessModule;
import com.nikvay.sumotors.utils.NetworkUtils;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HRMSTypeActivity extends AppCompatActivity {

    ImageView iv_back,iv_empty_list;
    Spinner spinner_emp_dept;
    String item;

    //========= Designation list module ===========
    ArrayList<DesignationListModule> designationListModuleArrayList = new ArrayList<>();
    ArrayList<String> selectDesignationList = new ArrayList<>();
    String designationId;

    RecyclerView recycler_view_hrms_emp_dept;
    ArrayList<HRMSEmpDeptModule> hrmsEmpDeptModuleArrayList = new ArrayList<>();
    HRMSEmpDeptAdapter hrmsEmpDeptAdapter;

    //======Interface Declaration=========
    String TAG = getClass().getSimpleName();
    ApiInterface apiInterface;
    ProgressDialog pd;
    String token, isSelectUser;
    SharedPreferences sharedpreferences;
    public static String MyPREFERENCES = "SU Motors";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hrmstype);


        find_All_IDs();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        isSelectUser = sharedpreferences.getString(SharedPreference.IS_SELECT_USER, "");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 3, GridLayoutManager.VERTICAL, false);
        recycler_view_hrms_emp_dept.setLayoutManager(linearLayoutManager);
        recycler_view_hrms_emp_dept.setHasFixedSize(true);

        if (NetworkUtils.isNetworkAvailable(this)) {
            designationList();
        } else {
            NetworkUtils.isNetworkNotAvailable(this);
        }

        events();
    }


    private void find_All_IDs() {
        iv_back = findViewById(R.id.iv_back);
        spinner_emp_dept = findViewById(R.id.spinner_emp_dept);
        recycler_view_hrms_emp_dept = findViewById(R.id.recycler_view_hrms_emp_dept);
        iv_empty_list = findViewById(R.id.iv_empty_list);
    }

    private void events() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    private void designationList() {
        Call<SuccessModule> call=apiInterface.designationListCall();

        call.enqueue(new Callback<SuccessModule>() {
            @Override
            public void onResponse(@NonNull Call<SuccessModule> call, @NonNull Response<SuccessModule> response) {
                String str_response = new Gson().toJson(response.body());
                Log.e("" + TAG, "Response >>>>" + str_response);

                try {
                    if (response.isSuccessful()) {

                        SuccessModule classListModule = response.body();

                        if (classListModule != null) {
                            String message = classListModule.getMsg();
                            String code = classListModule.getError_code();

                            if (code.equalsIgnoreCase("1")) {
                                designationListModuleArrayList = classListModule.getDesignationListModuleArrayList();

                                for (DesignationListModule classListModuleArray : designationListModuleArrayList) {
                                    selectDesignationList.add(classListModuleArray.getDesignation_name());
                                }
                                spinner();

                            } else {
                                Toasty.warning(HRMSTypeActivity.this, "Not Response !!", Toast.LENGTH_SHORT, true).show();
                            }
                        }

                    } else {
                        Toasty.warning(HRMSTypeActivity.this, "Response Null !!", Toast.LENGTH_SHORT, true).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SuccessModule> call, @NonNull Throwable t) {
                Toasty.error(HRMSTypeActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT, true).show();
            }
        });

    }

    private void spinner() {
        ArrayAdapter bb = new ArrayAdapter(HRMSTypeActivity.this, android.R.layout.simple_spinner_item, selectDesignationList);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_emp_dept.setAdapter(bb);
        bb.notifyDataSetChanged();

        spinner_emp_dept.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString();
                String s = spinner_emp_dept.getSelectedItem().toString();

                try {
                    int selectId = Integer.parseInt(designationListModuleArrayList.get(position).getId());
//                    classId = String.valueOf(clsId - 1);
                    designationId = String.valueOf(selectId);

                    if (NetworkUtils.isNetworkAvailable(HRMSTypeActivity.this)) {
                        designationListClick(designationId);
                    } else {
                        NetworkUtils.isNetworkNotAvailable(HRMSTypeActivity.this);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void designationListClick(String designationId) {
        Call<SuccessModule> call = apiInterface.empListCall(designationId);

        call.enqueue(new Callback<SuccessModule>() {
            @Override
            public void onResponse(Call<SuccessModule> call, Response<SuccessModule> response) {
                String str_response = new Gson().toJson(response.body());
                Log.e("" + TAG, "Response >>>>" + str_response);

                try {
                    if (response.isSuccessful()) {

                        SuccessModule classListModule = response.body();

                        String message = classListModule.getMsg();
                        String code = classListModule.getError_code();

                        if (code.equalsIgnoreCase("1")) {
                            hrmsEmpDeptModuleArrayList = classListModule.getHrmsEmpDeptModuleArrayList();

                            hrmsEmpDeptAdapter = new HRMSEmpDeptAdapter(HRMSTypeActivity.this, hrmsEmpDeptModuleArrayList);
                            recycler_view_hrms_emp_dept.setAdapter(hrmsEmpDeptAdapter);
                            hrmsEmpDeptAdapter.notifyDataSetChanged();

                            if (hrmsEmpDeptModuleArrayList.size() != 0) {
                                recycler_view_hrms_emp_dept.setVisibility(View.VISIBLE);
                                iv_empty_list.setVisibility(View.GONE);
                            } else {
                                recycler_view_hrms_emp_dept.setVisibility(View.GONE);
                                iv_empty_list.setVisibility(View.VISIBLE);
                            }

                        } else {
                            Toasty.warning(HRMSTypeActivity.this, "Not Response !!", Toast.LENGTH_SHORT, true).show();
                        }

                    } else {
                        Toasty.warning(HRMSTypeActivity.this, "Response Null !!", Toast.LENGTH_SHORT, true).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SuccessModule> call, Throwable t) {
                Toasty.error(HRMSTypeActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT, true).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.trans_right_in, R.anim.trans_right_out);
        finish();
    }
}
