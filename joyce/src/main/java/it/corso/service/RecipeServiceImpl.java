package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RecipeDao;
import it.corso.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeDao recipeDao;
	
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
		
		recipeDao.save(recipe);
	}
}
