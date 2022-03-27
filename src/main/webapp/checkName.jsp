<%@ page import="java.io.PrintWriter" %>
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
	if(loginName == null){
%>
		<script>alert('对不起，请先登录！！');location.href='index.html'</script>")
<%

	}
%>
<body>

</body>
</html>