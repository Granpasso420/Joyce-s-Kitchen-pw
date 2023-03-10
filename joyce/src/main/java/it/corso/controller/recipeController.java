package it.corso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.corso.model.Recipe;
import it.corso.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class recipeController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public String getPage(Model model, @RequestParam("id") int id) {
		
		
		Recipe recipe = service.getRecipeById(id);
		String tipo = recipe.getRecipecategory().substring(0,recipe.getRecipecategory().length()-1);
		tipo = tipo.concat("i");
		
		model.addAttribute("recipe", recipe);
		model.addAttribute("tipo", tipo);
		model.addAttribute("title", "Ricetta");
		return "recipe";
	}
}
