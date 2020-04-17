package model;


import java.time.LocalDate;
import java.util.*;

public class Food {
		private int food_id;
		private String food_type;
		private String food_name;
		private LocalDate m_f_date;
		private LocalDate expiry_date;
		public Food(int food_id, String food_type, String food_name, LocalDate m_f_date, LocalDate expiry_date) {

			this.food_id = food_id;
			this.food_type = food_type;
			this.food_name = food_name;
			this.m_f_date = m_f_date;
			this.expiry_date = expiry_date;
		}
		public int getFood_id() {
			return food_id;
		}
		public void setFood_id(int food_id) {
			this.food_id = food_id;
		}
		public String getFood_type() {
			return food_type;
		}
		public void setFood_type(String food_type) {
			this.food_type = food_type;
		}
		public String getFood_name() {
			return food_name;
		}
		public void setFood_name(String food_name) {
			this.food_name = food_name;
		}
		public LocalDate getM_f_date() {
			return m_f_date;
		}
		public void setM_f_date(LocalDate m_f_date) {
			this.m_f_date = m_f_date;
		}
		public LocalDate getExpiry_date() {
			return expiry_date;
		}
		public void setExpiry_date(LocalDate expiry_date) {
			this.expiry_date = expiry_date;
		}

		
		
}
