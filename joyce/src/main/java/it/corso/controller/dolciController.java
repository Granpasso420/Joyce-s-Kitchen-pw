package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Recipe;
import it.corso.service.RecipeService;

@Controller
@RequestMapping("/dolci")
public class dolciController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public String getPage(Model model) {
		
		List<Recipe> dolci = service.getDolci();
		model.addAttribute("title", "Dolci");
		model.addAttribute("dolci", dolci);
		
		return "dolci";
	}
}
