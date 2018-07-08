package com.niit.backendproject.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendproject.DAO.CategoryDAO;
import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.DAO.SupplierDAO;
import com.niit.backendproject.DAO.UserDAO;
import com.niit.backendproject.model.Category;

public class HibernateConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.backendproject");
		context.refresh();
	CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	ProductDAO	productDAO=(ProductDAO)context.getBean("productDAO");
	UserDAO	userDAO=(UserDAO)context.getBean("userDAO");
		/*Category category=new Category();
		category.setCategoryname("Laptop");
		categoryDAO.addCategory(category);*/
	}

}
