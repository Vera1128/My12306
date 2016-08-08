package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
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
import com.neuedu.my12306.usermgr.service.UserService;

/**
 * Servlet implementation class AdminServlet
 */
// @WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminServlet() {
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
		if ("show".equals(action)) {
			try {
				doShow(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if ("addUser".equals(action)) {
			try {
				doAddUser(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if ("delete".equals(action)) {
				try {
					doDelete(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else if ("findAndPush".equals(action)) {
			try {
				dofindAndPush(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if ("update".equals(action)) {
			try {
				doUpdate(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//			else if ("search".equals(action)) {
//			try {
//				doSearch(request, response);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	} 
//	private void doSearch(HttpServletRequest request,
//			HttpServletResponse response) throws Exception {
//		UserService us = UserService.getInstance();
//		JSONObject data = new JSONObject();
//		User u = new User();
//		String searchWords = request.getParameter("searchWords");
//		u.setUsername(searchWords);
//		if (us.findDim("username", searchWords)!=null) {
//			data.put("flag", "yes");
//		}
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(data.toString());
//		out.close();	
//	}

	protected  void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		UserService us = UserService.getInstance();
		JSONObject data = new JSONObject();
		User u = new User();
		populate(request, u);
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		u.setId(id);
		if (us.updateUser(u)) {
			data.put("flag", "yes");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data.toString());
		out.close();			
	}
	
	protected  void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		UserService us = UserService.getInstance();
		JSONObject data = new JSONObject();
		String[] ids = request.getParameter("ids_d").split(",");
		int[] userIdList = new int[ids.length];
		for (int i = 0; i < userIdList.length; i++) {
			userIdList[i]=Integer.parseInt(ids[i]);
		}
			try {
				if (us.deleteUsers(userIdList)) {
					data.put("flag", "yes");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data.toString());
		out.close();
	}
	
	protected  void dofindAndPush(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		UserService us = UserService.getInstance();
		JSONObject data = new JSONObject();
		String ids = request.getParameter("id");
		int id = Integer.parseInt(ids);
		User u = new User();
		u.setId(id);
		System.out.println(ids);
		User findUs = us.findUser(u);
		System.out.println(findUs);
		System.out.println(findUs.getCity());
		data.put("userData", findUs);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/Admin/userAdd.jsp").forward(request, response);
		System.out.println(findUs.getRule() + " " + findUs.getSex());
		
	}
	
	protected void doAddUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserService us = UserService.getInstance();
		JSONObject data = new JSONObject();
		User u = new User();
		populate(request, u);
		// u.setRule("1");
		u.setStatus("1");
		u.setPassword(Md5Utils.md5("123"));

		if (us.save(u)) {
			data.put("flag", "yes");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data.toString());
		out.close();
	}

	protected void populate(HttpServletRequest request, User u)
			throws NumberFormatException, Exception {
		String loginIp = request.getRemoteAddr();
		String username = request.getParameter("username");
		String realName = request.getParameter("realname");
		String rule = request.getParameter("rule");
		String gender = request.getParameter("sex");
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String certtype = request.getParameter("certtype");
		String certNum = request.getParameter("cert");
		String birth = request.getParameter("birthday");
		String usertype = request.getParameter("usertype");
		String content = request.getParameter("content");

		u.setUsername(username);
		u.setLogin_ip(loginIp);
		u.setRealname(realName);
		u.setSex(gender);
		u.setContent(content);
		u.setCert(certNum);
		u.setBirthday(birth);
		u.setRule(rule);

		// Province pro = null;
		// List<Province> plist =
		// ProvinceService.getInstance().getProvinceList();
		// for (Province p : plist){
		// if (p.getProvinceid().equals(province)){
		// pro = p;
		// break;
		// }
		// }
		// if (pro != null){
		// List<City> citylist =
		// CityService.getInstance().getCityList(pro.getProvinceid());
		// for (City c : citylist){
		// if (c.getId() == Integer.parseInt(city)){
		// u.setCity(c);
		// break;
		// }
		// }
		// }

		City c = new City();
		c.setId(Integer.parseInt(city));
		Province p = new Province();
		p.setProvinceid(province);
		c.setFather(p);
		u.setCity(c);

		int aaa = 1;
		if ("1".equals(certtype)) {
			aaa = 1;
		} else if ("2".equals(certtype)) {
			aaa = 2;
		} else if ("3".equals(certtype)) {
			aaa = 3;
		} else if ("4".equals(certtype)) {
			aaa = 4;
		}
		// CertType ct = CertTypeService.getInstance().FindAccurate("id", aaa);
		CertType ct = new CertType();
		// ct.setId(Integer.parseInt(certtype));
		ct.setId(aaa);
		u.setCert_type(ct);

		UserType ut = new UserType();
		// ut.setId(Integer.parseInt(usertype));
		if ("1".equals(usertype)) {
			aaa = 1;
		} else if ("2".equals(usertype)) {
			aaa = 2;
		} else if ("3".equals(usertype)) {
			aaa = 3;
		} else if ("4".equals(usertype)) {
			aaa = 4;
		}
		ut.setId(aaa);
		u.setUser_type(ut);
	}

	protected void doShow(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserService us = UserService.getInstance();
		String strPageSize = request.getParameter("pageSize");
		String strPageNum = request.getParameter("PageNum");
		
		int pageSize = 10, pageNum = 1;
		if (strPageSize != null) {
			pageSize = Integer.parseInt(strPageNum);
		}
		if (strPageNum != null) {
			pageNum = Integer.parseInt(strPageNum);
		}
		List<User> userList = us.getUserList(pageSize, pageNum, new User());
		JSONObject jsonData = new JSONObject();
		if (userList != null) {
			jsonData.put("users", userList);
		} else {
			jsonData.put("users", null);
		}
		request.setAttribute("data", jsonData);
		request.getRequestDispatcher("/Admin/Index.jsp").forward(request,
				response);
	}


}
