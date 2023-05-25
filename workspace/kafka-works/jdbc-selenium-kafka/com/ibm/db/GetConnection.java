package com.ibm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// helps you to connect with H2 
public class GetConnection {

	public Connection getH2Instance() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connString ="jdbc:mysql://localhost/ibmdb"; 
			Connection conn =  DriverManager.getConnection(connString , "root","kanchan@1"); 
			System.out.println("Connection successfull...");
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	  
	public static void main(String[] args) {
		
		System.out.println(new GetConnection().getH2Instance()); 
	}
}
