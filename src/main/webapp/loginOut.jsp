<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	session.removeAttribute("loginName");
	//重新生成请求和响应
	response.sendRedirect("index.html");
	
%>
<body>

</body>
</html>