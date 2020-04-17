package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;
import utility.ConnectionManager;
public class Validations implements Interfaces {
//Admin login function
	public boolean LoginAdmin(Admin admin) {
		boolean result = false;
		try {
			Connection con = ConnectionManager.getConnection();	
			PreparedStatement st = con.prepareStatement("SELECT * FROM admin WHERE admin_username = ? AND admin_password = ?");
			st.setString(1, admin.getUsername());
			st.setString(2, admin.getPassword());
		
			ResultSet rs = st.executeQuery();
			result = rs.next();
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			return result;
		}
//User Sign Up function
	public int SignUpUser(User user) {
		int rowInserted = 0;
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO usertable(user_mobileno, user_username, user_password) VALUES(?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setLong(1, user.getMobileno());
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			
		    rowInserted = st.executeUpdate();
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		return rowInserted;
	}
//User Sign In function
	public boolean SignInUser(User user) {
		boolean result = false;
		try {
			Connection con = ConnectionManager.getConnection();	
			PreparedStatement st = con.prepareStatement("SELECT * FROM usertable WHERE user_username = ? AND user_password = ?");
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
		
			ResultSet rs = st.executeQuery();
			result = rs.next();
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		return result;
		}
}
