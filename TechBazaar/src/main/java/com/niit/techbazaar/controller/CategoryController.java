package com.niit.techbazaar.controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.backend.model.Category;
import com.niit.backend.DAO.CategoryDAO;


@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	/*@RequestMapping(value="cat")
	public String getcategorypage(Model m)
	{
		List<Category> listCategory=categoryDAO.listCategory();
		m.addAttribute("categorylist",listCategory);
		return "Category";
	}*/
	@RequestMapping(value="cat")
	public String getcategorypage()
	{
		return "Category";
	}
	@RequestMapping(value="InsertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("cn")String categoryname,@RequestParam("cd")String categorydesc)
	{
		Category category= new Category();
		category.setCategoryname(categoryname);
		category.setCategorydesc(categorydesc);
		categoryDAO.addCategory(category);
		return "Category";
	}
}
