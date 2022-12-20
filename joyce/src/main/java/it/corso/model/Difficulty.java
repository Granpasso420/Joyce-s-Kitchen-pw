package it.corso.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table (name="difficulty")
public class Difficulty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_difficulty;
	
	@Pattern(regexp = "[a-zA-Z\\s'.]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "description", length = 50, nullable = false)
	private String description;
	
	@OneToOne(mappedBy = "difficulty", cascade = CascadeType.ALL)  
	private Recipe recipes;

	public int getId_difficulty() {
		return id_difficulty;
	}

	public void setId_difficulty(int id_difficulty) {
		this.id_difficulty = id_difficulty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Recipe getRecipes() {
		return recipes;
	}

	public void setRecipes(Recipe recipes) {
		this.recipes = recipes;
	}
	
}
