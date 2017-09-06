package com.yous.learningtwo.host;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/8/31.
 */
public class Demo3 {

    public static void main(String[] args) {



       /* List<Student> list = new ArrayList<>();
        // Student st=new Student(1,"haha");

        list.add(new Student(1, "hahahsasasssas"));
        list.add(new Student(2, "hahahaaa"));
        list.add(new Student(2, "hahahaassssa"));
        list.add(new Student(4, "hahahaa"));
        list.add(new Student(4, "hahasah"));
        list.add(new Student(1, "hahsah"));


        Map<Integer, List<Student>> map = list.stream().collect(Collectors.groupingBy(o -> o.getId()));

        map.forEach((k, v) -> {
            System.out.println("key=" + k);
            v.forEach(x -> System.out.println(x.getName()));
            System.out.println("key=" + k + "结束");
        });

        String sqk = "asasasasas";
        for (int i = 0; i < 5; i++) {
            sqk += 1;
        }

        System.out.println(sqk);
*/

        //  remove(list);


       /* for (int i=0;i<list.size();i++){
            if(list.get(i).getId()==1 || list.get(i).getId()==2){
               list.remove(list.get(i));
                i--;
            }
        }*/

        // List<Integer> uids=list.stream().filter(x->x.getId()>0).map(p -> p.getId()).distinct().collect(Collectors.toList());

        // System.out.println(uids);

        // Map<Integer,List<Student>> map=list.stream().collect(Collectors.groupingBy(Student::getId));

      /*  Map<String,Set<String>> map=new HashMap<>();
        Set<String> set= map.get("uid");*/
        //Map<Integer,Student> map=list.stream().collect(Collectors.toMap(Student::getId,o->o,(key1,key2)->key2));
       /* map.forEach((k,v)->{
            System.out.println(k+" "+v.getName());
        });*/


        // System.out.println(list.size());
        //System.out.println(String.join(",", list.stream().map(x -> x.getName()).collect(Collectors.toList())));


        /*List<Integer> lists = new ArrayList<>();
        for (int i = 0; i < 320; i++) {
            lists.add(i);
        }

        List<List<Integer>> li = splitList(lists,100);

        System.out.println(li.size());
*/

        String str="%s date_add(date_format(BookingTime,'%%Y-%%m-%%d'),interval ? day)=curdate() %s ";
        String s=String.format(str, "hahah", "呵呵呵");
        System.out.println(String.format(str, "hahah", "呵呵呵"));

    }


    private static  <T> List<List<T>> splitList(List<T> list, Integer pageSize) {
        int listSize = list.size();
        int page = (listSize + (pageSize - 1)) / pageSize;
        List<List<T>> listArray = new ArrayList<>();
        for (int i = 0; i < page; i++) {
            List<T> subList = new ArrayList<>();
            for (int j = 0; j < listSize; j++) {
                int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;
                if (pageIndex == (i + 1)) {
                    subList.add(list.get(j));
                }
                if ((j + 1) == ((j + 1) * pageSize)) {
                    break;
                }
            }
            listArray.add(subList);
        }
        return listArray;
    }

    private static void remove(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student st = iterator.next();
            if (st.getId() == 2 || st.getId() == 1) {
                iterator.remove();
            }
        }

    }
}
