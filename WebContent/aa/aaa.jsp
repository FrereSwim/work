<%@ page language="java" import="java.util.*,com.jspsmart.upload.*"  
    pageEncoding="utf-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
aaa
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	out.println(basePath);
	%>

</body>
</html>