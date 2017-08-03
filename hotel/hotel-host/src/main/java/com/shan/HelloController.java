package com.shan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by syou on 2017/8/3.
 */
@RestController
public class HelloController {

    @RequestMapping("/helloworld")
    public String helloWorld(){
        return "hello world";
    }

    @RequestMapping("/json")
    public Student student(){
        Student student=new Student(1,"shan",new Date());
        return student;
    }

}
