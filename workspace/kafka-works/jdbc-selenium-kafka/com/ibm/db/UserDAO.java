package com.ibm.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
	
	public List<User> getAllUsers() {
		
		String sql = "select userid, username, useremail, salary from myuser"; 
		List<User> users= null;
		try {
			PreparedStatement ps =
					new GetConnection().getH2Instance().prepareStatement(sql); 
			
			ResultSet rs =  ps.executeQuery(); 
			
			users = new ArrayList<>(); 
			
			while(rs.next()) {
				User temp = new User(); 
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setUserEmail(rs.getString(3));
				temp.setSalary(rs.getInt(4));
				
				users.add(temp); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users; 
	}
}
