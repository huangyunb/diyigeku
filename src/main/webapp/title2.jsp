<%@ page import="com.example.couple.entity.User" %>
<%@ page import="com.example.couple.entity.Equation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        var s=2400;
        window.onload=function start(){
            if(s==2400){
                var btn=document.getElementsByTagName("button")[0];
                var time=setInterval(function (){
                    if(s<=-1){
                        clearInterval(time);
                        alert('考试时间到，考试结束。');
                        document.getElementById("frm").submit();
                    }else{
                        var f = parseInt(s/60);
                        btn.innerHTML=f+":"+s%60;
                        s--;
                    }
                },1000);
            }

        }
        function finish(x){
            var h = x-s-1;
            var y = parseInt(h/60);
            alert('总用时 '+y+':'+h%60);
        }

    </script>
    <title>Title</title>
    <link  rel="stylesheet"  type="text/css" href="mycss2.css">
</head>
<%
    User u = (User) request.getAttribute("user");
    Equation[] timu = (Equation[]) request.getAttribute("timu");
%>
<body>
<div id="con">
    <center><font color="#f08080"><h1>四 则 混 合 运 算</h1></font></center>
    <a class="login_out" href="usermain.jsp" >退 出</a>
    <button class="center" ></button>
    <div>
        <form id="frm" action="login?op=cj" method="post">
            <table width="100%">
                <tr>
                    <%
                        for (int i=0;i<4;i++){
                    %>
                    <td><h2><%=timu[i].getSuanshi() %>=</h2></td>
                    <td><input type="text" name="t<%=i%>"></td>
                    <%
                        }
                    %>
                </tr>
                <tr>
                    <%
                        for (int i=4;i<8;i++){
                    %>
                    <td><h2><%=timu[i].getSuanshi() %>=</h2></td>
                    <td ><input type="text" name="t<%=i%>"></td>
                    <%
                        }
                    %>
                </tr>
                <tr>
                    <%
                        for (int i=8;i<12;i++){
                    %>
                    <td><h2><%=timu[i].getSuanshi() %>=</h2></td>
                    <td><input type="text" name="t<%=i%>"></td>
                    <%
                        }
                    %>
                </tr>
                <tr>
                    <%
                        for (int i=12;i<16;i++){
                    %>
                    <td><h2><%=timu[i].getSuanshi() %>=</h2></td>
                    <td><input type="text" name="t<%=i%>"></td>
                    <%
                        }
                    %>
                </tr>
                <tr>
                    <%
                        for (int i=16;i<20;i++){
                    %>
                    <td><h2><%=timu[i].getSuanshi() %>=</h2></td>
                    <td><input type="text" name="t<%=i%>"></td>
                    <%
                        }
                    %>
                </tr>
            </table>
            <center><button class="submit" onclick="finish(2400)">提交</button></center>
        </form>
    </div>
</div>
</body>
</html>
