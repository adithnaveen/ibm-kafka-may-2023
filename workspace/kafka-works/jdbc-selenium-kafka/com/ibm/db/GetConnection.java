package com.ibm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// helps you to connect with H2 
public class GetConnection {

	public Connection getH2Instance() {
		
		try {
			Class.forName("org.h2.Driver"); 
			Connection conn =  DriverManager.getConnection("jdbc:h2:~/testdb", "sa",""); 
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new GetConnection().getH2Instance() != null); 
	}
}
