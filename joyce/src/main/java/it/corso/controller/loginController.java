package it.corso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.User;


@Controller
@RequestMapping("/login")
public class loginController {
	
	@GetMapping
	public String getPage(Model model,HttpSession session) {
		
		model.addAttribute("title", "Login");
		if(session.getAttribute("user") == null) {
			model.addAttribute("name", "");
			model.addAttribute("password", "");
		}else {
			User user = (User) session.getAttribute("user");
			model.addAttribute("name", user.getUser());
			model.addAttribute("password", user.getPassword());
		}
		return "login";
	}
	
}
