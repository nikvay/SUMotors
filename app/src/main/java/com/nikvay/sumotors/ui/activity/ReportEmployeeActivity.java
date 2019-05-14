package com.nikvay.sumotors.ui.activity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nikvay.sumotors.R;
import com.nikvay.sumotors.network.ApiClient;
import com.nikvay.sumotors.network.ApiInterface;
import com.nikvay.sumotors.ui.module.ReportModule;
import com.nikvay.sumotors.ui.module.SuccessModule;
import com.nikvay.sumotors.utils.NetworkUtils;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import au.com.bytecode.opencsv.CSVWriter;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportEmployeeActivity extends AppCompatActivity {

    EditText edt_given_date, edt_submit_date;
    ImageView iv_back;
    Button btn_download_emp_report;

    //======Interface Declaration=========
    String TAG = getClass().getSimpleName();
    ApiInterface apiInterface;
    ProgressDialog pd;
    String token, isSelectUser;
    SharedPreferences sharedpreferences;
    public static String MyPREFERENCES = "SU Motors";

    ArrayList<ReportModule> reportModuleArrayList = new ArrayList<>();

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_employee);

        find_All_IDs();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        isSelectUser = sharedpreferences.getString(SharedPreference.IS_SELECT_USER, "");


        String date = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        edt_given_date.setText(date);
        edt_submit_date.setText(date);

        events();
    }

    private void find_All_IDs() {
        iv_back = findViewById(R.id.iv_back);
        edt_given_date = findViewById(R.id.edt_given_date);
        edt_submit_date = findViewById(R.id.edt_submit_date);
        btn_download_emp_report = findViewById(R.id.btn_download_emp_report);
    }


    private void events() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        edt_given_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ReportEmployeeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        CharSequence strDate = null;
                        Time chosenDate = new Time();
                        chosenDate.set(day, month, year);

                        long dateAttendance = chosenDate.toMillis(true);
                        strDate = DateFormat.format("dd-MM-yyyy", dateAttendance);

                        edt_given_date.setText(strDate);

//                        edt_submit_date.setText(day + "-" + (month + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        edt_submit_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(ReportEmployeeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        CharSequence strDate = null;
                        Time chosenDate = new Time();
                        chosenDate.set(day, month, year);

                        long dateAttendance = chosenDate.toMillis(true);
                        strDate = DateFormat.format("dd-MM-yyyy", dateAttendance);

                        edt_submit_date.setText(strDate);

//                        edt_submit_date.setText(day + "-" + (month + 1) + "-" + year);

                    }
                }, year, month, day);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        btn_download_emp_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sDate = edt_given_date.getText().toString();
                String eDate = edt_submit_date.getText().toString();

                if (NetworkUtils.isNetworkAvailable(ReportEmployeeActivity.this)) {
                    reportList(sDate, eDate);
                } else {
                    NetworkUtils.isNetworkNotAvailable(ReportEmployeeActivity.this);
                }
            }
        });
    }

    private void reportList(String sDate, String eDate) {
        pd = new ProgressDialog(this);
        pd.setMessage("Loading Please Wait...");
        pd.setCancelable(false);
        pd.show();

        Call<SuccessModule> call = apiInterface.reportListCall(sDate, eDate);

        call.enqueue(new Callback<SuccessModule>() {
            @Override
            public void onResponse(@NonNull Call<SuccessModule> call, @NonNull Response<SuccessModule> response) {
                pd.dismiss();
                String str_response = new Gson().toJson(response.body());
                Log.e("" + TAG, "Response >>>>" + str_response);

                try {
                    if (response.isSuccessful()) {
                        SuccessModule loginModule = response.body();

                        String message = null, errorCode = null;
                        if (loginModule != null) {
                            message = loginModule.getMsg();
                            errorCode = loginModule.getError_code();

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                            final String currentDateTime = sdf.format(new Date());

                            if (errorCode.equalsIgnoreCase("1")) {

                                reportModuleArrayList = loginModule.getReportModuleArrayList();

                                String str_path = Environment.getExternalStorageDirectory().toString();
                                File csvFile = new File(str_path, "Emp_report_" + currentDateTime + ".xls");

                                try {
                                    csvFile.createNewFile();
                                    CSVWriter csvWrite = new CSVWriter(new FileWriter(csvFile));

                                    String heading[] = {"Id", "Name", "Employee Id", "Address", "Email", "Contact", "DOB",
                                            "Designation", "Join Date", "Requirement Date", "Gender", "Country", "State",
                                            "City", "Pin Code", "Blood", "Emergency Contact", "Married Status", "Create Date",
                                            "Update Date", "Bio-System Code", "Salary", "Emp sic no", "Pf No", "Status"};

                                    csvWrite.writeNext(heading);
                                    for (int i = 0; i < reportModuleArrayList.size(); i++) {
                                        ReportModule model = reportModuleArrayList.get(i); // You can also use JsonObject from Json array.
//                                        String arrStr[] = {String.valueOf(model.getEmp_blood()), String.valueOf(model.getEmp_dob()), model.getEmp_city()};
                                        String arrStr[] = {model.getEmp_id(), model.getEmp_name(), model.getEmp_employeid(), model.getEmp_address(),
                                                model.getEmp_email(), model.getEmp_contact(), model.getEmp_dob(), model.getEmp_designation(), model.getEmp_joindate(),
                                                model.getEmp_recrumentdate(), model.getEmp_gender(), model.getEmp_country(), model.getEmp_state(), model.getEmp_city(),
                                                model.getEmp_pincode(), model.getEmp_blood(), model.getEmp_emergencycontact(), model.getEmp_marriedstatus(),
                                                model.getEmp_creatdate(), model.getEmp_updatedate(), model.getEmp_biosystemcode(), model.getEmp_salary(),
                                                model.getEmp_esicno(), model.getEmp_epfno(), model.getEmp_state()};
                                        csvWrite.writeNext(arrStr);
                                    }
                                    Toast.makeText(ReportEmployeeActivity.this, "Start downloading...", Toast.LENGTH_SHORT).show();
                                    csvWrite.close();
                                } catch (Exception sqlEx) {
                                    Log.e(TAG, sqlEx.getMessage(), sqlEx);
                                }

//                                Toasty.success(ReportEmployeeActivity.this, "Success List !!", Toast.LENGTH_SHORT, true).show();

                             /*   DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                                Uri uri = Uri.parse(finalImageUrl);
                                DownloadManager.Request request = new DownloadManager.Request(uri);
                                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, currentDateTime);
                                Toast.makeText(ReportEmployeeActivity.this, "Start downloading...", Toast.LENGTH_SHORT).show();
                                Long reference = downloadManager.enqueue(request);*/
                            }
                        }
                    } else {
                        Toasty.warning(ReportEmployeeActivity.this, "Service Unavailable !!", Toast.LENGTH_SHORT, true).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<SuccessModule> call, Throwable t) {
                pd.dismiss();
                Toasty.error(ReportEmployeeActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT, true).show();
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
