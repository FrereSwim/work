<%@ page language="java" import="java.util.*,com.jspsmart.upload.*"  
    pageEncoding="utf-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>下载处理页面</title>  
    </head>  
  
    <body>  
        <%   
            //之所以要放到异常抛出结构里面，是为了避免直接访问此页报错   
            try{   
                //指定动作   
                SmartUpload smart=new SmartUpload();   
                smart.initialize(pageContext);   
                //smart.upload();   
                //String fileName = new String(request.getParameter("uploadName").getBytes("iso-8859-1"), "utf-8");
                String fileName = new String(request.getParameter("uploadName"));
                //System.out.println(fileName);
                smart.downloadFile("wenjian/" + fileName);   
            }   
            catch(Exception e){   
            }
         %>  
       <!--  <a href="upload.jsp">返回</a> -->  
    </body>  
</html>