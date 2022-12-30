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
@RequestMapping("/modify")
public class modifyController {

	@Autowired
	UserService userService;
	@Autowired
	RecipeService recipeService;
	@Autowired
	HttpSession session;
	
	@GetMapping
	public String getPage(Model model, @RequestParam("id") int id) {
		
		try {
			if(userService.checkUser((User) session.getAttribute("user")))
			{
				Recipe recipe = recipeService.getRecipeById(id);
				model.addAttribute("title", "Modifica Ricetta");
				model.addAttribute("recipe", recipe);
				return "modify";
			}else {
				return "redirect:/login";
			}
		}
		catch (Exception e) {
			return "redirect:/login";
		}
	}
	
	@PostMapping
	public String update(
			@RequestParam(name = "formFile", required = false) MultipartFile image,
			@ModelAttribute("recipe") Recipe recipe) {
		
		recipeService.addRecipe(recipe);
		
		if(image != null && !image.isEmpty()) {
			saveImage(recipeService.getLastId(), image);
		}
		
		return "redirect:/reserved";
	}

	
	private void saveImage(int id_recipe, MultipartFile image) {
		String rootDir = session.getServletContext().getRealPath("/");
		String filePath = rootDir + "static\\foto\\" + id_recipe + ".png";
		try {
			image.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
}