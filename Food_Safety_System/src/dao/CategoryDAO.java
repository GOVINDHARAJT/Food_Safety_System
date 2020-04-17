package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import model.Category;
import utility.ConnectionManager;

public class CategoryDAO implements CategoryDAOInterface {

//Insert Category in Category Table	
		public void insertCategory(Category category){
			try {
				Connection con = ConnectionManager.getConnection();
				
				String sql = "INSERT INTO category(category_id, category_name) VALUES(?,?)";
				PreparedStatement st = con.prepareStatement(sql);;
				st.setInt(1, category.getCategory_id());
				st.setString(2, category.getCategory_name());
				
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
//Delete Category in Category Table
		public void deleteCategory(int category_id) {
			try  {
				Connection con = ConnectionManager.getConnection();
				PreparedStatement st= con.prepareStatement("DELETE FROM category WHERE category_id = ?");
				st.setInt(1, category_id);
				int  rowDeleted = st.executeUpdate();
				if(rowDeleted>0)
					System.out.println("Category ID = "+category_id+" Deleted Successfully!");
				else
					System.out.println("Incorrect ID!");
			    con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
		}
//Update Category in Category Table	
		public void updateCategory(int category_id) {
			try {
				Scanner sc = new Scanner(System.in);
				Connection con = ConnectionManager.getConnection();
				PreparedStatement st = con.prepareStatement("UPDATE category SET category_name = ? WHERE category_id = ?");
			
				System.out.print("Edit Category Name : ");
				String category_name = sc.next();
				
				st.setString(1, category_name);
				st.setInt(2, category_id);
				
				int rowUpdated = st.executeUpdate();
				if(rowUpdated>0)
				System.out.println("Category ID = "+category_id+" Updated Successfully!");
			
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
