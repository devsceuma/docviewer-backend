package br.com.docviewer.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docviewer.model.Project;
import br.com.docviewer.repository.ProjectRepository;
import br.com.docviewer.repository.UserRepository;


@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Project save(Project entity) {
		return projectRepository.save(entity);
	}

	@Override
	public Project getById(Serializable id) {
		return projectRepository.findOne((Integer)id);
	}

	@Override
	public Iterable<Project> getAll() {
		return projectRepository.findAll();
	}

	@Override
	public void delete(Project project) {
		projectRepository.delete(project);
	}

}
