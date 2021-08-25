package com.example.myapplication.model;

public class BaseModel {
    private String subject;
    private String date;
    private String description;

    public BaseModel(String subject, String date, String description) {
        this.subject = subject;
        this.date = date;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}
