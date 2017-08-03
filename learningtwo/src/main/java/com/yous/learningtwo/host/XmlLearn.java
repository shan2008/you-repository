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



      /*  UserDTO userDTO=new UserDTO();
        Student student=new Student();
        student.setName("hahah");
        userDTO.setStudent(student);
        Student p=userDTO.getStudent();
        setStudentName(p);
*/


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
    /*  Formula formula=new Formula() {
        @Override
        public double calculate(int a) {
          return  a*a;
        }
      };

      System.out.println(formula.calculate(5));


      Converter<String, Integer> converter = (f) -> Integer.valueOf(f);
      Integer converted = converter.convert("123");
      System.out.println(converted);
*/




     // Optional<String> optional = Optional.ofNullable("bam");

      //optional.isPresent();           // true
      //optional.get();                 // "bam"
      //optional.orElse("fallback");    // "bam"

     // System.out.println(optional.get());
     // System.out.println(optional.orElse("fallback"));
      //  Optional.ofNullable("bam").ifPresent((s) -> System.out.println(s.charAt(0)));



        /*List<Integer> list = Arrays.asList(1, 4, 1, 9);
        List<Student> list2 = new ArrayList<>();
        list2.add(new Student(1, "hah"));
        list2.add(new Student(2, "heihei"));
        list2.add(new Student(1, "sa"));
        list2.add(new Student(2, "ll"));
*/

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
        // HashMap<Integer,Student> hashMap=list2.stream().collect(Collectors.toMap(Student::getId, (o) -> o, (key1, key2) -> key1, LinkedHashMap::new));
        // Optional.ofNullable(list2).ifPresent((s) ->s.stream().collect(Collectors.toMap(Student::getId, Student::getName)));

       // Optional<List<Integer>> optional2 = Optional.of(list);
      //  optional2.ifPresent(s -> s.stream().filter(x -> x != 1).collect(Collectors.toList()));


        List<Student> list=new ArrayList<>();
        List<Student> list1=null;
        list.addAll(list1);
        list.forEach(x->{
            System.out.println(x.getName());
        });


    }


    private static void setStudentName(Student student){
        student.setName("you");
    }


}
