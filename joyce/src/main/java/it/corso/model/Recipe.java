package it.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table (name="recipes")
public class Recipe{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_recipe;
	
	@Pattern(regexp = "[a-zA-Z\\s']{1,50}", message = "{error.charnotallowed}")
	@Column(name = "recipe_name", length = 50, nullable = false)
	private String recipe_name;
	
	@Pattern(regexp = "[a-zA-Z\\s'.]", message = "{error.charnotallowed}")
	@Column(name = "ingredients", nullable = false)
	private String ingredients;
	
	@Pattern(regexp = "[a-zA-Z\\s'.]", message = "{error.charnotallowed}")
	@Column(name = "process", nullable = false)
	private String process;
	
	@Pattern(regexp = "[a-zA-Z]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "category", length = 50, nullable = true) 
	private String recipecategory;
	
	@Pattern(regexp = "[a-zA-Z\\s]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "time", length = 50, nullable = false)
	private String time;
	
	@Pattern(regexp = "[a-zA-Z]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "difficulty", length = 50, nullable = true) 
	private String difficulty;
	// FOTO
	
//	@Valid
//	@ManyToOne(cascade = CascadeType.REFRESH) 
//	@JoinColumn(name = "suitable_for", referencedColumnName = "id_suitable_for") 
//	private SuitableFor suitablefor;
//	
 
	
	
//	@ManyToOne (cascade = CascadeType.REFRESH)
//	@JoinColumn(name="author", referencedColumnName = "id")
//	private User user;

	public int getId_recipe() {
		return id_recipe;
	}

	public void setId_recipe(int id_recipe) {
		this.id_recipe = id_recipe;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	

//	public SuitableFor getSuitablefor() {
//		return suitablefor;
//	}
//
//	public void setSuitablefor(SuitableFor suitablefor) {
//		this.suitablefor = suitablefor;
//	}
//
	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
//
	public String getRecipecategory() {
		return recipecategory;
	}

	public void setRecipecategory(String recipecategory) {
		this.recipecategory = recipecategory;
	}

	

//	public User getUser() {
//		return user;
//	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	

	
}
