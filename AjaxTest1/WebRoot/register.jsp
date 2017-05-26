<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  <form >
  请输入用户名：  <input  id="userNameID" type="text" maxlength=4 />
  </form>
  <hr>
  <span id="checkID"></span> 
 <script type="text/javascript">
  //穿件ajax
  
 function createAjax(){
 var ajax=null;
 
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
    //焦点失去事件
    document.getElementById("userNameID").onblur=function(){
     //获取当前文本中的内容
     var str=this.value;  
     //对中文用户名进行编码,默认Utf-8，和上面的编码无关
     str=encodeURI(str);
     if(str.length==0)
     { 
      document.getElementById("checkID").innerHTML="用户名必填"
     } else
     { 
        //不为空，ajax传送
        var ajax=createAjax();
        alert(str);
        var method="get";
        var url="${pageContext.request.contextPath}/userServlet?"+new Date().getTime()+"&userName="+str;
        
        ajax.open(method,url);
        ajax.send(null);
        
        
        //******接受服务器的*************
        
        ajax.onreadystatechange=function(){
          
          if(ajax.readyState==4)
        
            if(ajax.status==200)
            {
              //正常响应     
              //获取响应的类型，并且插入span
              document.getElementById("checkID").innerHTML=ajax.responseText;            
         
            }
     
        }

     }

    }
    
    
 
 
 </script>

  
  
  </body>
</html>
