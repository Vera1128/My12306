package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.UserService;

/**
 * Servlet implementation class Login
 */
// @WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action == null || "login".equals(action)) {
			try {
				doLogin(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("LoginServlet:wrong");
			}
		}

	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession se = request.getSession();		
		UserService us = UserService.getInstance();
		String username = request.getParameter("username");
		String psw1 = request.getParameter("psw1");
		User u = new User();
		u.setUsername(username);
		u.setPassword(Md5Utils.md5(psw1));
		// User r = us.findUser(u);
		 String msg = null;
		User dbUser = us.login(u);
		if (dbUser != null) {
			 msg = "登录成功";			
			if ("1".equals(dbUser.getRule())) {
				response.sendRedirect(request.getContextPath() + "/Admin/admin?action=show");
			}
			else
			{
				response.sendRedirect(request.getContextPath() + "/User/User.jsp");
			}
		} else {
			msg="error， please check your information";
		}
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<html>");
		 out.println("<head><meta charset = 'UTF-8'>");
		 out.println("<title>Hello</title>");
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<p>" + msg + "</p>");
		 out.println("</body>");
		 out.println("<ml>");
		 out.close();
	}
}
