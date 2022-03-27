package com.example.couple.servlet;

import com.example.couple.entity.Equation;
import com.example.couple.entity.User;
import com.example.couple.service.EquationServiceImp;
import com.example.couple.service.UserServiceImp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserServiceImp bs;

    public LoginServlet() {
        bs = new UserServiceImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String op = request.getParameter("op");
		System.out.println("ProductServlet---:--->" + op);

		if("login".equals(op)){
			login(request, response);
		}else if("add".equals(op)) {
			addUser(request, response);
		}else if("easy".equals(op)) {
			easy(request, response,op);
		}else if("hard".equals(op)) {
			hard(request, response,op);
		}else if("cj".equals(op)) {
			cj(request, response);
		}else if("common".equals(op)) {
			common(request, response,op);
		}else if("showscore".equals(op)) {
			showscore(request, response);
		}
	}

	//登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name+"  "+password);
		
		PrintWriter out = response.getWriter();
		
		User user = bs.findUserByLogin(new User(name, password));
		if(user != null ) {
			System.out.println(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginName", user.getUsername());
			request.setAttribute("user", user);

			out.write("<script>alert('恭喜，登录成功! ')</script>");
			request.getRequestDispatcher("usermain.jsp").forward(request, response);
			
		}else {
			out.write("<script>alert('对不起，用户名或密码错误! ');history.back();</script>");
		}	

	}

	//添加用户
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");

		User user = new User(name, password);
		System.out.println("确认个人信息："+ user );

		int i = bs.addUser(user);
		PrintWriter out = response.getWriter();
		if(i > 0) {
			out.write("<script>alert('注册成功 ! ! !  ');location.href='index.jsp' </script>");
		}else {
			out.write("<script>alert('注册失败 ! ! !  ');history.back();</script>");
		}

	}

	//简单题目
	private void easy(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {
		EquationServiceImp eq = new EquationServiceImp();
    	Equation[] timu = eq.chouputong();
		System.out.println(timu[0].getSuanshi());

		HttpSession session = request.getSession();
		session.setAttribute("nandu", op);
		session.setAttribute("daan", timu);
		request.setAttribute("timu", timu);
		request.getRequestDispatcher("title1.jsp").forward(request, response);
	}

	//一般题目
	private void common(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {
		EquationServiceImp eq = new EquationServiceImp();
		Equation[] timu = eq.choufenshi();
		System.out.println(timu[0].getSuanshi());

		HttpSession session = request.getSession();
		session.setAttribute("nandu", op);
		session.setAttribute("daan", timu);
		request.setAttribute("timu", timu);
		request.getRequestDispatcher("title3.jsp").forward(request, response);
	}

	//困难题目
	private void hard(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {
		EquationServiceImp eq = new EquationServiceImp();
		Equation[] timu = eq.choukuohao();
		System.out.println(timu[0].getSuanshi());

		HttpSession session = request.getSession();
		session.setAttribute("nandu", op);
		session.setAttribute("daan", timu);
		request.setAttribute("timu", timu);
		request.getRequestDispatcher("title2.jsp").forward(request, response);
	}

	//插入并查看本次成绩
	private void cj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String []ansser = new String[20];
		HttpSession session = request.getSession();
		int score=0;
		for (int i=0;i<20;i++){
			ansser[i]=request.getParameter("t"+i);//用户输入的答案
		}

		String name = (String) session.getAttribute("loginName");
		Equation[] daan = (Equation[]) session.getAttribute("daan");
		System.out.println(daan[2].getJieguo());
		for (int i=0;i<20;i++){
			daan[i].setDaan(ansser[i]);//将用户答案存入答案中
			if(daan[i].getJieguo().equals(daan[i].getDaan())){//用户答案和结果对比
				score=score+5;
			}
		}
		System.out.println(name+score);
		UserServiceImp bp = new UserServiceImp();
		bp.baocunchengji(name,score);

		request.setAttribute("daan", daan);
		PrintWriter out = response.getWriter();
		String nandu = (String) session.getAttribute("nandu");
		request.setAttribute("nandu", nandu);
		request.getRequestDispatcher("checktitle.jsp").forward(request, response);
	}

	//查看成绩
	private void showscore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("loginName");
		UserServiceImp bp = new UserServiceImp();
		int [] allscore = bp.suoyouchengji(name);

		request.setAttribute("loginName", name);
		request.setAttribute("allscore", allscore);
		request.getRequestDispatcher("score.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
