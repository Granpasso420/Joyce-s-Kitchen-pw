package it.corso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.User;
import it.corso.service.RecipeService;
import it.corso.service.UserService;

@Controller
@RequestMapping("/modify")
public class modifyController {

	@Autowired
	UserService userService;
	@Autowired
	RecipeService recipeService;
	
	@GetMapping
	public String getPage(Model model, HttpSession session) {
		
		try {
			if(userService.checkUser((User) session.getAttribute("user")))
			{
				model.addAttribute("title", "Modifica Ricetta");
				return "modify";
			}else {
				return "redirect:/login";
			}
		}
		catch (Exception e) {
			return "redirect:/login";
		}
	}

}