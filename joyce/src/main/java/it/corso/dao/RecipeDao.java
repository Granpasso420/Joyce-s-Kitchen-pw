package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Recipe;

public interface RecipeDao extends CrudRepository<Recipe, Integer>{

	@Query(value = "select max(id_recipe) from recipes", nativeQuery = true)
	int getLastId();
	
	@Query(value="SELECT id_recipe FROM recipes ORDER BY id_recipe DESC LIMIT 4;", nativeQuery = true)
	List<Integer> lastRecipes();
}
