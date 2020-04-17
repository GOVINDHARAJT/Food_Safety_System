package dao;

import model.Category;

public interface CategoryDAOInterface {
	void insertCategory(Category category);
	void deleteCategory(int category_id);
	void updateCategory(int category_id);
}
