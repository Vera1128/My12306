package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;

public class CertTypeDaoImpl implements CertTypeDao {
	private Connection conn;

	public CertTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<CertType> getCertTypeList() throws Exception {

		PreparedStatement pstmt = null;
		String find_sql = "select * from tab_certtype";
		ResultSet rs = null;
		List<CertType> certtypelist = new ArrayList<CertType>();
		try {
			pstmt = conn.prepareStatement(find_sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CertType one = new CertType();
				one.setId(rs.getInt("id"));
				one.setContent(rs.getNString("content"));
				certtypelist.add(one);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}

		return certtypelist;
	}

	@Override
	public CertType findAccurate(String key, Object obj) throws Exception {
		PreparedStatement pstmt = null;
		String find_sql = "select * from tab_certtype where " + key + " = ?";
		ResultSet rs = null;
		CertType one = null;
		try {
			pstmt = conn.prepareStatement(find_sql);
			one = new CertType();
			// pstmt.setString(1, key);
			pstmt.setObject(1, obj);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				one.setId(rs.getInt("id"));
				one.setContent(rs.getNString("content"));
				System.out.println("查找成功");
			} else
				System.out.println("查找失败");
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return one;
	}

	@Override
	public List<CertType> findDim(String key, Object obj) throws Exception {
		PreparedStatement pstmt = null;
		List<CertType> certtypelist = new ArrayList<CertType>();
		
		
		String find_sql = "select * from tab_certtype where " + key + " like ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(find_sql);
			// pstmt.setString(1, key);
			pstmt.setObject(1, "%" + obj + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CertType one = new CertType();
				one.setId(rs.getInt("ID"));
				one.setContent(rs.getNString("content"));
				certtypelist.add(one);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return certtypelist;
	}

	@Override
	public boolean insertCertType(CertType ct) throws Exception {
		
		int i = 0;		
		if(findAccurate("content", ct.getContent()) == null)
		{
			String insert_sql = "insert into tab_certtype(content) " + "values(?)";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(insert_sql);
				// pstmt.setInt(1, ct.getId());
				pstmt.setString(1, ct.getContent());
				i = pstmt.executeUpdate();
			} finally {
				DBUtils.closeStatement(pstmt, null);
			}
		}
		else
		{
			System.out.println("this certtype has been existed!");
		}
		
		return i != 0 ? true : false;
	}

	@Override
	public boolean updateCertType(CertType ct) throws Exception {
		int i = 0;
		if(findAccurate("id", ct.getId()) != null)
		{
			String insert_sql = "update tab_certtype set content = ? where id = ?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(insert_sql);
				pstmt.setString(1, ct.getContent());
				pstmt.setInt(2, ct.getId());
				i = pstmt.executeUpdate();
			} finally {
				DBUtils.closeStatement(pstmt, null);
			}
		}
		else
			System.out.println("this certtype is not existed!");
		return i != 0 ? true : false;
	}

	@Override
	public boolean deleteCertType(String key, Object obj) throws Exception {
		int i = 0;
		if((findAccurate(key, obj)) != null)
		{
			String insert_sql = "delete from tab_certtype where " + key + " = ?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(insert_sql);
				//pstmt.setString(1, key);
				pstmt.setObject(1, obj);
				i = pstmt.executeUpdate();
			} finally {
				DBUtils.closeStatement(pstmt, null);
			}
		}
		else
			System.out.println("this certtype is not existed!");
		return i != 0 ? true : false;
	}
}
