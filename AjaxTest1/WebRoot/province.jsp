<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>省份-城市</title>
    <script type="text/javascript" src="js/ajax.js"></script>  
  </head>
  
  <body>
省份<select style="width:111px" id="provinceID">
  <option>请选择省份</option>
  <option>湖北</option>
  <option>广东</option>
  </select>
&nbsp; &nbsp;

城市<select style="width:111px" id="cityID">
  <option>请选择城市</option>
   </select>
  </body>
  
  
  <script type="text/javascript">
     
document.getElementById("provinceID").onchange=function(){
 

     //获取当前对现象的索引
    var index=this.selectedIndex;
    var provinceElement=this[index];
    
    //获取省份的名称
    var province=provinceElement.innerHTML;
    
    if("请选择省份"!=province){
    
     //创建ajax
     var ajax=createAjax();
      // alert(ajax!=null);
     
     var method="post";
     var url="${pageContext.request.contextPath}/provinceCity?time="+new Date();
     ajax.open(method,url);
     ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
     var content="province="+province;  
     ajax.send(content);
     
     
     //****************等待接收
     
     ajax.onreadystatechange=function(){
     
     var cityElement=document.getElementById("cityID");
     cityElement.options.length=1;//变动就清空
        
      if(ajax.readyState==4){
         if(ajax.status==200)
         {
           
            //获取xml文件
           var xmlDocument=ajax.responseXML;
            // alert(xmlDocument!=null);
   
           //读取xml,返回city数组,xml 解析方式
            var citys=xmlDocument.getElementsByTagName("city");
            
             for(var i=0;i<citys.length;i++)
             {
                    var value=citys[i].firstChild.nodeValue;
                  
                  
                    //创建option
                   var optionElement=document.createElement("option");
                   optionElement.innerHTML=value;
                   //插入到select下面
                   cityElement.appendChild(optionElement);
                 
                
             
             
             }
             
       
      }
     
      }    
    }
    }

 }
   

  </script>
  
  
  
  
</html>
