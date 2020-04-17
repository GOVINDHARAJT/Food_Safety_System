package dao;

public interface FoodDisplayInterface {
	void viewAllFoodDetails();
	void viewExpiredFood();
	void searchbyCategory(String food_type);
	void searchbyFoodname(String food_type);
	void viewbyLifespan(int id);
}
