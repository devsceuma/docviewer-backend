package br.com.docviewer.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="projects")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODIGO")
	private Integer id;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="NAME")
	private String name;
	
	@ManyToMany(mappedBy="projects")
	@Transient
	private List<User> user;
	
	public Project() {

	}
	
	public Project(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	
	
	public Serializable getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}
	
	public String getName() {
		return name;
	}
	
	
}
