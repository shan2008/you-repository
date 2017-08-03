package com.you.shan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by syou on 2017/7/29.
 */

@RestController
public class HelloController {

    @RequestMapping("/helloworld")
   public Student hello(){
        return new Student(1,"shanyou",new Date());
    }

}
