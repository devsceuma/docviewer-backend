package br.com.docviewer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class Project {

	@Id
	private Integer id;
	
	private String url;
	private String name;
	
	public Project() {

	}
	
	public Project(String url, String name) {
		this.url = url;
		this.name = name;
	}

	
	
}
