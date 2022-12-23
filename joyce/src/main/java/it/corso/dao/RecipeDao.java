package it.corso.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.corso.model.Recipe;

public interface RecipeDao extends CrudRepository<Recipe, Integer>{

	@Query(value = "select max(id_recipe) from recipes", nativeQuery = true)
	int getLastId();
}
