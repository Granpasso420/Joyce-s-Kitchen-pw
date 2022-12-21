package it.corso.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RecipeDao;
import it.corso.dao.UserDao;
import it.corso.model.Recipe;
import it.corso.model.User;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeDao recipeDao;
	@Autowired
	UserDao userDao;
	@Autowired
	HttpSession session;
	
	@Override
	public List<Recipe> getRecipes() {
		return (List<Recipe>) recipeDao.findAll();
	}
	
	@Override
	public void deleteRecipe(Recipe recipe) {
		
		recipeDao.delete(recipe);
	}

	@Override
	public Recipe getRecipeById(int id) {
		
		return recipeDao.findById(id).get();
	}

	@Override
	public void addRecipe(Recipe recipe) {
		
		userDao.save((User) session.getAttribute("user"));
		recipeDao.save(recipe);
	}

}
