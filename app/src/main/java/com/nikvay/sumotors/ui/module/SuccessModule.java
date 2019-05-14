package com.nikvay.sumotors.ui.module;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SuccessModule {
    private String msg;
    private String error_code;

    @SerializedName("user_details")
    private ArrayList<ReportModule> reportModuleArrayList;

    @SerializedName("designation_list")
    private ArrayList<DesignationListModule> designationListModuleArrayList;

    @SerializedName("employee_list")
    private ArrayList<HRMSEmpDeptModule> hrmsEmpDeptModuleArrayList;

    public ArrayList<HRMSEmpDeptModule> getHrmsEmpDeptModuleArrayList() {
        return hrmsEmpDeptModuleArrayList;
    }

    public void setHrmsEmpDeptModuleArrayList(ArrayList<HRMSEmpDeptModule> hrmsEmpDeptModuleArrayList) {
        this.hrmsEmpDeptModuleArrayList = hrmsEmpDeptModuleArrayList;
    }

    public ArrayList<DesignationListModule> getDesignationListModuleArrayList() {
        return designationListModuleArrayList;
    }

    public void setDesignationListModuleArrayList(ArrayList<DesignationListModule> designationListModuleArrayList) {
        this.designationListModuleArrayList = designationListModuleArrayList;
    }

    public ArrayList<ReportModule> getReportModuleArrayList() {
        return reportModuleArrayList;
    }

    public void setReportModuleArrayList(ArrayList<ReportModule> reportModuleArrayList) {
        this.reportModuleArrayList = reportModuleArrayList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}
