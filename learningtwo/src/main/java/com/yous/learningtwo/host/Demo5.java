package com.yous.learningtwo.host;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/9/10.
 */
public class Demo5 {

    public static void main(String[] args) {


        try {
            division();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


/*
        List<Order> list=new ArrayList<>();
        list.add(new Order(1,new Timestamp(1020000000L),"你是我的笑苹果，向导"));
        list.add(new Order(2,new Timestamp(1050000000L),"萌萌哒，向导"));
        list.add(new Order(3,new Timestamp(1090000000L),"hahahah，向导"));
        list.add(new Order(4,new Timestamp(1030000000L),""));
        list.add(new Order(5,new Timestamp(5100000000L),""));
        list.add(new Order(6, new Timestamp(1000000000L), "我不爱你，向导"));
        list.add(new Order(7, new Timestamp(5200000000L), "我不爱你，向导"));
        list.add(new Order(8, new Timestamp(6300000000L), "你是我的笑苹果，向导"));
*/


        // long a=Optional.ofNullable(list).map(x->x.stream().filter(y->y.getContent()!=null &&y.getContent()!="").count()).orElse(0L);
        //System.out.println(a);
        // List<Order> list2=new ArrayList<>();
        // list2.addAll(list.stream().sorted((x1, x2) -> x1.getBookingTime().compareTo(x2.getBookingTime())).limit(2).collect(Collectors.toList()));

        // list=list.stream().sorted((x1,x2)->x1.getBookingTime().compareTo(x2.getBookingTime())).limit(2).collect(Collectors.toList());

       /*boolean f= list.stream().sorted((x1,x2)->x1.getBookingTime().compareTo(x2.getBookingTime())).limit(2)
                .anyMatch(x->x!=null&&x.getContent().contains("苹果")&&x.getContent().contains("向导"));
        System.out.println(f);*/

        // String q=null;
        //q.contains("aaa");

//list=null;
/*        int speechGroupCount= Optional.ofNullable(list)
                .map(messages -> messages.stream().filter(m -> m.getContent() != null && m.getContent() != "")
                        .map(p -> p.getContent()).distinct().collect(Collectors.toList()).size()).orElse(0);
        System.out.println(speechGroupCount);*/
/*

        Order order = new Order(1, new Timestamp(1020000000L), "你是我的笑苹果，向导");
        order=null;
        String str = Optional.ofNullable(order).map(x -> x.getContent()).orElse("木有");
        System.out.println(str);
*/


        // System.out.println(new Timestamp(System.currentTimeMillis()));
        // System.out.println(System.currentTimeMillis());
    }

    private static void division(){
        int a=0;
        int b=1;
        System.out.println(b/a);
    }
}
