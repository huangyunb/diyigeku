package com.example.couple.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBHelper {
	private static String url = "jdbc:mysql://localhost:3306/szys";
	private static String user = "root";
	private static String password = "123456";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("---�������سɹ�-----");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		try{
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
