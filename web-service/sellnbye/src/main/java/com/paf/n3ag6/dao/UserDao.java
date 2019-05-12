package com.paf.n3ag6.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.paf.n3ag6.database.DbConnection;
import com.paf.n3ag6.models.Enums.UserType;
import com.paf.n3ag6.models.User;

public class UserDao {

	private Connection _dbConnection;

	public UserDao() {
		this._dbConnection = new DbConnection().getConnection();
	}

	public ArrayList<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();

		try {
			Statement stmt = this._dbConnection.createStatement();
			String sql;
			sql = "SELECT * FROM users";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				User usr = new User();

				usr.setUsername(rs.getString("username"));
				usr.setContactNo(rs.getString("contactNo"));
				usr.setUserType(UserType.valueOf(rs.getString("userType")));
				usr.setPasswordHash("********");
				usr.setEmail(rs.getString("email"));
				usr.setProfilePicture(rs.getString("profilePicture"));
				usr.setIsActive(rs.getBoolean("isActive"));

				userList.add(usr);
			}

		} catch (Exception ex) {
			System.out.println("[Error][UserDao][getAllUsers] - "  + ex.getMessage());
		}
		return userList;
	}

	public void dispose() {
		try {
			if (!this._dbConnection.isClosed()) {
				this._dbConnection.close();
			}
		} catch (Exception e) {
			System.out.println("[Error][UserDao][dispose] - "  + e.getMessage());
		}
	};
}