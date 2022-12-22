package it.corso.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@Autowired
	HttpSession session;
	
	@GetMapping
	public String getPage(
			Model model,
			@ModelAttribute("user") User user)
	{

		try {
			if(userService.checkUser(user) || userService.checkUser((User) session.getAttribute("user")))
			{
				//List<Recipe> recipes = recipeService.getRecipes();
				model.addAttribute("title", "Area Riservata");
				model.addAttribute("recipes", recipeService.getRecipes());
				return "reserved";
			}else {
				return "redirect:/login";
			}
		}
		catch (Exception e) {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/delete")
	public String deleteRecipe(
			@RequestParam("id") int id)
	{
		try {
			if(userService.checkUser((User) session.getAttribute("user")))
			{
				Recipe recipe = recipeService.getRecipeById(id);
				recipeService.deleteRecipe(recipe);
				return "redirect:/reserved";
			}else {
				return "redirect:/login";
			}
		}
		catch (Exception e) {
			return "redirect:/login";
		}
	}

	
}
