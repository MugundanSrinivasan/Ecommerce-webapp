package com.niit.techbazaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backendproject.DAO.ProductDAO;
import com.niit.backendproject.DAO.UserDetailDAO;
import com.niit.backendproject.model.Product;
import com.niit.backendproject.model.UserDetail;



@Controller
public class PageController {
	@Autowired
	UserDetailDAO userdetailDAO;
	@Autowired
	ProductDAO productDAO;
	@RequestMapping(value= {"/","/home"})
	public String rootPage(Model m)
	{
		List<Product> prod=productDAO.listProduct();
		m.addAttribute("prod",prod);
		return "Home";
	}
@RequestMapping(value="login")
public String showLoginPage()
{
	return "Login";
}
@RequestMapping(value="register")
public String showRegisterPage(Model m)
{
	UserDetail userdetail=new UserDetail();
	m.addAttribute("user",userdetail);
	return "Register";
}
@RequestMapping(value="aboutus")
public String showAboutUsPage()
{
	return "Aboutus";
	
}
@RequestMapping(value="contactus")
public String showContactUsPage()
{
	return "Contactus";
}
@RequestMapping(value="insertuserdetail")
public String insertUserDetail(@ModelAttribute("user")UserDetail userdetail,Model m)
{
	userdetailDAO.registerUser(userdetail);
	return "Login";
}
}
