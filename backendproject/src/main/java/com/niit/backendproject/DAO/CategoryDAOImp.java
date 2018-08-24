package com.niit.backendproject.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Category;
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImp implements CategoryDAO {
@Autowired
SessionFactory sessionFactory;
	
	public Category getCategory(int categoryid) {
		try
		{
			Session session= sessionFactory.getCurrentSession();
			Category category=(Category)session.get(Category.class, categoryid);
			return category;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	
	public boolean addCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().save(category);
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
			sessionFactory.getCurrentSession().update(category);
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
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch (Exception e){
		return false;
	}
	}
	
	public List<Category> listCategory() {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Category");
			List<Category> listCategory=query.list();
			session.close();
			return listCategory;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
