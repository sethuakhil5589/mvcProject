package com.akhil.studentportal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtility {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		System.out.println("Connection was established");
	}
	
	public static Connection jdbcConnection() throws SQLException {
		String url="jdbc:mysql://localhost:3306/mvcproject";
		String user="root";
		String password="Akhil@5589";

		return DriverManager.getConnection(url, user, password);
		
	}
	public static void closeResources(Connection c ,Statement stmt, ResultSet rs) throws SQLException {
		if(c!=null)
			c.close();
		if(stmt!=null)
			stmt.close();
		if(rs!=null)
			rs.close();
	}
}
