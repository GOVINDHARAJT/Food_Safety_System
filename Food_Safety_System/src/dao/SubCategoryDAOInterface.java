package dao;

import model.SubCategory;

public interface SubCategoryDAOInterface {
	void insertSubCategory(SubCategory subcategory);
	void deleteSubCategory(int sub_category_id);
	void updateSubCategory(int sub_category_id);
}
