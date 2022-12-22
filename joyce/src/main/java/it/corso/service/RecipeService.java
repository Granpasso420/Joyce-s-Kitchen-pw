package it.corso.service;

import java.util.List;

import it.corso.model.Recipe;

public interface RecipeService {
	
	public List<Recipe> getList(String categoria);
	
	List<Recipe> getRecipes();
	
	void deleteRecipe(Recipe recipe);
	
	Recipe getRecipeById(int id);
	
	void addRecipe(Recipe recipe);
	
	int getLastId();
}
