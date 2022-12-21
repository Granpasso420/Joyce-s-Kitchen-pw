package it.corso.service;

import java.util.List;

import it.corso.model.Recipe;

public interface RecipeService {

	List<Recipe> getRecipes();
	
	void deleteRecipe(Recipe recipe);
	
	Recipe getRecipeById(int id);
	
	void addRecipe(Recipe recipe);
	
	void modifyRecipe(Recipe recipe);
}
