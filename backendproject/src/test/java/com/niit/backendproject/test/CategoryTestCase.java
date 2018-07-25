package com.niit.backendproject.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backendproject.DAO.CategoryDAO;
import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.DAO.SupplierDAO;
import com.niit.backendproject.DAO.UserDAO;
import com.niit.backendproject.model.Category;
@RunWith(JUnit4 .class)
public class CategoryTestCase {

	static CategoryDAO categoryDAO;
	static ProductDAO productDAO;
	static SupplierDAO supplierDAO;
	static UserDAO userDAO;
	@BeforeClass
			public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.backendproject");
			context.refresh();
			
			categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
			supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
			productDAO=(ProductDAO)context.getBean("productDAO");
			userDAO=(UserDAO)context.getBean("userDAO");
		}
@Test
	

	
			public void updateCategoryTest()
			{
				Category category=categoryDAO.getCategory(199);
				category.setCategoryname("mobile");
				
				
			
				
				assertTrue("Problem in Adding Category:",categoryDAO.updateCategory(category));

			}
/*	@Test
	
	public void addSupplierTest()
	{
		Supplier supplier=new Supplier();
		
		supplier.setSuppliername("sony electronic");
	
		
		assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	}	
	@Test
	
	public void addProductTest()
	{
	Product product= new Product();
		
		product.setProductname("samsung j7");
	product.setPrice(8000);
	product.setProductdesc("samsung j series");
	product.setQuantity(10);
		
		assertTrue("Problem in Adding Product:",productDAO.addProduct(product));
	}
	@Test
	
	public void registerUserTest()
	{
	User user =new User();
		
		user.setUsername("mugundan");
	user.setPassword("1234");
	user.setMobileno(9094878196L);
	
		
		assertTrue("Problem in Adding User:",userDAO.registerUser(user));
	}*/
	@Test
	public void listCategoryTest()
	{
		List<Category> listCategory=categoryDAO.listCategory();
		assertTrue("problem in listing categories",listCategory.size()>0);
		for(Category category:listCategory)
		{
			System.out.println(category.getCategoryid());
			System.out.println(category.getCategoryname());
		}
	}

}
