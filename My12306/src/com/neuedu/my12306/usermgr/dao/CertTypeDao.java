package com.neuedu.my12306.usermgr.dao;

import java.util.List;

import com.neuedu.my12306.usermgr.domain.CertType;

public interface CertTypeDao {
	List<CertType> getCertTypeList() throws Exception;

	CertType findAccurate(String key, Object obj) throws Exception;//

	List<CertType> findDim(String key, Object obj) throws Exception;

	boolean insertCertType(CertType ct) throws Exception;//

	boolean updateCertType(CertType ct) throws Exception;//

	boolean deleteCertType(String key, Object obj) throws Exception;
}
