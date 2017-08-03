package com.you.shan;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by syou on 2017/7/29.
 */
public class Student {

    public Student(int id,String name,Date date){
        this.id=id;
        this.name=name;
        this.date=date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int id;
    private String name;  // @JSONField(serialize =false)
    @JSONField(format ="yyyy-MM-dd HH:mm")
    private Date date;

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }



}
