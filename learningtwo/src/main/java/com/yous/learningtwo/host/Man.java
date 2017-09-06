package com.yous.learningtwo.host;

import com.sun.corba.se.impl.presentation.rmi.StubInvocationHandlerImpl;

/**
 * Created by syou on 2017/9/3.
 */
public class Man {

    public Man(Long id,String name){
        this.id=id;
        this.name=name;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Long id;
    String name;

}
