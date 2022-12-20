package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table (name="recipe_category")
public class RecipeCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_category;
	
	@Pattern(regexp = "[a-zA-Z\\s'.]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "description", length = 50, nullable = false)
	private String description;
	
	@OneToMany(
				mappedBy = "recipecategory",
				cascade = CascadeType.ALL,
				fetch = FetchType.EAGER,
				orphanRemoval = true
			)  
	private List<Recipe> recipes = new ArrayList<>();

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
