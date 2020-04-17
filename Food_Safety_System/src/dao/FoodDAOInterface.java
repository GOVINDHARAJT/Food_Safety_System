package dao;

import model.Food;

public interface FoodDAOInterface {
	public void insertFood(Food food);
	public void deleteFood(int food_id);
	public void updateFood(int food_id);
}
