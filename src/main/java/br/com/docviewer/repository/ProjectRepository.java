package br.com.docviewer.repository;

import java.util.List;

import br.com.docviewer.model.Project;

public interface ProjectRepository {

	void save(Project project) throws Exception;
	List<Project> findAll() throws Exception;
	void update(Project project) throws Exception;
	void remove(Project project) throws Exception;
}
