package com.niit.techbazaar.controller;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

@RequestMapping("/login_success")
public String login(Model m,HttpSession session)
{
	System.out.println("Login Success entered");
	String page="";
	boolean loggedIn=false;
	SecurityContext securityContext= SecurityContextHolder.getContext();
	Authentication authentication=securityContext.getAuthentication();
	String username=authentication.getName();
	Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
	for(GrantedAuthority role:roles)
	{
		session.setAttribute("role", role.getAuthority());
		if (role.getAuthority().equals("ROLE_USER"))
		{
			loggedIn=true;
			page="redirect:/productdisplay";
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username", username);
		}
		else
		{
			loggedIn=true;
			page="redirect:/home";
			session.setAttribute("loggedIn",loggedIn);
			session.setAttribute("username", username);
		}
	}
	
	return page;
}
@RequestMapping(value="logout")
public String logout()
{
	return "Home";
}
}
