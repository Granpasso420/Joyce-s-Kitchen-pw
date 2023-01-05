package it.corso.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<Recipe> recipes = (List<Recipe>) recipeDao.findAll();
		Comparator<Recipe> comparator = Comparator.comparing(Recipe :: getId_recipe).reversed();
		recipes = recipes.stream().sorted(comparator).collect(Collectors.toList());
		
		return recipes;
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

	@Override
	public List<Recipe> getPrimi() {
//		List<Recipe> recipes = (List<Recipe>) recipeDao.findAll();
//		for(Recipe r : recipes) {
//			if(r.getRecipecategory().equals(categoria)) {
//				list.add(r);
//			}
//		}
		return recipeDao.getPrimi();
	}
	
	@Override
	public List<Recipe> getSecondi() {
		return recipeDao.getSecondi();
	}
	
	@Override
	public List<Recipe> getDolci() {
		return recipeDao.getDolci();
	}
		
	@Override
	public int getLastId() {
		
		return recipeDao.getLastId();
	}

	@Override
	public List<Recipe> lastRecipes() {
		
		return (List<Recipe>) recipeDao.lastRecipes();
	}
}
