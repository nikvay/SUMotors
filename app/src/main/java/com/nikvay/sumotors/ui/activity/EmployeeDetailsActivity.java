package com.nikvay.sumotors.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nikvay.sumotors.R;
import com.nikvay.sumotors.ui.module.HRMSEmpDeptModule;

public class EmployeeDetailsActivity extends AppCompatActivity {

    ImageView iv_back;
    Button btn_emp_view_attendance;
    TextView tv_emp_details_name, tv_emp_details_designation, tv_emp_details_id, tv_emp_details_gender, tv_emp_details_mStatus,
            tv_emp_details_dob, tv_emp_details_email, tv_emp_details_address, tv_emp_details_contact, tv_emp_details_join_date,
            tv_emp_details_pin_code, tv_emp_details_blood, tv_emp_details_bio_code, tv_emp_details_salary, tv_emp_details_emp_sic_no,
            tv_emp_details_pf_no, tv_emp_details_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);


        find_All_IDs();

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {

                //"Id", "Name", "Employee Id", "Address", "Email", "Contact", "DOB",
                // "Designation", "Join Date", "Requirement Date", "Gender", "Country", "State",
                // "City", "Pin Code", "Blood", "Emergency Contact", "Married Status", "Create Date",
                // "Update Date", "Bio-System Code", "Salary", "Emp sic no", "Pf No", "Status"

                HRMSEmpDeptModule hrmsEmpDeptModule = bundle.getParcelable("EMP_MODULE");
                assert hrmsEmpDeptModule != null;
                String id = hrmsEmpDeptModule.getEmp_id();
                String empName = hrmsEmpDeptModule.getEmp_name();
                String empEmployeeId = hrmsEmpDeptModule.getEmp_employeid();
                String empAddress = hrmsEmpDeptModule.getEmp_address();
                String empEmail = hrmsEmpDeptModule.getEmp_email();
                String empContact = hrmsEmpDeptModule.getEmp_contact();
                String empDob = hrmsEmpDeptModule.getEmp_dob();
                String empDesignation = hrmsEmpDeptModule.getEmp_designation();
                String empJoinDate = hrmsEmpDeptModule.getEmp_joindate();
                String empGender = hrmsEmpDeptModule.getEmp_gender();
                String empPinCode = hrmsEmpDeptModule.getEmp_pincode();
                String empBlood = hrmsEmpDeptModule.getEmp_blood();
                String empMarriedStatus = hrmsEmpDeptModule.getEmp_marriedstatus();
                String empBioSystemCode = hrmsEmpDeptModule.getEmp_biosystemcode();
                String empSalary = hrmsEmpDeptModule.getEmp_salary();
                String empEsicno = hrmsEmpDeptModule.getEmp_esicno();
                String empPfNo = hrmsEmpDeptModule.getEmp_epfno();
                String empStatus = hrmsEmpDeptModule.getEmp_status();

                tv_emp_details_name.setText(empName);
                tv_emp_details_designation.setText(empDesignation);
                tv_emp_details_id.setText("Employee ID : " + empEmployeeId);
                tv_emp_details_gender.setText("Gender : " + empGender);
                tv_emp_details_mStatus.setText("Married Status : " + empMarriedStatus);
                tv_emp_details_dob.setText("DOB : " + empDob);
                tv_emp_details_contact.setText("Contact : " + empContact);
                tv_emp_details_salary.setText("Salary : " + empSalary);
                tv_emp_details_email.setText(empEmail);
                tv_emp_details_address.setText(empAddress);
                tv_emp_details_join_date.setText(empJoinDate);
                tv_emp_details_pin_code.setText(empPinCode);
                tv_emp_details_blood.setText(empBlood);
                tv_emp_details_bio_code.setText(empBioSystemCode);
                tv_emp_details_emp_sic_no.setText(empEsicno);
                tv_emp_details_pf_no.setText(empPfNo);
                tv_emp_details_status.setText(empStatus);
            }
        }
        events();
    }

    private void find_All_IDs() {
        tv_emp_details_name = findViewById(R.id.tv_emp_details_name);
        tv_emp_details_designation = findViewById(R.id.tv_emp_details_designation);
        tv_emp_details_id = findViewById(R.id.tv_emp_details_id);
        tv_emp_details_gender = findViewById(R.id.tv_emp_details_gender);
        tv_emp_details_mStatus = findViewById(R.id.tv_emp_details_mStatus);
        tv_emp_details_dob = findViewById(R.id.tv_emp_details_dob);
        tv_emp_details_email = findViewById(R.id.tv_emp_details_email);
        tv_emp_details_address = findViewById(R.id.tv_emp_details_address);
        tv_emp_details_contact = findViewById(R.id.tv_emp_details_contact);
        tv_emp_details_join_date = findViewById(R.id.tv_emp_details_join_date);
        tv_emp_details_pin_code = findViewById(R.id.tv_emp_details_pin_code);
        tv_emp_details_blood = findViewById(R.id.tv_emp_details_blood);
        tv_emp_details_bio_code = findViewById(R.id.tv_emp_details_bio_code);
        tv_emp_details_salary = findViewById(R.id.tv_emp_details_salary);
        tv_emp_details_emp_sic_no = findViewById(R.id.tv_emp_details_emp_sic_no);
        tv_emp_details_pf_no = findViewById(R.id.tv_emp_details_pf_no);
        tv_emp_details_status = findViewById(R.id.tv_emp_details_status);

        iv_back = findViewById(R.id.iv_back);
        btn_emp_view_attendance = findViewById(R.id.btn_emp_view_attendance);
    }

    private void events() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_emp_view_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeDetailsActivity.this, EmpAttendanceActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
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

