package com.niit.backend.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.backend.model.Product;
@Repository("ProductDAO")
@Transactional
public class ProductDAOimp implements ProductDAO {
@Autowired
SessionFactory sf;
public Product getProduct(int productid) 
	{
	try
	{
	Session session= sf.getCurrentSession();
	Product product =(Product) session.get(Product.class, productid);
	return product;
	}
	catch(Exception e)
	{
		return null;
		
	}
	
	}

	public boolean addProduct(Product product) {
		try
		{
			sf.getCurrentSession().save(product);
			return true;
		}
		catch (Exception e){
		return false;
	}
	}

	public boolean updateProduct(Product product) {
		try
		{
			sf.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e){
		return false;
	}
	}
	public boolean deleteProduct(Product product) {
		try
		{
			sf.getCurrentSession().delete(product);
			return true;
		}
		catch (Exception e){
		return false;
	}
	}
	public List<Product> listProduct() {
		try
		{
			Session session= sf.openSession();
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
}