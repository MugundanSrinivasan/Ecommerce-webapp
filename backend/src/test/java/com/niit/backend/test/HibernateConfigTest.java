package com.niit.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.DAO.SupplierDAO;
import com.niit.backend.model.Category;
import com.niit.backend.model.Supplier;

public class HibernateConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
        CategoryDAO categoryDAO=(CategoryDAO)context.getBean("CategoryDAO");
        SupplierDAO supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
		
        Supplier supplier =new Supplier();
        supplier.setSuppliername("sm electronics");
        supplier.setSupplierdesc("mobile phone");
        supplierDAO.addSupplier(supplier);
		/*Category category=new Category();
		category.setCategoryname("Laptop");
		category.setCategorydesc("HP");
		
		categoryDAO.addCategory(category);*/
		
		System.out.println("Category Object Saved:");
		
		/*Category category=categoryDAO.getCategory(2);
		System.out.println(category.getCategoryid()+category.getCategorydesc()+category.getCategoryname());*/
		Category category= categoryDAO.getCategory(2);
		
		category.setCategoryname("mobile");
		category.setCategorydesc("samrtphone");
		categoryDAO.updateCategory(category);
		Category category1= new Category();
		category1.setCategorydesc("LG");
		category1.setCategoryname("mobile");
		categoryDAO.addCategory(category1);
		
		

	}

}
