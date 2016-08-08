package com.neuedu.my12306.usermgr.test;

import java.util.Calendar;
//import java.util.Date;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;
import com.neuedu.my12306.usermgr.service.UserService;

public class TestUserService {

	UserService cs = UserService.getInstance();

//	 @Test
	public void TestGetUserListRowCount() throws Exception {
		User u = new User();// 什么都不填充，意味着所有用户
		System.out.println("表中总共有记录数：" + cs.getUserListRowCount(u));

	}

//	 @Test
	public void TestGetUserListPageCount() throws Exception {
		User u = new User();// 什么都不填充，意味着所有用户
		int page = 10;
		String info = "满足条件的记录数共有" + cs.getUserListRowCount(u) + "条"
				+ "\n";
		info += "若按每页显示" + page + "条计算，则总共有"
				+ cs.getUserListPageCount(page, u) + "页";
		System.out.println(info);
	}

//	 @Test
	public void testGetUserList() {
		// Assert.assertNotNull(service.getUserList(0, 0, new User()));
		// Assert.assertEquals(3, service.getUserList(10, 1, new
		// User()).size());
		for (User u : cs.getUserList(10, 1, new User())) {
			System.out.println(u.getRealname());
		}
//		 System.out.println(cs.getUserList(10, 1, new User()).size());
	}

//	 @Test
	public void testsave() throws Exception {
		User us = new User();
		us.setUsername("123");
		us.setPassword("1");
		us.setRule("1");
		us.setRealname("消亡");
		us.setSex("1");

		City city = new City();
		city.setId(1);
		city.setCity("北京市");
		us.setCity(city);

		CertType ct = new CertType();
		ct.setId(1);
		us.setCert_type(ct);

		us.setCert("422326");

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1995);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 03);
		us.setBirthday(c.getTime().toString());
		UserType ut = new UserType();
		ut.setId(1);
		us.setUser_type(ut);
		us.setContent("we");
		us.setStatus("7");
		us.setLogin_ip("0:0:0:0:0:0:0:1");
		us.setImage_path("D://");

		Assert.assertTrue(cs.save(us));
	}

//	@Test
	public void testlogin() throws Exception {
		User u = new User();
		u.setUsername("whx");
		u.setPassword("123");
		Assert.assertNotNull(cs.login(u));
	}

//	 @Test
	public void testfindUser() throws Exception {
		User us = new User();
		us.setId(13);
//		us.setUsername("xyy");
//		us.setPassword("1");
//		us.setRule("1");
//		us.setRealname("消亡");
//		us.setSex("1");
//
//		City city = new City();
//		city.setId(1);
//		city.setCity("北京市");
//		us.setCity(city);
//
//		CertType ct = new CertType();
//		ct.setId(1);
//		us.setCert_type(ct);
//		//
//		us.setCert("422326");
//		
//		 Calendar c = Calendar.getInstance();
//		 c.set(Calendar.YEAR, 1995);
//		 c.set(Calendar.MONTH, 11);
//		 c.set(Calendar.DATE, 03);
//		 us.setBirthday(c.getTime());
//		UserType ut = new UserType();
//		ut.setId(1);
//		us.setUser_type(ut);
//		us.setContent("we");
//		us.setStatus("7");
//		us.setLogin_ip("0:0:0:0:0:0:0:1");
//		us.setImage_path("D://");
		Assert.assertNotNull(cs.findUser(us));
	}
	 
//	@Test
	public void testDelete() throws Exception {
		int[] u = new int[2];
		u[0]=14;
		u[1] = 11;
		Assert.assertTrue(cs.deleteUsers(u));
	}
//	@Test
	public void testUpdate() throws Exception {
		User us = new User();
		us.setId(19);
		us.setUsername("z");
//		us.setPassword("1");
		us.setRule("1");
		us.setRealname("消亡");
		us.setSex("1");

		City city = new City();
		city.setId(1);
		city.setCity("北京市");
		us.setCity(city);

		CertType ct = new CertType();
		ct.setId(1);
		us.setCert_type(ct);

		us.setCert("422326");

		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1995);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.DATE, 03);
		us.setBirthday(c.getTime().toString());
		UserType ut = new UserType();
		ut.setId(1);
		us.setUser_type(ut);
		us.setContent("we");
		us.setStatus("7");
		us.setLogin_ip("0:0:0:0:0:0:0:1");
		us.setImage_path("D://");

		Assert.assertTrue(cs.updateUser(us));
	}
	
//	@Test
	public void testfindDim() throws Exception {
		List<User> u = cs.findDim("username", "a");
		Assert.assertNotNull(u);
		System.out.println(u.size());
	}
}
