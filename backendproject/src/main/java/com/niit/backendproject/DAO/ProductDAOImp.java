package com.niit.backendproject.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.model.Product;
@Transactional
@Repository("productDAO")
public class ProductDAOImp implements ProductDAO {
@Autowired
SessionFactory sessionFactory;
	
	public boolean addProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}


	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e)
		{
		return false;
	}
	}


	public boolean deleteProduct(Product product) {
	try
	{
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}
	catch (Exception e)
	{
	return false;
}
	}

	public Product getProduct(int productid) {
		try
		{
			Session session= sessionFactory.getCurrentSession();
			Product product=(Product)session.get(Product.class, productid);
			return product;
		}
		catch(Exception e)
		{
			return null;
		}
	}


	public List<Product> listProduct() {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Product");
			List<Product> listProduct=query.list();
			session.close();
			return listProduct;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	
	public List<Product> listProductByCategory(int categoryid) {
	try
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryid:catid");
		query.setParameter("catid", categoryid);
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}
	catch(Exception e)
	{
		return null;
	}
	}
}
