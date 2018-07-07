package com.niit.backend.test;


import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.backend.DAO.CategoryDAO;
import com.niit.backend.model.Category;
@RunWith(JUnit4 .class)
public class CategoryDAOTestCase  {

	static CategoryDAO categoryDAO;
	@BeforeClass
			public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.backend");
			context.refresh();
			
			categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		}
	@Test
	
			public void addCategoryTest()
			{
				Category category1=new Category();
				
				category1.setCategoryname("sony");
				category1.setCategorydesc("y-series");
				
				assertTrue("Problem in Adding Category:",categoryDAO.addCategory(category1));
			}		
	@Test
	@Ignore
	public void listCategoryTest()
	{
		List<Category> listCategory=categoryDAO.listCategory();
		assertTrue("problem in listing category",listCategory.size()>0);
		for(Category category:listCategory)
		{
			System.out.println(category.getCategoryid());
			System.out.println(category.getCategoryname());
			System.out.println(category.getCategorydesc());
		}
	}
	}
	

