package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;

public class CategoryDisplay implements CategoryDisplayInterface {
//Display all category details in category table
	public void viewAllCategoryDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT category_id, category_name FROM category");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getString(2));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }

}
