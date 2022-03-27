<%@ page import="com.example.couple.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link  rel="stylesheet"  type="text/css" href="mycss.css">
	<script>
		function chouti1(){
			location.href='login?op=easy';
		}
		function chouti2(){
			location.href='login?op=hard';
		}
		function chouti3(){
			location.href='login?op=common';
		}
	</script>
</head>
<%
	User u = (User) request.getAttribute("user");
%>
<body>

	<div id="con">
		<center><font color="#f08080"><h1>四 则 混 合 运 算</h1></font></center>
		<a class="login_out" href="http://localhost:8080/couple_war_exploded/" >退 出</a>
		<div class="center">
			<div>
				<button class="anniu" type="submit" onclick='chouti1()'>简 单 模 式</button>
			</div>
			<br>
			<div>
				<button class="anniu" type="submit"  onclick='chouti3()'>普 通 模 式</button>
			</div>
			<br>
			<div>
					<button class="anniu" type="submit"  onclick='chouti2()'>困 难 模 式</button>
			</div>
			<br>
			<div>
				<form action="login?op=showscore" method="post">
					<button class="anniu" type="submit">查 看 成 绩</button>
				</form>
			</div>
		</div>
	</div>
	
</body>

</html>