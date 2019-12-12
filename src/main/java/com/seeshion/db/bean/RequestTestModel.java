package com.seeshion.db.bean;

import org.springframework.stereotype.Component;

import java.text.DateFormat;


public class RequestTestModel {
    private String data;

    private DateFormat datetime;

    private String info;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DateFormat getDatetime() {
        return datetime;
    }

    public void setDatetime(DateFormat datetime) {
        this.datetime = datetime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
