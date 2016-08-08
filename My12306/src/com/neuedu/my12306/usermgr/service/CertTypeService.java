package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.CertTypeDaoImpl;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeService {
	private static final CertTypeService instance = new CertTypeService();

	public static CertTypeService getInstance() {
		return instance;
	}

	private CertTypeService() {

	}

	public List<CertType> getCertTypeList() {
		Connection conn = null;
		List<CertType> ct = null;
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.getCertTypeList();
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			// DBUtils.closeConnection(conn);
		}
		return ct;
	}

	public CertType FindAccurate(String key, Object obj) throws Exception {
		Connection conn = null;
		// List<CertType> ct = null;
		CertType ct = new CertType();
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.findAccurate(key, obj);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return ct;
	}

	public List<CertType> findDim(String key, Object obj) throws Exception
	{
		Connection conn = null;
		// List<CertType> ct = null;
		List<CertType> ct = null;
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			ct = ctdi.findDim(key, obj);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return ct;
	}
	
	public boolean insertCertType(CertType ct) throws Exception {
		Connection conn = null;
		boolean result = false;
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			result = ctdi.insertCertType(ct);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return result;

	}
	
	public boolean updateCertType(CertType ct) throws Exception
	{
		Connection conn = null;
		boolean result = false;
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			result = ctdi.updateCertType(ct);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return result;
	}
	
	public boolean deleteCertType(String key, Object obj) throws Exception
	{
		Connection conn = null;
		boolean result = false;
		try {

			conn = DBUtils.getConnection();
			CertTypeDaoImpl ctdi = new CertTypeDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			result = ctdi.deleteCertType(key, obj);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("事务提交失败");
		} finally {
			DBUtils.closeConnection(conn);
		}
		return result;
	}
}
