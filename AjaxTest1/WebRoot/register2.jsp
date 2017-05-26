<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>用户注册</title>
	<!-- 引入ajax 文件 -->
	<script type="text/javascript" src="js/ajax.js"></script>
  </head>
  
  <body>

  请输入用户名：  <input  id="userNameID" type="text" maxlength=4 /><span id="checkID"></span> 

 <script type="text/javascript">
    //焦点失去事件
    document.getElementById("userNameID").onblur=function(){
     //获取当前文本中的内容
     var str=this.value;  
    //不为空，ajax传送
        var ajax=createAjax();
        var method="post";
        var url="${pageContext.request.contextPath}/userServlet?"+new Date().getTime();
        ajax.open(method,url);
         // ajax 默认的是get方式提交，若采用post方式提交需要设置请求头
        ajax.setRequestHeader("content-type","application/x-www-form-urlencoded");
        
        //post 方式内容是在实体中
        var content="userName="+str;
        ajax.send(content);
        
       
        //******接受服务器的*************
        
        ajax.onreadystatechange=function(){
          
          if(ajax.readyState==4)
        
		            if(ajax.status==200)
		            {
		          
		              //正常响应     
		              //获取响应的类型，并且插入span
		              //创建image标签
		              var imageElement=document.createElement("img");
		              imageElement.src=ajax.responseText;
		           
		              imageElement.style.height="20px";
		              imageElement.style.weight="20px";
		              
		              //嵌入
		              var spanElement=document.getElementById("checkID");
		              //添加之前先清空，防止后面叠加
		              spanElement.innerHTML="";
		              //添加图表
		              spanElement.appendChild(imageElement);          
		        }
     }

    }

 
 </script>


  
  </body>
</html>
