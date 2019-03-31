package com.student.util;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
public class Config {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "password");
			System.out.println("connected");
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static String closeConnection() {
		try {
			con.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return("connection closed");
	}
	
}
