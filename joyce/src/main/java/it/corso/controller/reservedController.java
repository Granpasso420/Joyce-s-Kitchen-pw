package it.corso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import it.corso.model.Recipe;
import it.corso.model.User;
import it.corso.service.RecipeService;
import it.corso.service.UserService;

@Controller
@RequestMapping("/reserved")
public class reservedController {
	
	@Autowired
	UserService userService;
	@Autowired
	RecipeService recipeService;
	
	@GetMapping
	public String getPage(
			Model model,
			@ModelAttribute("user") User user,
			HttpSession session)
	{

		
		if(userService.checkUser(user) || userService.checkUser((User) session.getAttribute("user")))
		{
			if(session.getAttribute("user") == null) {
				session.setAttribute("user", user);
			}
			//List<Recipe> recipes = recipeService.getRecipes();
			model.addAttribute("title", "Area Riservata");
			model.addAttribute("recipes", recipeService.getRecipes());
			
			return "reserved";
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/delete")
	public String deleteRecipe(
			@ModelAttribute("recipe") Recipe recipe)
	{
		recipeService.deleteRecipe(recipe);
		return "redirect:/reserved";
	}

}
