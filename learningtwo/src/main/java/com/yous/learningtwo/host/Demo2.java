package com.yous.learningtwo.host;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by syou on 2017/8/7.
 */
public class Demo2 {

    public static void main(String[] args) {

        long[] nums=new long[10000000];

        List lists=new ArrayList(100000);
        lists.toArray();
        Integer a=new Integer(5);
        int b=5;
        System.out.println(a==b);
       /* nums.add("y");
        nums.add("o");
        nums.add("u");
        System.out.println(nums);
        System.out.println("***********");
        System.out.println(String.join("-","you"));

        StringJoiner joiner=new StringJoiner("*");
        for(String num :nums){
            joiner.add(num);
        }

        System.out.println(joiner.toString());*/


       // Arrays.parallelSetAll(nums,index-> ThreadLocalRandom.current().nextInt(1000000));
    }
}
