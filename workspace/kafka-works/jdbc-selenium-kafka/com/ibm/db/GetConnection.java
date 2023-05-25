package com.ibm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// helps you to connect with H2 
public class GetConnection {

	public Connection getH2Instance() {
		
		try {
			Class.forName("org.h2.Driver");
			String connString ="jdbc:h2:mem:testdb"; 
			Connection conn =  DriverManager.getConnection(connString + ";DB_CLOSE_DELAY=-1", "sa",""); 
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
