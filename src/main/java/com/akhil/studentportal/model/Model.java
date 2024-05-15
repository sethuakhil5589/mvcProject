package com.akhil.studentportal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.*;

@Data
@Setter
public class Model {
	
	
	private String studentId;
	private String studentName;
	private String studentAge;
	private String studentCity;
	private String password;
	private int row;
	
	public int getRow() {
		return row;
	}
	

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String stdId) {
		this.studentId = stdId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void register() {
		Connection connect=null;
		String query="INSERT INTO studentportal (id,name,age,city,password) "
				+ "VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		studentId=getStudentId();
		studentName=getStudentName();
		studentAge=getStudentAge();
		studentCity=getStudentCity();
		password=getPassword();
		System.out.println(studentId+" "+studentName+" "+studentAge+" ");
		
		JDBCUtility utility=new JDBCUtility();
		try {
			connect=utility.jdbcConnection();
			System.out.println("connection");
			if(connect!=null){
				pstmt=connect.prepareStatement(query);
				if(pstmt!=null){
					pstmt.setString(1, studentId);
					pstmt.setString(2, studentName);
					pstmt.setString(3, studentAge);
					pstmt.setString(4, studentCity);
					pstmt.setString(5, password);
					System.out.println("Pstmt executed");
					row=pstmt.executeUpdate();
					System.out.println("row at pstmt execution"+row);
					
			}
			}
			
		} catch (SQLException e) {
			System.out.println("Sql Exception");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Some other Exception");
			e.printStackTrace();
		}
		finally {
			try {
				utility.closeResources(connect, pstmt, null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void login() {
		Connection connect=null;
		String query="SELECT * FROM studentportal";
		PreparedStatement pstmt=null;
		JDBCUtility utility=new JDBCUtility();
		
		try {
			connect=utility.jdbcConnection();
			System.out.println("Connection");
			if(connect!=null) {
				 pstmt=connect.prepareStatement(query);
				 if(pstmt!=null) {
					
					 ResultSet rs = pstmt.executeQuery();
					 System.out.println("Query executed");
					 while(rs.next()) {
						 studentName=rs.getString("name");
						 password=rs.getString("password");
					 }
					 System.out.println(studentName+password);
					 
				 }
			}
		} catch (SQLException e) {
			System.out.println("Sql Exception");
			e.printStackTrace();
		}
		catch (Exception e) {
			System.out.println("Some other Exception");
			e.printStackTrace();
		}
	}
}
