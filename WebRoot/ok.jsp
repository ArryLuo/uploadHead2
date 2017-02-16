<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'ok.jsp' starting page</title>
    

  </head>
  
  <body>
    文件名：${headFileName }<br/>
  文件类型：${headContentType }<br/>
  <c:forEach items="${users.head}" var="h">
  <hr/>
  大图<br/>
  <img src="${pageContext.request.contextPath }/upload/${h }" /><br/>
  小图<br/>
  <img src="${pageContext.request.contextPath }/upload/small_${h }" /><br/>
  </body>
  </c:forEach>
</html>
