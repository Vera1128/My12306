package com.neuedu.my12306.usermgr.dao;

import java.util.List;
import com.neuedu.my12306.usermgr.domain.User;

public interface UserDao {
	List<User> getUserList(int pageSize, int pageNum, User us) throws Exception;

	int save(User us) throws Exception;
	
	User login(User u) throws Exception;

	User findUser(User us) throws Exception;

	boolean deleteUsers(int[] userIdList) throws Exception;
	
	int getUserListRowCount(User one) throws Exception;
	
	int getUserListPageCount(int pageSize, User one) throws Exception;
	
	boolean updateUser(User us) throws Exception;

	List<User> findDim(String key, Object obj) throws Exception;
}
