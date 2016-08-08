package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CityDaoImpl;
import com.neuedu.my12306.usermgr.domain.City;

public class CityService {
	private static final CityService instance = new CityService();

	public static CityService getInstance() {
		return instance;
	}

	private CityService() {

	}

	public List<City> getCityList(String id){
		Connection conn = null;
		List<City> ct = null;
		try {

			conn = DBUtils.getConnection();
			CityDaoImpl ctdi = new CityDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.getCityListByProID(id);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return ct;
	}

//	public City FindAccurate(String key, Object obj) throws Exception {
//		Connection conn = null;
//		// List<CertType> ct = null;
//		City ct = new City();
//		try {
//
//			conn = DBUtils.getConnection();
//			CityDaoImpl ctdi = new CityDaoImpl(conn);
//			DBUtils.beginTransaction(conn);
//			ct = ctdi.findAccurate(key, obj);
//			DBUtils.commit(conn);
//		} catch (Exception e) {
//			DBUtils.rollBack(conn);
//			System.out.println("事务提交失败");
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return ct;
//	}
//
//	public List<City> findDim(String key, Object obj) throws Exception
//	{
//		Connection conn = null;
//		// List<CertType> ct = null;
//		List<City> ct = null;
//		try {
//
//			conn = DBUtils.getConnection();
//			CityDaoImpl ctdi = new CityDaoImpl(conn);
//			DBUtils.beginTransaction(conn);
//			ct = ctdi.findDim(key, obj);
//			DBUtils.commit(conn);
//		} catch (Exception e) {
//			DBUtils.rollBack(conn);
//			System.out.println("事务提交失败");
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return ct;
//	}
//	
//	public boolean insertCity(City ct) throws Exception {
//		Connection conn = null;
//		boolean result = false;
//		try {
//
//			conn = DBUtils.getConnection();
//			CityDaoImpl ctdi = new CityDaoImpl(conn);
//			DBUtils.beginTransaction(conn);
//			result = ctdi.insertCity(ct);
//			DBUtils.commit(conn);
//		} catch (Exception e) {
//			DBUtils.rollBack(conn);
//			System.out.println("事务提交失败");
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return result;
//
//	}
//	
//	public boolean updateCity(City ct) throws Exception
//	{
//		Connection conn = null;
//		boolean result = false;
//		try {
//
//			conn = DBUtils.getConnection();
//			CityDaoImpl ctdi = new CityDaoImpl(conn);
//			DBUtils.beginTransaction(conn);
//			result = ctdi.updateCity(ct);
//			DBUtils.commit(conn);
//		} catch (Exception e) {
//			DBUtils.rollBack(conn);
//			System.out.println("事务提交失败");
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return result;
//	}
//	
//	public boolean deleteCity(String key, Object obj) throws Exception
//	{
//		Connection conn = null;
//		boolean result = false;
//		try {
//
//			conn = DBUtils.getConnection();
//			CityDaoImpl ctdi = new CityDaoImpl(conn);
//			DBUtils.beginTransaction(conn);
//			result = ctdi.deleteCity(key, obj);
//			DBUtils.commit(conn);
//		} catch (Exception e) {
//			DBUtils.rollBack(conn);
//			System.out.println("事务提交失败");
//		} finally {
//			DBUtils.closeConnection(conn);
//		}
//		return result;
//	}
}
