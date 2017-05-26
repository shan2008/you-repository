function createAjax(){
 var ajax=null;
 
 try{
     ajax=new XMLHttpRequest();
     
     } catch(e1){
		         try{
		         
		         ajax=new ActiveXObject("microsoft.xmlhttp");
		         
		         }catch(e2)
		         {
		         alert("对不起你的浏览器不支持ajax对象！");
		         }       
     }
         
   return ajax;
   
   
}