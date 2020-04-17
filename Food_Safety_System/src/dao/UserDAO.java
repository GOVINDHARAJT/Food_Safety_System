package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;

public class UserDAO implements UserDAOInterface{
//Display User Details from user table	
	public void viewUserDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT user_mobileno, user_username, user_password FROM usertable");
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+"\t\t"+rs.getString(2)+"\t\t\t"+rs.getString(3));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }

}
