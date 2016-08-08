package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.ProvinceDaoImpl;
import com.neuedu.my12306.usermgr.domain.Province;

public class ProvinceService {
	private static final ProvinceService instance = new ProvinceService();

	public static ProvinceService getInstance() {
		return instance;
	}

	private ProvinceService() {

	}

	public List<Province> getProvinceList(){
		Connection conn = null;
		List<Province> ct = null;
		try {

			conn = DBUtils.getConnection();
			ProvinceDaoImpl ctdi = new ProvinceDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.getProvinceList();
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
