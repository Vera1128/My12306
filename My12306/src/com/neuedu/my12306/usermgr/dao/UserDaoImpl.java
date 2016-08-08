package com.neuedu.my12306.usermgr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.neuedu.my12306.common.DBUtils;
import com.neuedu.my12306.usermgr.domain.CertType;
import com.neuedu.my12306.usermgr.domain.City;
import com.neuedu.my12306.usermgr.domain.Province;
import com.neuedu.my12306.usermgr.domain.User;
import com.neuedu.my12306.usermgr.domain.UserType;

public class UserDaoImpl implements UserDao {
	private Connection conn;

	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int save(User us) {
		int i = 0, idx = 1;
		String insert_sql = "insert into tab_user(username,password,rule,"
				+ "realname,sex,city,cert_type,"
				+ "cert,birthday,user_type,content,"
				+ "status,login_ip,image_path) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// String insert_sql = "insert into tab_user(username,password) " +
		// "values(?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(insert_sql);
			pstmt.setString(idx, us.getUsername());
			pstmt.setString(++idx, us.getPassword());
			pstmt.setString(++idx, us.getRule());

			pstmt.setString(++idx, us.getRealname());
			pstmt.setString(++idx, us.getSex());
			pstmt.setInt(++idx, us.getCity().getId());
			pstmt.setInt(++idx, us.getCert_type().getId());

			pstmt.setString(++idx, us.getCert());
			// pstmt.setString(++idx, us.getBirthday());
			pstmt.setString(++idx, us.getBirthday());
			System.out.println(us.getBirthday());
			pstmt.setInt(++idx, us.getCert_type().getId());
			pstmt.setString(++idx, us.getContent());

			pstmt.setString(++idx, us.getStatus());
			pstmt.setString(++idx, us.getLogin_ip());
			pstmt.setString(++idx, us.getImage_path());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt, null);
		}
		return i;
	}

	@Override
	public User login(User u) throws Exception {
		User one = null;
		PreparedStatement pstmt = null;
		// String find_sql =
		// "select * from tab_user where userName = ? and password = ?";
		StringBuffer find_sql = new StringBuffer();
		find_sql.append("select u.*, ");
		find_sql.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		find_sql.append("ct.id ctid, ct.content ctcontent, ");
		find_sql.append("ut.id utid, ut.content utcontent, ");
		find_sql.append("p.id pid, p.provinceid pprovinceid, p.province pprovince ");
		find_sql.append("from tab_user u, tab_city c, tab_certtype ct, tab_usertype ut, tab_province p ");
		find_sql.append("where c.id = u.city AND ct.id = u.cert_type AND "
				+ "u.user_type = ut.id AND c.father = p.provinceid ");
		find_sql.append("ANd username = ? and password = ?");

		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(find_sql.toString());
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				one = new User();
				// us.setId(rs.getInt("id"));
				// us.setUsername(rs.getString("username"));
				// us.setPassword(rs.getNString("password"));
				one = new User();
				one.setId(rs.getInt("id"));
				one.setUsername(rs.getString("username"));
				one.setPassword(rs.getString("password"));
				one.setRule(rs.getString("rule"));
				one.setRealname(rs.getString("realname"));
				one.setSex(rs.getString("sex"));
				one.setCert(rs.getString("cert"));
				one.setBirthday(rs.getString("birthday"));
				one.setContent(rs.getString("content"));
				one.setStatus(rs.getString("status"));
				one.setLogin_ip(rs.getString("login_ip"));
				one.setImage_path(rs.getString("image_path"));
				one.setPassword(rs.getNString("password"));

				Province p = new Province();
				p.setId(rs.getInt("pid"));
				p.setProvinceid(rs.getString("pprovinceid"));
				p.setProvince(rs.getString("pprovince"));

				City c = new City();
				c.setId(rs.getInt("cid"));
				c.setCity(rs.getString("ccity"));
				c.setCityid(rs.getString("ccityid"));
				c.setFather(p);

				UserType ut = new UserType();
				ut.setId(rs.getInt("utid"));
				ut.setContent(rs.getString("utcontent"));

				CertType ct = new CertType();
				ct.setId(rs.getInt("ctid"));
				ct.setContent(rs.getString("ctcontent"));

				one.setCert_type(ct);
				one.setCity(c);
				one.setUser_type(ut);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return one;
	}

	@Override
	public User findUser(User us) throws Exception {
		User one = null;
		boolean tag = false;

		StringBuffer str = new StringBuffer();
		str.append("select u.*, ");
		str.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		str.append("ct.id ctid, ct.content ctcontent, ");
		str.append("ut.id utid, ut.content utcontent, ");
		str.append("p.id pid, p.provinceid pprovinceid, p.province pprovince ");
		str.append("from tab_user u, tab_city c, tab_certtype ct, tab_usertype ut, tab_province p ");
		str.append("where c.id = u.city AND ct.id = u.cert_type AND "
				+ "u.user_type = ut.id AND c.father = p.provinceid ");

		
		if (us.getId() != null ) {///////
			str.append(" AND u.id='" + us.getId() + "'");
			tag = true;
		}
		if (us.getUsername() != null && !us.getUsername().isEmpty()) {
			str.append(" AND u.username='" + us.getUsername() + "'");
			tag = true;
		}
		if (us.getRule() != null && !us.getRule().isEmpty()) {
			str.append(" AND u.rule = '" + us.getRule() + "'");
			tag = true;
		}
		if (us.getSex() != null && !us.getSex().isEmpty()) {
			str.append(" AND u.sex = '" + us.getSex() + "'");
			tag = true;
		}
		if (us.getRealname() != null && !us.getRealname().isEmpty()) {
			str.append(" AND u.realname = '" + us.getRealname() + "'");
			tag = true;
		}
		if (us.getCity() != null && us.getCity().getId() != 0)// //
		{
			str.append(" AND u.city = " + us.getCity().getId());
			tag = true;
		}
		if (us.getCert_type() != null && us.getCert_type().getId() != 0)// //
		{
			str.append(" AND u.cert_type = " + us.getCert_type().getId());
			tag = true;
		}
		if (us.getCert() != null && !us.getCert().isEmpty()) {
			str.append(" AND u.cert_type = '" + us.getCert() + "'");
			tag = true;
		}
		// if(us.getBirthday() != null && !us.getCert().isEmpty())////////
		// {
		// str.append(" AND u.birthday = '" + us.getBirthday().toString() +
		// "'");
		// tag = true;
		// }
		if (us.getUser_type() != null && us.getUser_type().getId() != 0) {
			str.append(" AND u.user_type = " + us.getUser_type().getId());
			tag = true;
		}
		if (us.getContent() != null && !us.getContent().isEmpty()) {
			str.append(" AND u.content = '" + us.getContent() + "'");
			tag = true;
		}
		if (us.getStatus() != null && !us.getStatus().isEmpty()) {
			str.append(" AND u.status = '" + us.getStatus() + "'");
		}
		if (us.getLogin_ip() != null && !us.getLogin_ip().isEmpty()) {
			str.append(" AND u.login_ip = '" + us.getLogin_ip() + "'");
			tag = true;
		}
		if (us.getImage_path() != null && !us.getImage_path().isEmpty()) {
			str.append(" AND u.image_path = '" + us.getImage_path() + "'");
			tag = true;
		}

		// 若没有查询条件则返回对象为null
		if (!tag) {
			return null;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				one = new User();
				one.setId(rs.getInt("id"));
				one.setUsername(rs.getString("username"));
				one.setPassword(rs.getString("password"));
				one.setRule(rs.getString("rule"));
				one.setRealname(rs.getString("realname"));
				one.setSex(rs.getString("sex"));
				one.setCert(rs.getString("cert"));
				one.setBirthday(rs.getString("birthday"));
				one.setContent(rs.getString("content"));
				one.setStatus(rs.getString("status"));
				one.setLogin_ip(rs.getString("login_ip"));
				one.setImage_path(rs.getString("image_path"));
				one.setPassword(rs.getNString("password"));

				Province p = new Province();
				p.setId(rs.getInt("pid"));
				p.setProvinceid(rs.getString("pprovinceid"));
				p.setProvince(rs.getString("pprovince"));

				City c = new City();
				c.setId(rs.getInt("cid"));
				c.setCity(rs.getString("ccity"));
				c.setCityid(rs.getString("ccityid"));
				c.setFather(p);

				UserType ut = new UserType();
				ut.setId(rs.getInt("utid"));
				ut.setContent(rs.getString("utcontent"));

				CertType ct = new CertType();
				ct.setId(rs.getInt("ctid"));
				ct.setContent(rs.getString("ctcontent"));

				one.setCert_type(ct);
				one.setCity(c);
				one.setUser_type(ut);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return one;
	}

	@Override
	public int getUserListRowCount(User one) throws Exception {
		int rowCount = 0;
		User us = null;
		boolean tag = false;

		StringBuffer str = new StringBuffer();
		str.append("select count(*)");
		str.append("from tab_user u, tab_city c, tab_certtype ct, tab_usertype ut, tab_province p ");
		str.append("where c.id = u.city AND ct.id = u.cert_type AND "
				+ "u.user_type = ut.id AND c.father = p.provinceid ");

		if (one.getId() != null && one.getId() != 0) {
			str.append(" AND u.id=" + one.getId());
			tag = true;
		}
		if (one.getUsername() != null && !one.getUsername().isEmpty()) {
			str.append(" AND u.username='" + one.getUsername() + "'");
			tag = true;
		}
		if (one.getPassword() != null && !one.getPassword().isEmpty()) {
			str.append(" AND u.password='" + one.getPassword() + "'");
			tag = true;
		}
		if (one.getRule() != null && !one.getRule().isEmpty()) {
			str.append(" AND u.rule = '" + one.getRule() + "'");
			tag = true;
		}
		if (one.getSex() != null && !one.getSex().isEmpty()) {
			str.append(" AND u.sex = '" + one.getSex() + "'");
			tag = true;
		}
		if (one.getRealname() != null && !one.getRealname().isEmpty()) {
			str.append(" AND u.realname = '" + one.getRealname() + "'");
			tag = true;
		}
		if (one.getCity() != null && one.getCity().getId() != 0)// //
		{
			str.append(" AND u.city = " + one.getCity().getId());
			tag = true;
		}
		if (one.getCert_type() != null && one.getCert_type().getId() != 0)// //
		{
			str.append(" AND u.cert_type = " + one.getCert_type().getId());
			tag = true;
		}
		if (one.getCert() != null && !one.getCert().isEmpty()) {
			str.append(" AND u.cert_type = '" + one.getCert() + "'");
			tag = true;
		}
		// if (one.getCert() != null && !one.getCert().isEmpty()) {
		// str.append(" AND u.cert_type = '" + one.getCert_type().getId() +
		// "'");
		// tag = true;
		// }
		// if(one.getBirthday() != null && !one.getCert().isEmpty())////////
		// {
		// str.append(" AND u.birthday = '" + one.getBirthday().toString() +
		// "'");
		// tag = true;
		// }
		if (one.getUser_type() != null && one.getUser_type().getId() != 0) {
			str.append(" AND u.user_type = " + one.getUser_type().getId());
			tag = true;
		}
		if (one.getContent() != null && !one.getContent().isEmpty()) {
			str.append(" AND u.content = '" + one.getContent() + "'");
			tag = true;
		}
		if (one.getStatus() != null && !one.getStatus().isEmpty()) {
			str.append(" AND u.status = '" + one.getStatus() + "'");
		}
		if (one.getLogin_ip() != null && !one.getLogin_ip().isEmpty()) {
			str.append(" AND u.login_ip = '" + one.getLogin_ip() + "'");
			tag = true;
		}
		if (one.getImage_path() != null && !one.getImage_path().isEmpty()) {
			str.append(" AND u.image_path = '" + one.getImage_path() + "'");
			tag = true;
		}

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return rowCount;
	}

	@Override
	public int getUserListPageCount(int pageSize, User one) throws Exception {
		int res = 0;
		int rowCount = getUserListRowCount(one);
		if (rowCount % pageSize == 0)
			res = rowCount / pageSize;
		else
			res = rowCount / pageSize + 1;
		return res;
	}

	@Override
	public List<User> getUserList(int pageSize, int pageNum, User us)
			throws Exception {

		List<User> list = new ArrayList<User>();
		User one = null;
		// boolean tag = false;
		StringBuffer str = new StringBuffer();
		str.append("select u.*, ");
		str.append("c.id cid, c.cityid ccityid, c.city ccity, c.father cfather, ");
		str.append("ct.id ctid, ct.content ctcontent, ");
		str.append("ut.id utid, ut.content utcontent, ");
		str.append("p.id pid, p.provinceid pprovinceid, p.province pprovince ");
		str.append("from tab_user u, tab_city c, tab_certtype ct, tab_usertype ut, tab_province p ");
		str.append("where c.id = u.city AND ct.id = u.cert_type AND "
				+ "u.user_type = ut.id AND c.father = p.provinceid ");

		if (us.getId() != null && us.getId() != 0) {
			str.append(" AND u.id=" + us.getId());
			// tag = true;
		}
		if (us.getUsername() != null && !us.getUsername().isEmpty()) {
			str.append(" AND u.username='" + us.getUsername() + "'");
			// tag = true;
		}
		if (us.getRule() != null && !us.getRule().isEmpty()) {
			str.append(" AND u.rule = '" + us.getRule() + "'");
			// tag = true;
		}
		if (us.getSex() != null && !us.getSex().isEmpty()) {
			str.append(" AND u.sex = '" + us.getSex() + "'");
			// tag = true;
		}
		if (us.getRealname() != null && !us.getRealname().isEmpty()) {
			str.append(" AND u.realname = '" + us.getRealname() + "'");
			// tag = true;
		}
		if (us.getCity() != null && us.getCity().getId() != 0)// //
		{
			str.append(" AND u.city = " + us.getCity().getId());
			// tag = true;
		}
		if (us.getCert_type() != null && us.getCert_type().getId() != 0)// //
		{
			str.append(" AND u.cert_type = " + us.getCert_type().getId());
			// tag = true;
		}
		if (us.getCert() != null && !us.getCert().isEmpty()) {
			str.append(" AND u.cert_type = '" + us.getCert() + "'");
			// tag = true;
		}
		// if(us.getBirthday() != null && !us.getCert().isEmpty())////////
		// {
		// str.append(" AND u.birthday = '" + us.getBirthday().toString() +
		// "'");
		// tag = true;
		// }
		if (us.getUser_type() != null && us.getUser_type().getId() != 0) {
			str.append(" AND u.user_type = " + us.getUser_type().getId());
			// tag = true;
		}
		if (us.getContent() != null && !us.getContent().isEmpty()) {
			str.append(" AND u.content = '" + us.getContent() + "'");
			// tag = true;
		}
		if (us.getStatus() != null && !us.getStatus().isEmpty()) {
			str.append(" AND u.status = '" + us.getStatus() + "'");
		}
		if (us.getLogin_ip() != null && !us.getLogin_ip().isEmpty()) {
			str.append(" AND u.login_ip = '" + us.getLogin_ip() + "'");
			// tag = true;
		}
		if (us.getImage_path() != null && !us.getImage_path().isEmpty()) {
			str.append(" AND u.image_path = '" + us.getImage_path() + "'");
			// tag = true;
		}

		// 若没有查询条件则返回对象为null
		// if (!tag) {
		// return null;
		// }

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				one = new User();
				one.setId(rs.getInt("id"));
				one.setUsername(rs.getString("username"));
				one.setPassword(rs.getString("password"));
				one.setRule(rs.getString("rule"));
				one.setRealname(rs.getString("realname"));
				one.setSex(rs.getString("sex"));
				one.setCert(rs.getString("cert"));
				// one.setBirthday(rs.getDate("birthday"));
				one.setContent(rs.getString("content"));
				one.setStatus(rs.getString("status"));
				one.setLogin_ip(rs.getString("login_ip"));
				one.setImage_path(rs.getString("image_path"));
				one.setPassword(rs.getNString("password"));

				Province p = new Province();
				p.setId(rs.getInt("pid"));
				p.setProvinceid(rs.getString("pprovinceid"));
				p.setProvince(rs.getString("pprovince"));

				City c = new City();
				c.setId(rs.getInt("cid"));
				c.setCity(rs.getString("ccity"));
				c.setCityid(rs.getString("ccityid"));
				c.setFather(p);

				UserType ut = new UserType();
				ut.setId(rs.getInt("utid"));
				ut.setContent(rs.getString("utcontent"));

				CertType ct = new CertType();
				ct.setId(rs.getInt("ctid"));
				ct.setContent(rs.getString("ctcontent"));

				one.setCert_type(ct);
				one.setCity(c);
				one.setUser_type(ut);
				list.add(one);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt, rs);

		}
		return list;
	}

	@Override
	public boolean updateUser(User us) throws Exception {
		int i = 0;
		boolean tag = false;
		StringBuffer str = new StringBuffer("update tab_user set ");

		if (us.getUsername() != null && !us.getUsername().isEmpty()) {
			str.append(" username='" + us.getUsername() + "'");
			tag = true;
		}
		if (us.getRule() != null && !us.getRule().isEmpty()) {
			str.append(", rule = '" + us.getRule() + "'");
			tag = true;
		}
		if (us.getSex() != null && !us.getSex().isEmpty()) {
			str.append(", sex = '" + us.getSex() + "'");
			tag = true;
		}
		if (us.getRealname() != null && !us.getRealname().isEmpty()) {
			str.append(", realname = '" + us.getRealname() + "'");
			tag = true;
		}
		if (us.getCity() != null && us.getCity().getId() != 0)// //
		{
			str.append(", city = " + us.getCity().getId());
			tag = true;
		}
		if (us.getCert_type() != null && us.getCert_type().getId() != 0)// //
		{
			str.append(", cert_type = " + us.getCert_type().getId());
			tag = true;
		}
		if (us.getCert() != null && !us.getCert().isEmpty()) {
			str.append(", cert = '" + us.getCert() + "'");
			tag = true;
		}
		 if(us.getBirthday() != null && !us.getCert().isEmpty())////////
		 {
			 str.append(", birthday = '" + us.getBirthday() + "'");
			 tag = true;
		 }
		if (us.getUser_type() != null && us.getUser_type().getId() != 0) {
			str.append(", user_type = " + us.getUser_type().getId());
			tag = true;
		}
		if (us.getContent() != null && !us.getContent().isEmpty()) {
			str.append(", content = '" + us.getContent() + "'");
			tag = true;
		}
		if (us.getStatus() != null && !us.getStatus().isEmpty()) {
			str.append(" , status = '" + us.getStatus() + "'");
		}
		if (us.getLogin_ip() != null && !us.getLogin_ip().isEmpty()) {
			str.append(" , login_ip = '" + us.getLogin_ip() + "'");
			tag = true;
		}
		if (us.getImage_path() != null && !us.getImage_path().isEmpty()) {
			str.append(", image_path = '" + us.getImage_path() + "'");
			tag = true;
		}
		str.append("where id=" + us.getId());
		// 若没有查询条件则返回对象为null
		if (!tag) {
			return false;
		}

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(str.toString());
//			pstmt.setString(1, us.getContent());
			i = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			DBUtils.closeStatement(pstmt, null);
		}
		return i != 0 ? true : false;
	}

	@Override
	public boolean deleteUsers(int[] userIdList) throws Exception {
		int i = 0;
		String param = Arrays.toString(userIdList).replace("[", "(")
				.replace("]", ")");
		String insert_sql = "delete from tab_user where id in " + param;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(insert_sql);
			i = pstmt.executeUpdate();
		} finally {
			DBUtils.closeStatement(pstmt, null);
		}
		return i != 0 ? true : false;
	}

	@Override
	public List<User> findDim(String key, Object obj) throws Exception {
		PreparedStatement pstmt = null;
		List<User> Userlist = new ArrayList<User>();
		
		
		String find_sql = "select * from tab_user where " + key + " like ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(find_sql);
			// pstmt.setString(1, key);
			pstmt.setObject(1, "%" + obj + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User one = new User();
				one.setId(rs.getInt("id"));
				one.setUsername(rs.getNString("username"));
				Userlist.add(one);
			}
		} finally {
			DBUtils.closeStatement(pstmt, rs);
		}
		return Userlist;
	}
}

// if (us.getUsername() != null && !us.getUsername().isEmpty()) {
// str.append(" username=" + us.getUsername());
// tag = true;
// }
// if (us.getPassword() != null && !us.getPassword().isEmpty()) {
// str.append(", password=" + us.getPassword());
// tag = true;
// }
// if (us.getRule() != null && !us.getRule().isEmpty()) {
// str.append(", rule = " + us.getRule());
// tag = true;
// }
// if (us.getSex() != null && !us.getSex().isEmpty()) {
// str.append(", u.sex = " + us.getSex());
// tag = true;
// }
// if (us.getRealname() != null && !us.getRealname().isEmpty()) {
// str.append(", u.realname = " + us.getRealname());
// tag = true;
// }
// if (us.getCity() != null && us.getCity().getId() != 0)// //
// {
// str.append(", u.city = " + us.getCity().getId());
// tag = true;
// }
// if (us.getCert_type() != null && us.getCert_type().getId() != 0)// //
// {
// str.append(", u.cert_type = " + us.getCert_type().getId());
// tag = true;
// }
// if (us.getCert() != null && !us.getCert().isEmpty()) {
// str.append(", u.cert_type = " + us.getCert());
// tag = true;
// }
// // if (us.getBirthday() != null && !us.getCert().isEmpty())// //////
// // {
// // str.append(", u.birthday = " + us.getBirthday());
// // tag = true;
// // }
// if (us.getUser_type() != null && us.getUser_type().getId() != 0) {
// str.append(", u.user_type = " + us.getUser_type().getId());
// tag = true;
// }
// if (us.getContent() != null && !us.getContent().isEmpty()) {
// str.append(", u.content = " + us.getContent());
// tag = true;
// }
// if (us.getStatus() != null && !us.getStatus().isEmpty()) {
// str.append(", u.status = " + us.getStatus());
// }
// if (us.getLogin_ip() != null && !us.getLogin_ip().isEmpty()) {
// str.append(", u.login_ip = " + us.getLogin_ip());
// tag = true;
// }
// if (us.getImage_path() != null && !us.getImage_path().isEmpty()) {
// str.append(", u.image_path = " + us.getImage_path());
// tag = true;
// }
