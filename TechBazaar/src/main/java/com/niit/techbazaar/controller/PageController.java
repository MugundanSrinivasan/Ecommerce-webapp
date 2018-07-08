package com.niit.techbazaar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
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
public String showRegisterPage()
{
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
}
