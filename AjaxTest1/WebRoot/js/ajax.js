function createAjax(){
 var ajax=null;
 
 try{
     ajax=new XMLHttpRequest();
     
     } catch(e1){
		         try{
		         
		         ajax=new ActiveXObject("microsoft.xmlhttp");
		         
		         }catch(e2)
		         {
		         alert("�Բ�������������֧��ajax����");
		         }       
     }
         
   return ajax;
   
   
}