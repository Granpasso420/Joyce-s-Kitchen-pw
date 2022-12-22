package it.corso.controller;


import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import it.corso.model.Recipe;
import it.corso.model.User;
import it.corso.service.RecipeService;
import it.corso.service.UserService;

@Controller
@RequestMapping("/add")
public class addController {

	@Autowired
	UserService userService;
	@Autowired
	RecipeService recipeService;
	@Autowired
	HttpSession session;
	
	@GetMapping
	public String getPage(Model model) {
		
		try {
			if(userService.checkUser((User) session.getAttribute("user")))
			{
				model.addAttribute("title", "Aggiungi Ricetta");
				model.addAttribute("recipe", new Recipe());
				return "add";
			}else {
				return "redirect:/login";
			}
		}
		catch (Exception e) {
			return "redirect:/login";
		}
	}
	
	@PostMapping
	public String addingRecipe (@ModelAttribute("recipe") Recipe recipe,
			@RequestParam(name = "formFile", required = false) MultipartFile image,
			HttpSession session) {
		
		recipeService.addRecipe(recipe);
		
		if(image != null & !image.isEmpty())
			saveImage(recipe.getId_recipe(), image, session);
		
		return "redirect:/reserved";
	}
	
	private void saveImage(int id_recipe, MultipartFile image, HttpSession session) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\foto\\" + id_recipe + ".png";
		try {
			image.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
