package com.yous.learningtwo.host;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/9/3.
 */
public class Demo4 {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();

        list.add(new Student(1, "hahahsasasssas"));
        list.add(new Student(2, "hahahaaa"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1, "hahahsasasssas"));
        list2.add(new Student(2, "hahahaaa"));
        list2.add(new Student(4, "hahahaa"));

        list2.forEach(x->{
            list.stream().filter(y->y.getId()==x.getId());
        });



    //去除list2中与list 不匹配的
        Optional.ofNullable(list).ifPresent(lt->{
            list2.removeIf(l2-> lt.stream().noneMatch(lt1->Objects.equals(lt1.getId(),l2.getId())));
        });

        System.out.println(list2.size());
     /*  List<Integer> ids= Optional.ofNullable(list).map(t->t.stream().map(Student::getId).collect(Collectors.toList()))
              .map(idss::addAll)
              .orElse(null);*/

       /* List<Man> mans=new ArrayList<>();

        mans.add(new Man(1L,"hiehei"));
        mans.add(new Man(2L,"hiehei"));
        mans.add(new Man(4L,"sas"));

        list.forEach(s->{
            Man man=mans.stream().filter(x->x.getId().equals(s.getId())).findAny().orElse(null);
            if(man!=null){
                System.out.println(man.getName());
            }

        });*/

       //Integer a=new Integer(5);
       /* Long b=new Long(5);
        long c=5;
        boolean f=b.longValue()==a.intValue();
        */
        //System.out.println(a.equals(5));
/*
        Student student=new Student();
        String h="%s hhahaha";
        h=h.replace("%s",student.getName());
        System.out.println(h);*/

    }


}
