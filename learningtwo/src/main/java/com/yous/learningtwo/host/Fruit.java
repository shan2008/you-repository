package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/9/9.
 */
public enum Fruit {
    APPLE(1,"苹果"),
    oranage(2,"梨子"),
    brnana(3,"香蕉");

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

    private   int value;
    private  String desc;

    Fruit(int value,String desc){
        this.value=value;
        this.desc=desc;
    }

}
