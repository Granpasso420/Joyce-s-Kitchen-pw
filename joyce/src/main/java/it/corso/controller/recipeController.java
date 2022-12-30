package it.corso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Recipe;
import it.corso.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class recipeController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public String getPage(Model model, HttpServletRequest request) {
		
		int id = Integer.parseInt((String) request.getAttribute("id"));
		Recipe recipe = service.getRecipeById(id);
		
		
		model.addAttribute("recipe", recipe);
		model.addAttribute("title", "Ricetta");
		return "recipe";
	}
}
