package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/7/14.
 */
public interface Formula {
        double calculate(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
    }
}
