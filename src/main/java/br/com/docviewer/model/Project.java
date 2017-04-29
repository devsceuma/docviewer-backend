package br.com.docviewer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projects")
public class Project {

	@Id
	private String id;
	
	private String url;
	private String name;
	
	public Project() {

	}
	
	public Project(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getName() {
		return name;
	}

	
	
}
