package com.shan;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by syou on 2017/8/3.
 */
public class Student {

    private int id;
    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    public int getId() {
        return id;
    }

    public  Student(){};

    public  Student(int id,String name,Date date){
        this.id=id;
        this.name=name;
        this.date=date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
