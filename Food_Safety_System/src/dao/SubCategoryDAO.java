package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.SubCategory;
import utility.ConnectionManager;

public class SubCategoryDAO implements SubCategoryDAOInterface {
	//Insert SubCategory in SubCategory Table	
			public void insertSubCategory(SubCategory subcategory){
				try {
					Connection con = ConnectionManager.getConnection();
					
					String sql = "INSERT INTO sub_category(sub_category_id, sub_category_name) VALUES(?,?)";
					PreparedStatement st = con.prepareStatement(sql);;
					st.setInt(1, subcategory.getSub_category_id());
					st.setString(2, subcategory.getSub_category_name());
					
					int rowInserted = st.executeUpdate();
					if (rowInserted > 0)
						System.out.println("Inserted Successfully!");
					else
						System.out.println("Insert Failed");
					con.close();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
	//Delete SubCategory in SubCategory Table
			public void deleteSubCategory(int sub_category_id) {
				try  {
					Connection con = ConnectionManager.getConnection();
					PreparedStatement st = con.prepareStatement("DELETE FROM sub_category WHERE sub_category_id = ?");
					st.setInt(1, sub_category_id);
					int  rowDeleted = st.executeUpdate();
					if(rowDeleted>0)
						System.out.println("SubCategory ID = "+sub_category_id+" Deleted Successfully!");
					else
						System.out.println("Incorrect ID!");
				    con.close();
					} catch (Exception e) {
						System.out.println(e);
					}
			}
	//Update SubCategory in SubCategory Table	
			public void updateSubCategory(int sub_category_id) {
				try {
					Scanner sc = new Scanner(System.in);
					Connection con = ConnectionManager.getConnection();
					PreparedStatement st= con.prepareStatement("UPDATE sub_category SET sub_category_name = ? WHERE sub_category_id = ?");
				
					System.out.print("Edit SubCategory Name : ");
					String sub_category_name = sc.next();
					
					st.setString(1, sub_category_name);
					st.setInt(2, sub_category_id);
					
					int rowUpdated = st.executeUpdate();
					if(rowUpdated>0)
					System.out.println("SubCategory ID = "+sub_category_id+" Updated Successfully!");
				
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
}
