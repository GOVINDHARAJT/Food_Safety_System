package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.*;
import java.util.Date;

import utility.ConnectionManager;

public class FoodDisplay implements FoodDisplayInterface  {
//Display food items from food table 	
	public void viewAllFoodDetails() {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT food_id, food_name, m_f_date, expiry_date FROM food");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDate(3)+"\t\t"+rs.getDate(4));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
	
//Display expired food items from food table
	public void viewExpiredFood() {
		try {
			LocalDate now = LocalDate.now();
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT food_id, food_name, m_f_date, expiry_date FROM food");
			while(rs.next())
			{
				java.sql.Date date = rs.getDate(4);
			    java.time.LocalDate expiredate = date.toLocalDate();
				
			    Period diff = Period.between(now, expiredate);
				
				int y=diff.getYears();
			    int m=diff.getMonths();
			    int d=diff.getDays();
			    
			    if(y<=0&&m<=0&&d<=0)
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getDate(3)+"\t\t"+rs.getDate(4));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
//Search by Category food items
	public void searchbyCategory(String food_type) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT food_id, food_type, food_name, m_f_date, expiry_date FROM food");
			while(rs.next())
			{
				if(food_type.equals(rs.getString(2)))
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDate(4)+"\t\t"+rs.getDate(5));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
//Search by food name 
	public void searchbyFoodname(String food_name) {
		try {
			LocalDate now = LocalDate.now();
			int flag = 0;
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT food_id, food_type, food_name, m_f_date, expiry_date FROM food");
			
			while(rs.next())
			{
			    java.sql.Date date = rs.getDate(5);
			    java.time.LocalDate expiredate = date.toLocalDate();
				
			    Period diff = Period.between(now, expiredate);
				
			    int y=diff.getYears();
			    int m=diff.getMonths();
			    int d=diff.getDays();
				
				if(food_name.equals(rs.getString(3))) {
					if(y<=0&&m<=0&&d<=0) {
						System.out.print(rs.getInt(1)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDate(4)+"\t\t"+rs.getDate(5));
						System.out.println("  (Expired food)");
					}
					else
						System.out.println(rs.getInt(1)+"\t\t"+rs.getString(3)+"\t\t"+rs.getDate(4)+"\t\t"+rs.getDate(5));
					flag = 1;
				}
			}
			
			
			if(flag==0)
				System.out.println("Stock is not available");
			
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }


//Display Day wise Life Span Foods
	public void viewbyLifespan(int id) {
		try {
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT food.food_id,food.food_name FROM food JOIN main_category ON food.food_id=main_category.food_id INNER JOIN category on category.category_id=main_category.category_id WHERE main_category.category_id="+id);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2));
			}
			con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	  }
}

