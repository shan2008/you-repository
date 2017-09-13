package com.yous.learningtwo.host;

import java.sql.Timestamp;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * Created by syou on 2017/9/12.
 */
public class Demo7 {

     public static void main(String[] args) {

  /*       LocalDate now=LocalDate.now();
         System.out.println(String.valueOf(now.minusDays(1))+ " 22:59:59");
         System.out.println(String.valueOf(now.minusDays(1))+ " 23:59:59");
         System.out.println(now.minusDays(1));
         Timestamp.valueOf(now.minusDays(1).atStartOfDay());
         System.out.println(now.atStartOfDay());

*/
     /*    LocalDate now = LocalDate.now();
         Timestamp beginTime = Timestamp.valueOf(String.valueOf(now.minusDays(1)) + " 00:00:00");
         System.out.println(String.valueOf(now.minusDays(1)) + "  23:59:59");
         Timestamp endTime = Timestamp.valueOf(String.valueOf(now.minusDays(1)) + "  23:59:59");
         System.out.println(beginTime);
         System.out.println(endTime);*/

         int a=2;
         long b=3;
     /*    float c= (float)a/b;
         System.out.println(c);
         System.out.println(Math.round(c*100));
         c=(float)(Math.round(c*100))/100;
         System.out.println(c);*/

         System.out.println(Math.round((float)a*100/b));

         System.out.println((float)Math.round((float)a*100/b)/100);

    }
}
