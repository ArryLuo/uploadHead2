<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/upload_upload" method="post" enctype="multipart/form-data">
   	用户名:<input type="text" name="users.username"/><br/>
   	头像1:<input type="file" name="head"/>
   	 头像2:<input type="file" name="head"/>
   	<input type="submit" value="注册"/>
   </form>
  </body>
</html>
