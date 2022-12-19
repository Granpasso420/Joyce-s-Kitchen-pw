package it.corso.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String name;
	
	@Pattern(regexp = "[a-zA-Z0-9\\s]+@[a-zA-Z\\s]+.[a-zA-Z\\s]+", message = "{error.charnotallowed}")
	@Column(name = "mail", length = 50, nullable = false)
	private String mail;
	
	@Pattern(regexp = "[a-zA-Z\\!]{1,50}", message = "{error.charnotallowed}")
	@Column(name = "password", length = 50, nullable = false)
	private String password;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}
