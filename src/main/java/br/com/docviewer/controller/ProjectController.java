package br.com.docviewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.docviewer.model.Project;
import br.com.docviewer.repository.ProjectRepository;

@RestController
@RequestMapping(value="/project-api")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@RequestMapping(method=RequestMethod.POST,value="/save", consumes={"application/json"})
	public ResponseEntity<Project> save(@Valid @RequestBody Project project) throws Exception{
		try{
			projectRepository.save(project);
			return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findAllProjects",headers="Accept=application/json")
	public @ResponseBody List<Project> getAllProjects() throws Exception{
		try{
			return projectRepository.findAll();
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/remove", consumes={"application/json"})
	public <T> ResponseEntity<T> remove(@Valid @RequestBody Project project) throws Exception{
		try{
			projectRepository.remove(project);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update", consumes={"application/json"})
	public <T> ResponseEntity<T> update(@Valid @RequestBody Project project) throws Exception{
		try{
			projectRepository.update(project);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	

}
