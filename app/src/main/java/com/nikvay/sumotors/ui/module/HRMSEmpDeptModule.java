package com.nikvay.sumotors.ui.module;

import android.os.Parcel;
import android.os.Parcelable;

public class HRMSEmpDeptModule implements Parcelable {
    private String emp_name;
    private String emp_country;
    private String emp_updatedate;
    private String emp_designation;
    private String emp_gender;
    private String emp_blood;
    private String emp_creatdate;
    private String emp_esicno;
    private String emp_status;
    private String emp_joindate;
    private String emp_marriedstatus;
    private String emp_state;
    private String emp_epfno;
    private String emp_email;
    private String emp_contact;
    private String emp_biosystemcode;
    private String emp_city;
    private String emp_employeid;
    private String emp_pincode;
    private String emp_address;
    private String emp_recrumentdate;
    private String emp_dob;
    private String emp_emergencycontact;
    private String emp_salary;
    private String emp_id;

    protected HRMSEmpDeptModule(Parcel in) {
        emp_name = in.readString();
        emp_country = in.readString();
        emp_updatedate = in.readString();
        emp_designation = in.readString();
        emp_gender = in.readString();
        emp_blood = in.readString();
        emp_creatdate = in.readString();
        emp_esicno = in.readString();
        emp_status = in.readString();
        emp_joindate = in.readString();
        emp_marriedstatus = in.readString();
        emp_state = in.readString();
        emp_epfno = in.readString();
        emp_email = in.readString();
        emp_contact = in.readString();
        emp_biosystemcode = in.readString();
        emp_city = in.readString();
        emp_employeid = in.readString();
        emp_pincode = in.readString();
        emp_address = in.readString();
        emp_recrumentdate = in.readString();
        emp_dob = in.readString();
        emp_emergencycontact = in.readString();
        emp_salary = in.readString();
        emp_id = in.readString();
    }

    public static final Creator<HRMSEmpDeptModule> CREATOR = new Creator<HRMSEmpDeptModule>() {
        @Override
        public HRMSEmpDeptModule createFromParcel(Parcel in) {
            return new HRMSEmpDeptModule(in);
        }

        @Override
        public HRMSEmpDeptModule[] newArray(int size) {
            return new HRMSEmpDeptModule[size];
        }
    };

    public String getEmp_name ()
    {
        return emp_name;
    }

    public void setEmp_name (String emp_name)
    {
        this.emp_name = emp_name;
    }

    public String getEmp_country ()
    {
        return emp_country;
    }

    public void setEmp_country (String emp_country)
    {
        this.emp_country = emp_country;
    }

    public String getEmp_updatedate ()
    {
        return emp_updatedate;
    }

    public void setEmp_updatedate (String emp_updatedate)
    {
        this.emp_updatedate = emp_updatedate;
    }

    public String getEmp_designation ()
    {
        return emp_designation;
    }

    public void setEmp_designation (String emp_designation)
    {
        this.emp_designation = emp_designation;
    }

    public String getEmp_gender ()
    {
        return emp_gender;
    }

    public void setEmp_gender (String emp_gender)
    {
        this.emp_gender = emp_gender;
    }

    public String getEmp_blood ()
    {
        return emp_blood;
    }

    public void setEmp_blood (String emp_blood)
    {
        this.emp_blood = emp_blood;
    }

    public String getEmp_creatdate ()
    {
        return emp_creatdate;
    }

    public void setEmp_creatdate (String emp_creatdate)
    {
        this.emp_creatdate = emp_creatdate;
    }

    public String getEmp_esicno ()
    {
        return emp_esicno;
    }

    public void setEmp_esicno (String emp_esicno)
    {
        this.emp_esicno = emp_esicno;
    }

    public String getEmp_status ()
    {
        return emp_status;
    }

    public void setEmp_status (String emp_status)
    {
        this.emp_status = emp_status;
    }

    public String getEmp_joindate ()
    {
        return emp_joindate;
    }

    public void setEmp_joindate (String emp_joindate)
    {
        this.emp_joindate = emp_joindate;
    }

    public String getEmp_marriedstatus ()
    {
        return emp_marriedstatus;
    }

    public void setEmp_marriedstatus (String emp_marriedstatus)
    {
        this.emp_marriedstatus = emp_marriedstatus;
    }

    public String getEmp_state ()
    {
        return emp_state;
    }

    public void setEmp_state (String emp_state)
    {
        this.emp_state = emp_state;
    }

    public String getEmp_epfno ()
    {
        return emp_epfno;
    }

    public void setEmp_epfno (String emp_epfno)
    {
        this.emp_epfno = emp_epfno;
    }

    public String getEmp_email ()
    {
        return emp_email;
    }

    public void setEmp_email (String emp_email)
    {
        this.emp_email = emp_email;
    }

    public String getEmp_contact ()
    {
        return emp_contact;
    }

    public void setEmp_contact (String emp_contact)
    {
        this.emp_contact = emp_contact;
    }

    public String getEmp_biosystemcode ()
    {
        return emp_biosystemcode;
    }

    public void setEmp_biosystemcode (String emp_biosystemcode)
    {
        this.emp_biosystemcode = emp_biosystemcode;
    }

    public String getEmp_city ()
    {
        return emp_city;
    }

    public void setEmp_city (String emp_city)
    {
        this.emp_city = emp_city;
    }

    public String getEmp_employeid ()
    {
        return emp_employeid;
    }

    public void setEmp_employeid (String emp_employeid)
    {
        this.emp_employeid = emp_employeid;
    }

    public String getEmp_pincode ()
    {
        return emp_pincode;
    }

    public void setEmp_pincode (String emp_pincode)
    {
        this.emp_pincode = emp_pincode;
    }

    public String getEmp_address ()
    {
        return emp_address;
    }

    public void setEmp_address (String emp_address)
    {
        this.emp_address = emp_address;
    }

    public String getEmp_recrumentdate ()
    {
        return emp_recrumentdate;
    }

    public void setEmp_recrumentdate (String emp_recrumentdate)
    {
        this.emp_recrumentdate = emp_recrumentdate;
    }

    public String getEmp_dob ()
    {
        return emp_dob;
    }

    public void setEmp_dob (String emp_dob)
    {
        this.emp_dob = emp_dob;
    }

    public String getEmp_emergencycontact ()
    {
        return emp_emergencycontact;
    }

    public void setEmp_emergencycontact (String emp_emergencycontact)
    {
        this.emp_emergencycontact = emp_emergencycontact;
    }

    public String getEmp_salary ()
    {
        return emp_salary;
    }

    public void setEmp_salary (String emp_salary)
    {
        this.emp_salary = emp_salary;
    }

    public String getEmp_id ()
    {
        return emp_id;
    }

    public void setEmp_id (String emp_id)
    {
        this.emp_id = emp_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(emp_name);
        dest.writeString(emp_country);
        dest.writeString(emp_updatedate);
        dest.writeString(emp_designation);
        dest.writeString(emp_gender);
        dest.writeString(emp_blood);
        dest.writeString(emp_creatdate);
        dest.writeString(emp_esicno);
        dest.writeString(emp_status);
        dest.writeString(emp_joindate);
        dest.writeString(emp_marriedstatus);
        dest.writeString(emp_state);
        dest.writeString(emp_epfno);
        dest.writeString(emp_email);
        dest.writeString(emp_contact);
        dest.writeString(emp_biosystemcode);
        dest.writeString(emp_city);
        dest.writeString(emp_employeid);
        dest.writeString(emp_pincode);
        dest.writeString(emp_address);
        dest.writeString(emp_recrumentdate);
        dest.writeString(emp_dob);
        dest.writeString(emp_emergencycontact);
        dest.writeString(emp_salary);
        dest.writeString(emp_id);
    }
}
