package com.nikvay.sumotors.ui.module;

import java.util.ArrayList;

public class StudentPAListModule {
    public String date="";
    public String name="";
    public String subject="";
    public String description="";


    public static ArrayList<StudentPAListModule> date_collection_arr;

    public StudentPAListModule(String date, String name, String subject, String description){

        this.date=date;
        this.name=name;
        this.subject=subject;
        this.description= description;

    }
  /*  private String student_id;
    private String student_name;
    private String attendance_status;
    private String date;
    private String gender;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public void setAttendance_status(String attendance_status) {
        this.attendance_status = attendance_status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }*/
}

