package com.niit.backend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.model.Category;

public class HibernateConfigTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.backend");
		context.refresh();
        CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		Category category=new Category();
		category.setCategoryname("Mobile");
		category.setCategorydesc("Samsung Mobiles");
		
		categoryDAO.addCategory(category);
		
		System.out.println("Category Object Saved:");
		

	}

}
