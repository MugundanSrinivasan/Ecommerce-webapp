package com.niit.techbazaar.controller;





import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




	@Controller
	public class HomeController {

		@RequestMapping(value="abc")  //@RequestMapping("/abc") 
		public String getLoginPage()
		{
			return "Login";
		}
		
		/*@RequestMapping("/reg")
		public String getRegisterPage(Model m)
		{
			m.addAttribute("msg", "Welcome to Register page");
			return "Register";
		}
		*/
		
		@RequestMapping(value="/") 
		public String home()
		{
			return "home";
		}
		
		@RequestMapping("/reg")
		public ModelAndView getRegisterPage()
		{
			ModelAndView mv=new ModelAndView("Register","msg","Welcome to Register page");
			return mv;
		}

	}


