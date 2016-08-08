package com.neuedu.my12306.usermgr.dao;

import java.util.List;
import com.neuedu.my12306.usermgr.domain.City;

public interface CityDao {
//	List<City> getCityList() throws Exception;
//
//	City findAccurate(String key, Object obj) throws Exception;//
//
//	List<City> findDim(String key, Object obj) throws Exception;
//
//	boolean insertCity(City cty) throws Exception;//
//
//	boolean updateCity(City cty) throws Exception;//
//
//	boolean deleteCity(String key, Object obj) throws Exception;
	
	List<City> getCityListByProID(String id) throws Exception;
	
}
