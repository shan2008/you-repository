package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/9/12.
 */
public enum Person {

    man(1,"男"),
    woman(2,"女");

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private int value;
    private String desc;
    Person(int value, String desc ){
        this.value=value;
        this.desc=desc;
    }

}
