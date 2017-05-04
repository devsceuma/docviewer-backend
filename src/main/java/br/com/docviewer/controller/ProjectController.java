package br.com.docviewer.controller;


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

import br.com.doceasier.app.DocEasier;
import br.com.doceasier.enumerators.TypeRequest;
import br.com.doceasier.model.annotations.DocClass;
import br.com.doceasier.model.annotations.DocIgnore;
import br.com.doceasier.model.annotations.DocMethod;
import br.com.doceasier.model.annotations.DocParam;
import br.com.doceasier.model.annotations.EnableDocumentation;
import br.com.docviewer.model.Project;
import br.com.docviewer.service.ProjectService;

@RestController
@RequestMapping(value="/project-api")
@EnableDocumentation
@CrossOrigin
@DocClass(createdBy="Marcus Cartágenes",date="30/04/2017",description="Controller para requisições do Projeto",url="/project-api")
@br.com.doceasier.model.annotations.Project(description="Backend do DocViewer",masterUrl="http://localhost:8080/docViewer",name="DocViewer Backend")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(method=RequestMethod.POST,value="/save", consumes={"application/json"})
	@DocMethod(createdBy="Marcus Cartágenes",date="30/03/2017",description="Método para salvar novo Projeto",onSucess=Project.class,typeRequest=TypeRequest.POST,url="/save")
	public ResponseEntity<Project> save(@Valid @RequestBody @DocParam(description="Projeto populado para ser salvo",optional=false)Project project) throws Exception{
		try{
			projectService.save(project);
			return new ResponseEntity<Project>(project,HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findAllProjects",headers="Accept=application/json")
	@DocMethod(createdBy="Marcus Cartágenes",
	date="30/03/2017",
	description="Listar todos os projetos cadastrados",onSucess=Project.class,typeRequest=TypeRequest.GET,url="/findAllProjects")
	public @ResponseBody Iterable<Project> getAllProjects() throws Exception{
		try{
			return projectService.getAll();
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/remove", consumes={"application/json"})
	@DocMethod(createdBy="Marcus Cartágenes",date="30/04/2017",description="Remover projeto",onSucess=Project.class,typeRequest=TypeRequest.GET,url="/remove")
	public <T> ResponseEntity<T> remove(@Valid @RequestBody Project project) throws Exception{
		try{
			projectService.delete(project);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update", consumes={"application/json"})
	@DocMethod(createdBy="Alterar projeto",date="30/04/2017",description="Alterar dados do projeto",onSucess=Project.class,typeRequest=TypeRequest.GET,url="/update")
	public <T> ResponseEntity<T> update(@Valid @RequestBody Project project) throws Exception{
		try{
			projectService.save(project);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(method=RequestMethod.GET,value="/getDocs")
	@DocIgnore
	public <T>ResponseEntity<T> getDocumentation() throws Exception{
		try{
			br.com.doceasier.model.meta.Project project = (br.com.doceasier.model.meta.Project) DocEasier.generateDocs();
			return new ResponseEntity<T>((T) project,HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

}
