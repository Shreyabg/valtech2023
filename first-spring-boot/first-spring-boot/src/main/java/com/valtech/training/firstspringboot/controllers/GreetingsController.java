package com.valtech.training.firstspringboot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingsController {

//@RequestMapping(method = RequestMethod.GET,path="/hello")
//@ResponseBody
	@GetMapping("/hello")
   public String hello(@RequestParam("name")String name,Model model) {//what ever u return from this method is body
	//return "Hello Spring";
		
	//String name=request.getParameter("name");//http://localhost:8080/hello?name=valtech
	System.out.println("Name=" +name);
	model.addAttribute("name",name);
	return "hello";
	//if comment message will be name of the page
   }
	
	
	
	
	
}
