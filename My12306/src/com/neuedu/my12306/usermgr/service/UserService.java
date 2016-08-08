package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.UserDaoImpl;
import com.neuedu.my12306.usermgr.domain.User;

public class UserService {
	private static final UserService instance = new UserService();

	public static UserService getInstance() {
		return instance;
	}

	private UserService() {

	}
	
	public boolean save(User us) throws Exception {
		Connection conn = null;
		int i = 0;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			i = ctdi.save(us);
			DBUtils.commit(conn);
		} catch (Exception e) {
			
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return i != 0 ? true : false;
	}

	public User login(User u) throws Exception {
		User us = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			us = ctdi.login(u);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return us;
	}

	public User findUser(User us) throws Exception {
		User one = null;
		Connection conn = null;
		try {
			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			one = ctdi.findUser(us);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
			e.printStackTrace();
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return one;
	}
	
	public int getUserListRowCount(User one)
	{
		int rowCount = 0;
		Connection conn = null;
		List<User> ct = null;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			rowCount = ctdi.getUserListRowCount(one);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return rowCount;
	}
	
	public int getUserListPageCount(int pageSize, User one)
	{
		int pageCount = 0;
		Connection conn = null;
		List<User> ct = null;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			pageCount = ctdi.getUserListPageCount(pageSize, one);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return pageCount;
	}
	
	public List<User> getUserList(int pageSize, int pageNum, User us) {
		Connection conn = null;
		List<User> ct = null;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.getUserList(pageSize, pageNum, us);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserList: 事务提交失败");
			e.printStackTrace();
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return ct;
	}

	public boolean deleteUsers(int[] userIdList) throws Exception{
		Connection conn = null;
		boolean res = false;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res=ctdi.deleteUsers(userIdList);
			DBUtils.commit(conn);
		} catch (Exception e) {
			
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return res;
	}

	public boolean updateUser(User us) throws Exception {
		Connection conn = null;
		boolean res = false;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			res=ctdi.updateUser(us);
			DBUtils.commit(conn);
		} catch (Exception e) {
			
			DBUtils.rollBack(conn);
			System.out.println("update 事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return res;
	}
	
	public List<User> findDim(String key, Object obj) throws Exception {
		Connection conn = null;
		List<User> ct = null;
		try {

			conn = DBUtils.getConnection();
			UserDaoImpl ctdi = new UserDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.findDim(key, obj);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("getUserList: 事务提交失败");
			e.printStackTrace();
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return ct;
	}
}
