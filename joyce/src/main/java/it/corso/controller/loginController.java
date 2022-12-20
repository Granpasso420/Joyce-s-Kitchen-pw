package it.corso.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.User;
import it.corso.service.UserService;

@Controller
@RequestMapping("/login")
public class loginController {

	@Autowired
	UserService service;
	
	@GetMapping
	public String getPage(Model model) {
		
		model.addAttribute("title", "Login");
		
		return "login";
	}
	
	@PostMapping("/check")
	public String check(
			@RequestParam("user") String u,
			@RequestParam("password") String password)
	{
		User user = new User();
		user.setUser(u);
		user.setPassword(password);
		
		if(service.checkUser(user)) {
			return "redirect:/reserved";
		}else {
			return "login";
		}
		
		
	}
}
