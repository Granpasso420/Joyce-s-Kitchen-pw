package it.corso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RecipeDao;
import it.corso.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	RecipeDao dao;
	
	@Override
	public List<Recipe> getRecipes() {
		return (List<Recipe>) dao.findAll();
	}

	@Override
	public void deleteRecipe(Recipe recipe) {
		dao.delete(recipe);
	}

}
