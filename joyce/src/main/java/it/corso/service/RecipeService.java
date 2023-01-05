package it.corso.service;

import java.util.List;

import it.corso.model.Recipe;

public interface RecipeService {
	
	public List<Recipe> getPrimi();
	public List<Recipe> getSecondi();
	public List<Recipe> getDolci();
	
	List<Recipe> getRecipes();
	
	void deleteRecipe(Recipe recipe);
	
	Recipe getRecipeById(int id);
	
	void addRecipe(Recipe recipe);
	
	int getLastId();
	
	List<Recipe> lastRecipes();
}
