package com.neuedu.my12306.usermgr.dao;

import java.util.List;
import com.neuedu.my12306.usermgr.domain.Province;

public interface ProvinceDao {
	List<Province> getProvinceList() throws Exception;

//	Province findAccurate(String key, Object obj) throws Exception;//
//
//	List<Province> findDim(String key, Object obj) throws Exception;
//
//	boolean insertProvince(Province pro) throws Exception;//
//
//	boolean updateProvince(Province pro) throws Exception;//
//
//	boolean deleteProvince(String key, Object obj) throws Exception;
}
