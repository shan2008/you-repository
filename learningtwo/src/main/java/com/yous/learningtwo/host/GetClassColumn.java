package com.yous.learningtwo.host;

import java.lang.reflect.Field;

/**
 * Created by syou on 2017/7/11.
 */
public class GetClassColumn<T> {

   public String[] getClassColumn(Class<T> clazz) throws  Exception{
        Field[] fields=clazz.getDeclaredFields();
        String[] colums=new String[fields.length];
        int i=0;
        for (Field field : fields){
           colums[i]=field.getName();
           i++;
        }

        return colums;
    }


    public String[] getClassColumn2(Class<T> clazz) throws  Exception{
        Field[] fields=clazz.getDeclaredFields();
        String[] colums=new String[fields.length];
        int i=0;
        for (Field field : fields){
            field.setAccessible(true);
            Class obj=field.getType();
            field.setAccessible(false);
            if(obj==Integer.class){
                colums[i]="int ="+field.getName();
            }

            if(obj==String.class){
                colums[i]="string="+field.getName();
            }
            i++;

        }
        return colums;
    }

}
