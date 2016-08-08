package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;

public class CityDaoImpl implements CityDao {
	private Connection conn;

	public CityDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<City> getCityListByProID(String id) throws Exception {
		PreparedStatement pstmt = null;
		String find_sql = "select c.*, p.id pid, p.provinceid pprovinceid, p.province pprovince from tab_city c, tab_province p where father = provinceid and father = ?";
		ResultSet rs = null;
		List<City> citylist = new ArrayList<City>();
		try {
			pstmt = conn.prepareStatement(find_sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				City one = new City();
				one.setId(rs.getInt("id"));
				one.setCityid(rs.getString("cityid"));
				one.setCity(rs.getNString("city"));
				Province p = new Province();
				p.setId(rs.getInt("pid"));
				p.setProvinceid(rs.getString("pprovinceid"));
				p.setProvince(rs.getString("pprovince"));
				one.setFather(p);
				citylist.add(one);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}

		return citylist;
	}
	
//	@Override
//	public List<City> getCityList() throws Exception {
//		PreparedStatement pstmt = null;
//		String find_sql = "select * from tab_city";
//		ResultSet rs = null;
//		List<City> citylist = new ArrayList<City>();
//		try {
//			pstmt = conn.prepareStatement(find_sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				City one = new City();
//				one.setId(rs.getInt("id"));
//				one.setCityid(rs.getString("cityid"));
//				one.setCity(rs.getNString("city"));
//				one.setCity(rs.getNString("father"));
//				citylist.add(one);
//			}
//		} finally {
//			DBUtils.closeStatement(pstmt, rs);
//		}
//
//		return citylist;
//	}
//
//	@Override
//	public City findAccurate(String key, Object obj) throws Exception {
//		PreparedStatement pstmt = null;
//		String find_sql = "select * from tab_city where " + key + " = ?";
//		ResultSet rs = null;
//		City one = null;
//		try {
//			pstmt = conn.prepareStatement(find_sql);
//			one = new City();
//			// pstmt.setString(1, key);
//			pstmt.setObject(1, obj);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				one.setId(rs.getInt("id"));
//				one.setCityid(rs.getString("cityid"));
//				one.setCity(rs.getNString("city"));
//				one.setCity(rs.getNString("father"));
//				System.out.println("查找成功");
//			} else
//				System.out.println("查找失败");
//		} finally {
//			DBUtils.closeStatement(pstmt, rs);
//		}
//		return one;
//	}
//
//	@Override
//	public List<City> findDim(String key, Object obj) throws Exception {
//		PreparedStatement pstmt = null;
//		List<City> certtypelist = new ArrayList<City>();
//		
//		
//		String find_sql = "select * from tab_city where " + key + " like ?";
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(find_sql);
//			// pstmt.setString(1, key);
//			pstmt.setObject(1, "%" + obj + "%");
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				City one = new City();
//				one.setId(rs.getInt("id"));
//				one.setCityid(rs.getString("cityid"));
//				one.setCity(rs.getNString("city"));
//				one.setCity(rs.getNString("father"));
//				certtypelist.add(one);
//			}
//		} finally {
//			DBUtils.closeStatement(pstmt, rs);
//		}
//		return certtypelist;
//	}
	
//	@Override
//	public boolean insertCity(City cty) throws Exception {
//		
//		int i = 0;		
//		if(findAccurate("city", cty.getCity()) == null)
//		{
//			String insert_sql = "insert into tab_city(cityid,city,father) " + "values(?,?,?)";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(insert_sql);
//				// pstmt.setInt(1, cty.getId());
//				pstmt.setString(1, cty.getCityid());
//				pstmt.setString(2, cty.getCity());
//				pstmt.setString(3, cty.getFather());
//				i = pstmt.executeUpdate();
//			} finally {
//				DBUtils.closeStatement(pstmt, null);
//			}
//		}
//		else
//		{
//			System.out.println("this city has been existed!");
//		}
//		
//		return i != 0 ? true : false;
//	}
//
//	@Override
//	public boolean updateCity(City cty) throws Exception {
//		int i = 0;
//		if(findAccurate("id", cty.getId()) != null)
//		{
//			String insert_sql = "update tab_city set city = ?, cityid = ?, father = ? where id = ?";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(insert_sql);
//				pstmt.setString(1, cty.getCity());
//				pstmt.setString(2, cty.getCityid());
//				pstmt.setString(3, cty.getFather());
//				pstmt.setInt(4,cty.getId());
//				i = pstmt.executeUpdate();
//			} finally {
//				DBUtils.closeStatement(pstmt, null);
//			}
//		}
//		else
//			System.out.println("this city is not existed!");
//		return i != 0 ? true : false;
//	}
//
//	@Override
//	public boolean deleteCity(String key, Object obj) throws Exception {
//		int i = 0;
//		if((findAccurate(key, obj)) != null)
//		{
//			String insert_sql = "delete from tab_city where " + key + " = ?";
//			PreparedStatement pstmt = null;
//			try {
//				pstmt = conn.prepareStatement(insert_sql);
//				//pstmt.setString(1, key);
//				pstmt.setObject(1, obj);
//				i = pstmt.executeUpdate();
//			} finally {
//				DBUtils.closeStatement(pstmt, null);
//			}
//		}
//		else
//			System.out.println("this city is not existed!");
//		return i != 0 ? true : false;
//	}

}
