package it.corso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Recipe;

public interface RecipeDao extends CrudRepository<Recipe, Integer>{

	@Query(value = "select max(id_recipe) from recipes", nativeQuery = true)
	int getLastId();
	
	@Query(value="SELECT * FROM recipes ORDER BY id_recipe DESC LIMIT 5", nativeQuery = true)
	List<Recipe> lastRecipes();
	
	@Query(value="SELECT * FROM recipes WHERE category='primo' ORDER BY id_recipe DESC", nativeQuery = true)
	List<Recipe> getPrimi();
	
	@Query(value="SELECT * FROM recipes WHERE category='secondo' ORDER BY id_recipe DESC", nativeQuery = true)
	List<Recipe> getSecondi();
	
	@Query(value="SELECT * FROM recipes WHERE category='dolce' ORDER BY id_recipe DESC", nativeQuery = true)
	List<Recipe> getDolci();
}
