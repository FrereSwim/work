<%@page import="cn.xy.action.SystemAction"%>
<%@ page language="java" import="java.util.*,com.jspsmart.upload.*,java.text.*,javax.servlet.*"  
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
    <head>  
        <title>上传处理页面</title>  
    </head>  
  
    <body>  
        <%   
            //之所以要放到异常抛出结构里面，是为了避免直接访问此页报错   
            try{   
            	String dname = request.getParameter("name");
            	System.out.println(dname);
                //指定动作   
                /* SmartUpload smart=new SmartUpload();   
                smart.initialize(pageContext);   
                smart.upload();  
                Date date = new Date();
                String timestamp = String.valueOf(date.getTime());
                String name = smart.getFiles().getFile(0).getFileName();//获取文件名 
                String ext = smart.getFiles().getFile(0).getFileExt();//获取文件后缀 
                String path =  timestamp +  name+ ". "+ext;//完整文件名 
                String p = "G:/eclipse/project/RestaurantMain/WebContent/wenjian";
                smart.getFiles().getFile(0).saveAs( p + "/ "+path);//保存在容器目录下
                //String str = session.getServletContext().getRealPath("/");
                //smart.save("/数据导入");
                //smart.save("G:/eclipse/project/RestaurantMain/WebContent/wenjian");
                response.sendRedirect("../memberPage/aa.html?result=1"); */
            }   
            catch(Exception e){ 
            	response.sendRedirect("../memberPage/aa.html?result=0");
            }
         %>  
    </body>  
</html>