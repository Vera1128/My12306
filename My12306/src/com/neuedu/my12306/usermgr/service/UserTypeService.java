package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.UserTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserTypeService {
	private static final UserTypeService instance = new UserTypeService();

	public static UserTypeService getInstance() {
		return instance;
	}

	private UserTypeService() {

	}

	public List<UserType> getUserTypeList() {
		Connection conn = null;
		List<UserType> ct = null;
		try {

			conn = DBUtils.getConnection();
			UserTypeDaoImpl ctdi = new UserTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.getUserTypeList();
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return ct;
	}

	
}
