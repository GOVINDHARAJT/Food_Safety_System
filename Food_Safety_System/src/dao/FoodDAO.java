package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utility.*;
import model.*;
public  class FoodDAO implements FoodDAOInterface {

//Insert Food Items in Food Table	
	public void insertFood(Food food){
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql = "INSERT INTO food(food_id, food_type, food_name, m_f_date, expiry_date)VALUES(?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);;
			st.setInt(1, food.getFood_id());
			st.setString(2, food.getFood_type());
			st.setString(3, food.getFood_name());
			st.setDate(4, java.sql.Date.valueOf(food.getM_f_date()));
			st.setDate(5, java.sql.Date.valueOf(food.getExpiry_date()));
			
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
	
//Delete Food Items in Food Table
	public void deleteFood(int food_id) {
		try  {
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st= con.prepareStatement("DELETE FROM food WHERE food_id = ?");
			st.setInt(1, food_id);
			int  rowDeleted = st.executeUpdate();
			if(rowDeleted>0)
				System.out.println("Food ID = "+food_id+" Deleted Successfully!");
			else
				System.out.println("Incorrect ID!");
		    con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	
//Update Food Items in Food Table	
	public void updateFood(int food_id) {
		try {
			Scanner sc = new Scanner(System.in);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			Connection con = ConnectionManager.getConnection();
			PreparedStatement st= con.prepareStatement("UPDATE food SET food_name = ?, m_f_date = TO_DATE(?, 'DD-MM-YY'),expiry_date = TO_DATE(?, 'DD-MM-YY') WHERE food_id = ?");
		
			System.out.print("Edit Food Name : ");
			String food_name = sc.next();
		
			System.out.print("Edit Food M.F.Date(DD-MM-YYYY) : ");
			String mdate = sc.next();
			LocalDate m_f_date = LocalDate.parse(mdate, formatter);

			System.out.print("Edit Food Expiry Date(DD-MM-YYYY) : ");
			String edate = sc.next();
			LocalDate expiry_date = LocalDate.parse(edate, formatter);
		
			st.setString(1, food_name);
			st.setDate(2, java.sql.Date.valueOf(m_f_date));
			st.setDate(3, java.sql.Date.valueOf(expiry_date));
			st.setInt(4, food_id);
		
			int rowUpdated = st.executeUpdate();
			if(rowUpdated>0)
				System.out.println("Food ID = "+food_id+" Updated Successfully!");
		
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
