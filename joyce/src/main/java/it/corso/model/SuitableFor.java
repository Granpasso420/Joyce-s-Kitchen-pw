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
@Table (name="suitable_for")
public class SuitableFor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_suitable_for;
	
	
	@Pattern(regexp = "[a-zA-Z\\s'.]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "description", length = 50, nullable = false)
	private String description;
	
	@OneToOne(mappedBy = "suitablefor", cascade = CascadeType.ALL)  
	private Recipe recipes;

	public int getId_suitable_for() {
		return id_suitable_for;
	}

	public void setId_suitable_for(int id_suitable_for) {
		this.id_suitable_for = id_suitable_for;
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
