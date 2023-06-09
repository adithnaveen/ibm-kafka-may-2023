package com.ibm.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	 
	public List<User> getAllUsers() {

		String sql = "select userid, username, useremail, salary from MYUSER";
		List<User> users = null;
		PreparedStatement ps = null;
		try {

			ps = new GetConnection().getH2Instance().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			users = new ArrayList<>();

			while (rs.next()) {
				User temp = new User();
				temp.setUserId(rs.getInt(1));
				temp.setUserName(rs.getString(2));
				temp.setUserEmail(rs.getString(3));
				temp.setSalary(rs.getInt(4));

				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;
	}

	public static void main(String[] args) {
		List<User> allUsers = new UserDAO().getAllUsers();
		for (User temp : allUsers) {
			System.out.println(temp.getUserName());
		}
	}
}
