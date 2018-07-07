package com.niit.backend.test;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.DAO.ProductDAO;
import com.niit.backend.DAO.SupplierDAO;
import com.niit.backend.model.Category;
public class HibernateConfigTest {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
        CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
        SupplierDAO supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
       ProductDAO productDAO=(ProductDAO)context.getBean("ProductDAO");
       /* Supplier supplier =new Supplier();
        supplier.setSuppliername("sm electronics");
        supplier.setSupplierdesc("mobile phone");
        supplierDAO.addSupplier(supplier);
		Category category=new Category();
		category.setCategoryname("Laptop");
		category.setCategorydesc("HP");
		
		categoryDAO.addCategory(category);
		
		System.out.println("Category Object Saved:");
		
		Category category=categoryDAO.getCategory(2);
		System.out.println(category.getCategoryid()+category.getCategorydesc()+category.getCategoryname());
		Category category= categoryDAO.getCategory(2);
		
		category.setCategoryname("mobile");
		category.setCategorydesc("samrtphone");
		categoryDAO.updateCategory(category);
		Category category1= new Category();
		category1.setCategorydesc("LG");
		category1.setCategoryname("mobile");
		categoryDAO.addCategory(category1);*/
  

		List<Category> listCategory=categoryDAO.listCategory();
		
		for(Category category:listCategory)
		{
			System.out.println(category.getCategoryid());
			System.out.println(category.getCategoryname());
			System.out.println(category.getCategorydesc());
		} 
	}
}
