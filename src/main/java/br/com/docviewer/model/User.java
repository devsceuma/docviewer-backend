package br.com.docviewer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="CODIGO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="USERNAME",unique=true)
	private String username;
	
	@Column(name="PASSOWRD")
	private String password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ORGANIZATION")
	private String organization;
	
	@Column(name="JOB")
	private String job;
	
	@Column(name="PROFILE")
	private String profile;
	
	@ManyToMany(cascade= {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.REMOVE})
	@JoinTable(name="user_has_projects",joinColumns={@JoinColumn()}, inverseJoinColumns={@JoinColumn()})
	private List<Project> projects;

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
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public List<Project> getProjects() {
		return projects;
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

	
	public String getOrganization() {
		return organization;
	}

	public String getJob() {
		return job;
	}



	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public void setJob(String job) {
		this.job = job;
	}

	
	public Serializable getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
}
