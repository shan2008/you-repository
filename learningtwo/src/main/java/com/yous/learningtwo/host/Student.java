package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/7/5.
 */
public class Student {
    public  Student(){};

    public Student(Integer id,String name){
        this.id=id;
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Integer id;
    private String name;

}
