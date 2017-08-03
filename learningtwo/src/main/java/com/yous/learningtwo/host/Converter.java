package com.yous.learningtwo.host;

/**
 * Created by syou on 2017/7/14.
 */
@FunctionalInterface
public interface Converter<F,T> {
    T convert(F from);
}
