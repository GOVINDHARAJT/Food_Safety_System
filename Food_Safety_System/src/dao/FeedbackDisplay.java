package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;

public class FeedbackDisplay implements FeedbackDisplayInterface {
//Display all feedbacks in feedback table	
	public void viewFeedbacks() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT user_mobileno, user_username, food_name, comments FROM feedbacks");
			while(rs.next())
			{
				System.out.println(rs.getLong(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t\t"+rs.getString(4));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
		
}
