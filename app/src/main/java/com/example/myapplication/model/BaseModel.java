package com.example.myapplication.model;

import java.io.Serializable;

public class BaseModel implements Serializable {
    private String subject;
    private String date;
    private String description;
//    private boolean isChecked = false;

    public BaseModel(String subject, String date, String description) {
        this.subject = subject;
        this.date = date;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public boolean isChecked() {
//        return isChecked;
//    }
//
//    public void setChecked(boolean checked) {
//        isChecked = checked;
//    }
}
