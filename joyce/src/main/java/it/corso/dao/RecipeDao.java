package it.corso.dao;

import org.springframework.data.repository.CrudRepository;

import it.corso.model.Recipe;

public interface RecipeDao extends CrudRepository<Recipe, Integer>{

}
