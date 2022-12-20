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
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp = "[a-zA-Z\\s]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "user", length = 50, nullable = false)
	private String user;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]+@[a-zA-Z\\s]+.[a-zA-Z\\s]+", message = "{error.charnotallowed}")
	@Column(name = "mail", length = 50, nullable = false)
	private String mail;
	
	@Pattern(regexp = "[a-zA-Z\\!]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, 
			fetch = FetchType.EAGER, orphanRemoval = true)   
	private List<Recipe> recipes = new ArrayList<>(); 
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	
}
