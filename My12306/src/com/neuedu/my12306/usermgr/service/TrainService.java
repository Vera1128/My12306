package com.neuedu.my12306.usermgr.service;

import java.sql.Connection;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.dao.TrainDaoImpl;
import com.neuedu.my12306.usermgr.domain.Train;

public class TrainService {
	private static final TrainService instance = new TrainService();
	public TrainService(){
		
	}	
	public static TrainService getInstance() {
		return instance;
	}
	
	public List<Train> getTrainList(String fromplace, String toplace, String date){
		Connection conn = null;
		List<Train> t = null;
		try {
			conn = DBUtils.getConnection();
			TrainDaoImpl tdi = new TrainDaoImpl(conn);
			DBUtils.beginTransaction(conn);
			t = tdi.getTrainList(fromplace, toplace, date);
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollBack(conn);
			System.out.println("service getTrainList error!");
		} finally {
			 DBUtils.closeConnection(conn);
		}
		return t;
	}
}
