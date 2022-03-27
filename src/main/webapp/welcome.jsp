<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String loginName = (String) session.getAttribute("loginName");
%>

<body>
	<h3>欢迎<%=loginName %>使用本系统</h3>
	
	
</body>
</html>