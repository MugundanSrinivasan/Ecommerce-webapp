package com.niit.backendproject.DAO;

import java.util.List;

import com.niit.backendproject.model.Category;

public interface CategoryDAO {

	public Category getCategory( int categoryid);
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public List<Category> listCategory();
}
