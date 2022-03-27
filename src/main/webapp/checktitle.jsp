<%@ page import="com.example.couple.entity.User" %>
<%@ page import="com.example.couple.entity.Equation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link  rel="stylesheet"  type="text/css" href="mycss2.css">
</head>
<%
    Equation[] timu = (Equation[]) request.getAttribute("daan");
    String nandu = (String) request.getAttribute("nandu");
%>
<body>
<div id="con">
    <center><font color="#f08080"><h1>试 卷</h1></font></center>
    <a class="login_out" href="usermain.jsp" >退 出</a>
    <div>
        <table width="100%">
            <tr>
                <%
                    int score=0;
                    for (int i=0;i<4;i++){
                %>
                    <td><h2><%=timu[i].getSuanshi() %>=<%=timu[i].getDaan() %></h2></td>
                    <%
                        if (timu[i].getDaan().equals(timu[i].getJieguo())){
                            score+=5;
                    %>
                        <td><h2 style="color: red" >√</h2></td>
                    <%
                        }else{
                    %>
                        <td><h2 style="color: red" >× <%=timu[i].getJieguo() %></h2></td>
                    <%
                        }
                    %>
                <%
                    }
                %>
            </tr>
            <tr>
                <%
                    for (int i=4;i<8;i++){
                %>
                    <td><h2><%=timu[i].getSuanshi() %>=<%=timu[i].getDaan() %></h2></td>
                    <%
                        if (timu[i].getDaan().equals(timu[i].getJieguo())){
                            score+=5;
                    %>
                        <td><h2 style="color: red" >√</h2></td>
                    <%
                    }else{
                    %>
                        <td><h2 style="color: red" >× <%=timu[i].getJieguo() %></h2></td>
                    <%
                        }
                    %>
                <%
                    }
                %>
            </tr>
            <tr>
                <%
                    for (int i=8;i<12;i++){
                %>
                    <td><h2><%=timu[i].getSuanshi() %>=<%=timu[i].getDaan() %></h2></td>
                    <%
                        if (timu[i].getDaan().equals(timu[i].getJieguo())){
                            score+=5;
                    %>
                        <td><h2 style="color: red" >√</h2></td>
                    <%
                    }else{
                    %>
                        <td><h2 style="color: red" >× <%=timu[i].getJieguo() %></h2></td>
                    <%
                        }
                    %>
                <%
                    }
                %>
            </tr>
            <tr>
                <%
                    for (int i=12;i<16;i++){
                %>
                    <td><h2><%=timu[i].getSuanshi() %>=<%=timu[i].getDaan() %></h2></td>
                    <%
                        if (timu[i].getDaan().equals(timu[i].getJieguo())){
                            score+=5;
                    %>
                        <td><h2 style="color: red" >√</h2></td>
                    <%
                    }else{
                    %>
                        <td><h2 style="color: red" >× <%=timu[i].getJieguo() %></h2></td>
                    <%
                        }
                    %>
                <%
                    }
                %>
            </tr>
            <tr>
                <%
                    for (int i=16;i<20;i++){
                %>
                    <td><h2><%=timu[i].getSuanshi() %>=<%=timu[i].getDaan() %></h2></td>
                    <%
                        if (timu[i].getDaan().equals(timu[i].getJieguo())){
                            score+=5;
                    %>
                        <td><h2 style="color: red" >√</h2></td>
                    <%
                    }else{
                    %>
                        <td><h2 style="color: red" >× <%=timu[i].getJieguo() %></h2></td>
                    <%
                        }
                    %>
                <%
                    }
                %>
            </tr>
        </table>
        <center><h2 style="color: red" >分数:<%=score%></h2></center>
        <form action="login?op=<%=nandu %>" method="post">
            <center><button class="submit">再来一次</button></center>
        </form>
    </div>
</div>
</body>
</html>
