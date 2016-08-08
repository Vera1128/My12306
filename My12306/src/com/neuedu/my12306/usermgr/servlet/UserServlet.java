package com.neuedu.my12306.usermgr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.neuedu.my12306.usermgr.domain.Train;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.service.TrainService;

/**
 * Servlet implementation class UserServlet
 */

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		try {
			if (action == null || "search".equals(action)) {
				doSearch(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserServlet:wrong");
		}
	}
	
	protected void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		TrainService ts = TrainService.getInstance();
		String fromplace = request.getParameter("myfromplace");
		System.out.println(fromplace);
		String toplace = request.getParameter("mytoplace");
		System.out.println(toplace);
		String date = request.getParameter("mydate");
		System.out.println(date);
		
		List<Train> trainList =  ts.getTrainList(fromplace, toplace, date);
	//	List<Train> trainList =  ts.getTrainList("沈阳", "哈尔滨", "2016-8-2");
		System.out.println(trainList); //打印车次列表
		JSONObject jsonData = new JSONObject();
		if (trainList != null) {
			jsonData.put("trains", trainList);
		} else {
			jsonData.put("trains", null);
		}
		request.setAttribute("data", jsonData);
		request.getRequestDispatcher("/User/Train.jsp").forward(request,
				response);
	}
}
