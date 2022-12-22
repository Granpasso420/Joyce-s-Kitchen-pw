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
@RequestMapping("/secondi")
public class secondiController {

	@Autowired
	RecipeService service;
	
	@GetMapping
	public String getPage(Model model) {
		
		List<Recipe> secondi = service.getList("secondo");
		model.addAttribute("title", "Secondi");
		model.addAttribute("secondi", secondi);
		
		return "secondi";
	}
}
