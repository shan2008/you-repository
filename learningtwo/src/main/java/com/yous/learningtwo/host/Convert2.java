package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/8/7.
 */
@FunctionalInterface
public interface Convert2<T,k> {
    k getStudentList(T st);
}
