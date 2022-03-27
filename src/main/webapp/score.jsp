<%@ page import="com.example.couple.dao.UserDao" %>
<%@ page import="com.example.couple.dao.UserDaoImp" %>
<%@ page import="net.sf.json.JSONArray" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html; ISO-8859-1;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8"></meta>
        <title>查看成绩</title>
        <script src="echarts.min.js"></script>
        <style>
        #con{
            background: url("tu2.png") no-repeat fixed center;
            background-size: cover;
        }
        .rg{
            float: right;
            margin: 30px;
        }
        </style>
        <link  rel="stylesheet"  type="text/css" href="mycss2.css">
    </head>
    <body id="con">
        <%
            String name =(String)session.getAttribute("loginName");
            int [] allscore = (int[]) request.getAttribute("allscore");
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0;i<allscore.length;i++){
                list.add(allscore[i]);
            }
            System.out.println(list);
            HashMap<String,Integer> map = new HashMap<>();
            JSONArray json = JSONArray.fromObject(list);
            System.out.println(json);
            request.getSession().setAttribute("json",json);
        %>
        <center><font color="#f08080"><h1>四 则 混 合 运 算</h1></font></center>
        <a class="login_out" href="usermain.jsp" >退 出</a>
        <div id="main" style="width: 650px;height:450px;position: absolute;top: 20%;left: 30%"></div>

    <script>
        var json = '${sessionScope.json}';
        var jsonobj = JSON.parse(json);

        var dataName = [];
        var dataNum = [];
        var temp = jsonobj;

        (function (){
            if(temp.length<5){
                for(var i=0;i<temp.length ;i++) {
                    var a = '第' + (i + 1) + '轮'
                    dataName.push(a);
                    dataNum.push(temp[i]);
                }
            }else{
                for(var i=temp.length-5;i<temp.length ;i++){
                    var a ='第'+(i+1)+'轮'
                    dataName.push(a);
                    dataNum.push(temp[i]);
                }
            }
        })();
        var myChart2 = echarts.init(document.getElementById('main'));
        var option = {
            title:{
            text:'最近五次分数统计',
            padding:-0.5,
            textAlign:'left'
            },
            tooltip:{},
            legend:{
                data:['分数']
            },
            xAxis:{
                data:dataName,
            },
            yAxis: {
                type:"value",
                name:'分数',
                splitNumber:5
            },
            series:[{
                name:'成绩',
                type: 'bar',
                data:dataNum,
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position:'top',
                            textStyle:{
                                color:'black',
                                fontsize:16
                            }
                        }
                    }
                },
                barWidth:20,
                data:dataNum,
            }]
        };
        myChart2.setOption(option);
    </script>
</body>
    </html>