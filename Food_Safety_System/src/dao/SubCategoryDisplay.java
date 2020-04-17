package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import utility.ConnectionManager;

public class SubCategoryDisplay implements SubCategoryDisplayInterface {
//Display all subcategory details in subcategory table
	public void viewAllSubCategoryDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT sub_category_id, sub_category_name FROM sub_category");
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
