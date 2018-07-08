package com.niit.techbazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.backendproject.DAO.CategoryDAO;
import com.niit.backendproject.model.Category;

@Controller
public class CategoryController {
	/*@Autowired
	CategoryDAO categoryDAO;*/
	@RequestMapping(value="abc")
	public String getcategorypage()
	{
		return "Category";
	}
	/*@RequestMapping(value="InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("cn")String categoryname,@RequestParam("cd")String categorydesc)
	{
		Category category= new Category();
		category.setCategoryname(categoryname);
		categoryDAO.addCategory(category);
		return "Category";
	}*/
}
