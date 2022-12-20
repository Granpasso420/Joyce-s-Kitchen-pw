package it.corso.service;

import java.util.List;

import it.corso.model.Recipe;

public interface RecipeService {

	List<Recipe> getRecipes();
	
	void deleteRecipe(Recipe recipe);
}
