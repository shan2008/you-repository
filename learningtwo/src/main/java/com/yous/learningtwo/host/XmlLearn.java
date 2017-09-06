package com.yous.learningtwo.host;

import com.mysql.jdbc.Driver;
import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.nashorn.internal.objects.annotations.Function;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import sun.java2d.SurfaceDataProxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.Clock;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by syou on 2017/7/5.
 */
public class XmlLearn {

    public static void main(String[] args) throws Exception {
/*
        int[] fun ={0,1,2,3,4,5,6};
        int[] funs=new int[3];
        System.arraycopy(fun, 0, fun, 0,3);
        for (int i=0;i<fun.length;i++){
            System.out.println(fun[i]);
        }

        String h="你好啊啊啊哈哈哈哈";
        byte[] bytes=h.getBytes();
        byte[] shortbytes=new byte[10];
        if(bytes.length>10){
            System.arraycopy(bytes,0,shortbytes,0,10);
        }
        String str=new String(shortbytes,"utf-8");
        System.out.println(str);*/


      /* Document doc=DocumentHelper.createDocument();
        Element rootElement=doc.addElement("contactList");
        Element item=rootElement.addElement("contact");
        item.addAttribute("id", "001");
        item.addAttribute("name", "shan");

        item.addElement("name").setText("shan");
        item.addElement("school").setText("DHU");

        FileOutputStream outputStream=new FileOutputStream("d:\\Users\\syou\\Desktop\\student.xml");
        OutputFormat format=OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer=new XMLWriter(outputStream,format);
        writer.write(doc);
        writer.close();
*/

    /*  String url="jdbc:mysql://127.0.0.1:3306/stu";
      String user="root";
      String password="root";
      Class.forName("com.mysql.jdbc.Driver");

      Properties properties=new Properties();
      properties.setProperty("user",user);
      properties.setProperty("password", password);

      Connection connection= DriverManager.getConnection(url,properties);

      System.out.println(connection);
*/

        //  final UserDao userDao=new UserDaoImpl();
      /*Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

          if("save".equals(method.getName())){
            System.out.println("执行了保存方法");
          }else{
            return method.invoke(userDao,args);
          }
          return null;
        }
      });*/

  /* GetClassColumn<Student> students=new GetClassColumn<>();
      String[] columns=students.getClassColumn2(Student.class);
      for (String column:columns){
        System.out.println(column);
      }*/


     /* List<Integer> list=Arrays.asList(2, 4, 1, 9);
      List<Integer> list2=null;
      list.sort((e1, e2) -> e1.compareTo(e2));
     // System.out.println(list);
      Optional.of(list2).map(s -> {
        System.out.println(s);
        return new ArrayList<>();
      }).orElse(new ArrayList<>());
*/
        //firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" );

     /* //  List<Integer> list = Arrays.asList(2, 4, 1, 9);
        List<Integer> list2 = list.stream().filter(e -> e != 2).collect(Collectors.toList());
        list2.sort((e1, e2) -> e1.compareTo(e2));
        Collections.sort(list2,(e1,e2)->e1.compareTo(e2));
        // System.out.println(list.stream().filter(e->e==2).count());
        System.out.println(list2);
        Clock clock = Clock.systemUTC();
        System.out.println(clock.getZone());
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println("***********************");
        LocalDate localDate = LocalDate.now(clock);
        LocalDate time = LocalDate.now();

        System.out.println(time);
        System.out.println(localDate);
        System.out.println("***********************");

*/
     /* Formula formula=new Formula() {
        @Override
        public double calculate(int a) {
          return  a*a;
        }
      };

      System.out.println(formula.calculate(5));

        *//**
         * 字符串转整数
         *//*
      Converter<String, Integer> converter = (f) -> Integer.valueOf(f);
      Integer converted = converter.convert("123");
      System.out.println(converted);

      Convert2<Student,List<Student>> getStudents=(f)->{
          f.setId(123);
          f.setName("youshan");
          return Arrays.asList(f);
      };

        System.out.println(getStudents.getStudentList(new Student()));
        */


        // Optional<String> optional = Optional.ofNullable("bam");

        //optional.isPresent();           // true
        //optional.get();                 // "bam"
        //optional.orElse("fallback");    // "bam"

        // System.out.println(optional.get());
        // System.out.println(optional.orElse("fallback"));
        //  Optional.ofNullable("bam").ifPresent((s) -> System.out.println(s.charAt(0)));


        // List<Integer> list = Arrays.asList(1, 4, 1, 9);
 /*       List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1, "hah"));
        list2.add(new Student(2, "heihei"));
        list2.add(new Student(1, "sa"));
        list2.add(new Student(2, "ll"));

       Student  a=list2.stream().filter(x->x.getId()==1 && x.getName()=="hah").findFirst().orElse(null);

        System.out.println(a.getName()+a.getId());*/

        // List<Student> list3=list2.stream().filter(x->x.getId()!=2).distinct().collect(Collectors.toList());
        // List<Student> list3=list2.stream().filter(x->x.getId()!=2).distinct().collect(Collectors.toList());

        // list2.stream().filter(distinctByKey(x->))
        // HashMap<Integer,Student> map1=
        //Map<Integer,List<Student>> map3=list2.stream().collect(Collectors.groupingBy(Student::getId,Collectors.toList()));

        // List<Student>  list5=list2.stream().distinct().collect(Collectors.toList());
        // System.out.println(list5);
        // list2.stream().collect(Collectors.groupingBy(Student::getId,Collectors.toSet()));

        //  Collection<String> list4 = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        // Get collection without duplicate i.e. distinct only
        //  List<String> distinctElements = list4.stream().distinct().collect(Collectors.toList());

        //Let's verify distinct elements
        //  System.out.println(distinctElements);

        //list2.stream().filter(distinctByKey();


        // list2.stream().map(x->x.getId()).collect(Collectors.groupingBy(Student::getId).toList());
       /*  HashMap<Integer,Student> hashMap=list2.stream().collect(Collectors.toMap(Student::getId, (o) -> o, (key1, key2) -> key1, LinkedHashMap::new));
         Map<Integer,Integer> map2=list2.stream().collect(Collectors.groupingBy(Student::getId,Collectors.counting()));
        map2.forEach((k,v)->{
            System.out.println(k+"="+v.getName());
        });*/

        // Optional.ofNullable(list2).ifPresent((s) ->s.stream().collect(Collectors.toMap(Student::getId, Student::getName)));

        // Optional<List<Integer>> optional2 = Optional.of(list);
        //  optional2.ifPresent(s -> s.stream().filter(x -> x != 1).collect(Collectors.toList()));


     /*   List<Student> list=new ArrayList<>();
        List<Student> list1=null;
        list.addAll(list1);
        list.forEach(x -> {
            System.out.println(x.getName());
        });*/



        /*UserDTO userDTO=new UserDTO();
        Student student=new Student();
        student.setName("hahah");
        userDTO.setStudent(student);

        Student p=userDTO.getStudent();
        setStudentName(p);

        System.out.println(userDTO.getStudent().getName());*/


     /*   List<Integer> lists=new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);
        lists.add(6);
        lists.add(7);
        lists.forEach(x->{
            if(x<=4){
                return ;
            }
            System.out.println(x);
        });*/

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, ""));
        students.add(new Student(2, "haha"));
        students.add(new Student(2, "haha"));
        students.add(new Student(3, "haha"));
        students.add(new Student(4, "haha"));

        // deleteStudent(students);
        //List li= students.stream().map(t->t.getId()).collect(Collectors.toList());

       // System.out.println(getdesetSetMinUidScore(students));
       //  test(students);


       /* students.sort((e1,e2)->{
            if(e1.getId()==e2.getId()){
                return 0;
            }
           return e1.getId()<e2.getId()?1:-1;
        });

         System.out.println(String.join(",",students.stream().map(x->x.getId()).collect(Collectors.toList())+""));*/

/*        List<Integer> lists=new ArrayList<>();
        lists.add(1);
        lists.add(2);
        lists.add(2);
        lists.add(4);
        lists.add(4);
        lists.add(6);
        lists.add(7);

       Set<Integer> li=lists.stream().map(x->x).collect(Collectors.toSet());

        System.out.println(String.join(",",li+""));*/

  /*      UserDTO userDTO=new UserDTO();
        userDTO.getStudent().setId(1);
        userDTO.getStudent().setName("222");
        System.out.println(userDTO.getStudent().getName());*/
       /* Set<String>  set=new HashSet<>();
        set.add("hahaha");
        set.add("hahah");
        set.add("hahah");
        System.out.println(String.join(",",set));

*/

       /* String str="你好&you我们中心为你服务&de";
        str=str.replace("&you","大哥");
        str=str.replace("&de","嘿嘿");
        str=str.replace("&dd","哦哦哦");

        System.out.println(str);*/


    }


    private static void setStudentName(Student student) {
        student.setName("you");
    }

    private static void deleteStudent(List<Student> students) {

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == 1) {
                iterator.remove();
            }
        }

    }


    private static float getdesetSetMinUidScore(List<Student> students) {
        if (students.isEmpty()) {
            return 0;
        }
        return students.stream().max(Comparator.comparing(x -> x.getId())).get().getId();
    }


    private static Set<Integer> test(List<Student> students) {

        Set<Integer> set = new HashSet<>();
        students.forEach(x -> {
            set.add(x.getId());
            x.setName("1234fjfjfj");
        });

        return set;
    }

}
