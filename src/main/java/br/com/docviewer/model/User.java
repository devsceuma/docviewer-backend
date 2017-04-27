package br.com.docviewer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	
	@Id
	private String id;
	
	private String name;
	private String username;
	private String password;
	private String email;

	public User() {
	
	}
	
	public User(String name, String username, String password, String email) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
}
