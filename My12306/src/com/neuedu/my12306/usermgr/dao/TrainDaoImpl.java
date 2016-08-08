package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.Train;

public class TrainDaoImpl implements TrainDao {
    private Connection conn;
	public TrainDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Train> getTrainList(String fromplace, String toplace, String date){
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		String find_sql = "select * from tab_train where fromplace = '"+fromplace+"' and toplace='"+toplace+"' and date = '"+date+"'";
		ResultSet rs = null;
		List<Train> trainlist = new ArrayList<Train>();
		try {
			pstmt = conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Train one = new Train();	
				one.setId(rs.getInt("id"));
				one.setTrain_number(rs.getString("train_number"));
				one.setFromplace(rs.getString("fromplace"));
				one.setToplace(rs.getString("toplace"));
				one.setBegin(rs.getString("begin"));
				one.setEnd(rs.getString("end"));
				one.setPrice(rs.getDouble("price"));
				one.setDuration(rs.getString("duration"));
				one.setDate(rs.getString("date"));	
			    trainlist.add(one);
			}
		}catch(Exception e){
			System.out.println("getTrainList error!");
			e.printStackTrace();			
		}finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return trainlist;
		
	}
	
}
