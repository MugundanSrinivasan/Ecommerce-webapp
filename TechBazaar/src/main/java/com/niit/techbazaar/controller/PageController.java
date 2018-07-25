package com.niit.techbazaar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backendproject.DAO.UserDAO;
import com.niit.backendproject.model.User;

@Controller
public class PageController {
	@Autowired
	UserDAO userDAO;
	@RequestMapping(value= {"/","/home"})
	public String rootPage()
	{
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
	User user=new User();
	m.addAttribute("user",user);
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
public String insertUserDetail(@ModelAttribute("user")User user,Model m)
{
	userDAO.registerUser(user);
	return "Login";
}
}
