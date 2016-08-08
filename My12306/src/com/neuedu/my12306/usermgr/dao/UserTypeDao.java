package com.neuedu.my12306.usermgr.dao;

import java.util.List;
import com.neuedu.my12306.usermgr.domain.UserType;

public interface UserTypeDao {
	List<UserType> getUserTypeList() throws Exception;

//	UserType findAccurate(String key, Object obj) throws Exception;//
//
//	List<UserType> findDim(String key, Object obj) throws Exception;
//
//	boolean insertUserType(UserType ut) throws Exception;//
//
//	boolean updateUserType(UserType ut) throws Exception;//
//
//	boolean deleteUserType(String key, Object obj) throws Exception;
}
