package com.niit.backend.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backend.model.Category;
@Repository("CategoryDAO")
@Transactional
public class CategoryDAOimp implements CategoryDAO {
	
	
	@Autowired
	SessionFactory sf;
	

	public boolean addCategory(Category category) {
		try
		{
			sf.getCurrentSession().save(category);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}
	public boolean updateCategory(Category category) {
		try
		{
			sf.getCurrentSession().update(category);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}
	public boolean deleteCategory(Category category) {
		try
		{
			sf.getCurrentSession().delete(category);
			return true;
		}
		catch (Exception e){
		return false;
	}
	}
	public Category getCategory(int categoryid) {
		try
		{
			Session session= sf.getCurrentSession();
			Category category=(Category)session.get(Category.class, categoryid);
			return category;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
