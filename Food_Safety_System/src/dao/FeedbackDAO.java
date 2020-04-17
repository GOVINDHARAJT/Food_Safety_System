package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Feedback;
import utility.ConnectionManager;

public class FeedbackDAO implements FeedbackDAOInterface {
	
//Insert User Feedback in feedback table 
	public void insertFeedback(Feedback feedback) {
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO feedbacks(user_mobileno, user_username, food_name, comments)VALUES(?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setLong(1, feedback.getUser_mobileno());
			st.setString(2, feedback.getUsername());
			st.setString(3, feedback.getFood_name());
			st.setString(4, feedback.getComment());
			int rowInserted = st.executeUpdate();
			if (rowInserted > 0)
				System.out.println("Thank You For Your Valuable Feedback!");
			else
				System.out.println("Failed!");
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		
	}

}
