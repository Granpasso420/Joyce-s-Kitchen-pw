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
@RequestMapping(path = {"/", "/index", "/home"})
public class indexController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public String getPage(Model model) {
		List<Recipe> last = service.lastRecipes();
		Recipe ultR= service.getRecipeById(service.getLastId());
		last.remove(0);
		// ultima ricetta
		model.addAttribute("ultR", ultR);
		model.addAttribute("lastRecipes", last);
		model.addAttribute("title", "Home");
		
		return "index";
	}
}
