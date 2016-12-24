<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  当前时间：<span id="time"></span>  <br>
 <input  id="button" type="button" value="获取当前时间"/>
 
 
 <script type="text/javascript">
   function createAjax(){
     varajax=null;
     
     try{
     ajax=new XMLHttpRequest();
     } catch(e1){
	         try{
	         
	         ajax=new ActiveXObject("microsoft.xmlhttp");
	         
	         }catch(e2)
	         {
	         alert("对不起你的浏览器不支持ajax对象！")
	         }       
     }
     
       return ajax;
   }
   
 </script>
 
 
 <script type="text/javascript">
 
 
     document.getElementById("button").onclick=function(){
     // 获取ajax;
     var ajax= createAjax();
     method="get";
     url="${pageContext.request.contextPath}/ajaxServlet";
     //打开方式
     ajax.open(method,url);  
     //get方式提交的话不用谢类容
     ajax.send(null);
     
     //*******************************************
     
	      //准备接受,触发函数
	      ajax.onreadystatechange=function(){
	      
		      //获取状态对象 1,2,3,4
		      if(ajax.readyState==4){
		      
				      //在判断响应状态码；
				      if(ajax.status==200){
				       //取出类容
				       var timeStr=ajax.responseText;
				       //定位标签嵌入时间
				       var timespan=document.getElementById("time");
				
				       timespan.innerHTML=timeStr; 
				      }
		      }   
	   }
  }
 
 </script>
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果你说我的小丫小苹果
 
 
   
  
  
  </body>
</html>
