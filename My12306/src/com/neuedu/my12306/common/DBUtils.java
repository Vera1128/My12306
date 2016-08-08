package com.neuedu.my12306.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtils {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/my12306?charset=utf8";
			String user = "root";
			String password = "123456";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("connecting is successed");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("class not found");
		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("sql connection is failed");
		}
		return conn;
	}
	
	public static void beginTransaction(Connection conn)
	{
		try
		{
			conn.setAutoCommit(false);
		}catch(SQLException e)
		{
			System.out.println("transaction failed");
		}
	}
	
	public static void  commit(Connection conn) {
		try
		{
			conn.commit();
			conn.setAutoCommit(true);
		}catch(SQLException e)
		{
			System.out.println("commit failed");
		}
	}
	
	public static void rollBack(Connection conn) {
		try
		{
			conn.rollback();
			conn.setAutoCommit(true);
		}catch(SQLException e)
		{
			System.out.println("rollBack failed");
		}
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("close failed");
		}
	}

	public static void closeStatement(Statement stm, ResultSet rs) {
		try {
			if (stm != null) {
				stm.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			System.out.println("Statement and ResultSet closed failed");
		}
	}
}
