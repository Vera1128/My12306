package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.common.Md5Utils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;
import com.neuedu.my12306.usermgr.service.CertTypeService;
import com.neuedu.my12306.usermgr.service.CityService;
import com.neuedu.my12306.usermgr.service.ProvinceService;
import com.neuedu.my12306.usermgr.service.UserService;
import com.neuedu.my12306.usermgr.service.UserTypeService;

/**
 * Servlet implementation class RegisterServlet
 */
// @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
		try {
			if (action == null || "register".equals(action)) {
				doRegister(request, response);
			} else if ("check".equals(action)) {
				doUserNameCheck(request, response);
			} else if ("show".equals(action)) {
				dataInit(request, response);
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				// request.get
			} else if ("showchild".equals(action)) {
				cityInit(request, response);
				// request.getRequestDispatcher("/reg.jsp").forward(request,
				// response);
			} else if ("findProvince".equals(action)) {
				try {
					provinceDataInit(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("RegisterServlet:wrong");
		}
	}

	protected void doUserNameCheck(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		UserService us = UserService.getInstance();
		User tmp = new User();
		JSONObject data = new JSONObject();
		tmp.setUsername(username);
		User u = us.findUser(tmp);
		// String result = "0";
		if (u != null) {
			// result = "1";
			data.put("flag", "yes");
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(data.toString());
		out.close();
	}

	protected void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		UserService us = UserService.getInstance();
		User u = new User();
		populate(request, u);
		u.setRule("1");
		u.setStatus("1");

		String msg;
		// User tmp = new User();
		// tmp.setUsername(u.getUsername());
		// User dbUser = us.findUser(tmp);
		// String result = "2";
		// if (dbUser == null) {
		// u.setPassword(u.getPassword());
		if (us.save(u)) {
			msg = "注册成功";
			// if(u.getRule().equals("1"))
			// response.sendRedirect(request.getContextPath() +
			// "/Admin/Admin.html");
			// else
			// response.sendRedirect(request.getContextPath() +
			// "/User/User.html");
		} else {
			msg = "注册失败";
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

	private void populate(HttpServletRequest request, User u) {
		String loginIp = request.getRemoteAddr();
		String username = request.getParameter("username");
		String psw1 = request.getParameter("psw1");
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		// String province = request.getParameter("province");
		// String city = request.getParameter("city");
		String certtype = request.getParameter("certtype");
		String certNum = request.getParameter("certNum");
		String birth = request.getParameter("birth");
		String usertype = request.getParameter("usertype");
		String content = request.getParameter("content");

		u.setUsername(username);
		u.setPassword(Md5Utils.md5(psw1));// ///////////////////////
		u.setLogin_ip(loginIp);
		u.setRealname(realName);
		u.setSex(gender);
		// Province p = new Province();
		// p.setProvince(province);

		City c = new City();
		c.setId(1);
		// c.setFather(p);

		u.setCity(c);
		CertType ct = new CertType();
		ct.setId(Integer.parseInt(certtype));
		u.setCert_type(ct);
		// ct.setContent(certtype);
		// u.setCert_type(ct);
		u.setCert(certNum);
		u.setBirthday(birth);

		UserType ut = new UserType();
		ut.setId(Integer.parseInt(usertype));
		u.setUser_type(ut);
		u.setContent(content);
		// return u;
	}

	private void dataInit(HttpServletRequest request,
			HttpServletResponse response) {
		certTypeDataInit(request, response);
		userTypeDataInit(request, response);
		// provinceDataInit(request, response);
	}

	private void certTypeDataInit(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject jsonData_ct = new JSONObject();

		CertTypeService cts = CertTypeService.getInstance();
		List<CertType> ctdatalist = cts.getCertTypeList();
		if (ctdatalist != null) {
			jsonData_ct.put("data", ctdatalist);
		} else {
			jsonData_ct.put("data", null);
		}
		request.getSession().setAttribute("certTypeData", jsonData_ct);
	}

	private void userTypeDataInit(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject jsonData_ut = new JSONObject();
		UserTypeService uts = UserTypeService.getInstance();
		List<UserType> utdatalist = uts.getUserTypeList();
		if (utdatalist != null) {
			jsonData_ut.put("data", utdatalist);
		} else {
			jsonData_ut.put("data", null);
		}
		request.getSession().setAttribute("userTypeData", jsonData_ut);
	}

	private void provinceDataInit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		JSONObject jsonData_p = new JSONObject();
		ProvinceService ps = ProvinceService.getInstance();
		List<Province> pdatalist = ps.getProvinceList();
		if (pdatalist != null) {
			jsonData_p.put("data", pdatalist);
		} else {
			jsonData_p.put("data", null);
		}
		request.getSession().setAttribute("provinceData", jsonData_p);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonData_p.toString());
		out.close();
	}

	private void cityInit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String provinceid = request.getParameter("provinceid");
		JSONObject jsonData = new JSONObject();
		CityService cs = CityService.getInstance();
		List<City> cdatalist = cs.getCityList(provinceid);
		if (cdatalist != null) {
			jsonData.put("data", cdatalist);
		} else {
			jsonData.put("data", null);
		}

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonData);
		out.close();
		// request.setAttribute("data", jsonData);
		// request.getSession().setAttribute("citydata", jsonData);
	}

//	protected void dofindAndPush(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//
//	}
}
