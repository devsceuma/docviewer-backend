package br.com.docviewer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import br.com.docviewer.model.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(Project project) throws Exception {
		try{
			mongoTemplate.save(project);
		}catch(Exception ex){
			throw new Exception("Ocorreu um problem ao salvar o projeto. Tente novamente mais tarde");
		}
	}

	@Override
	public List<Project> findAll() throws Exception {
		try{
			return mongoTemplate.findAll(Project.class);
		}catch(Exception ex){
			throw new Exception("Ocorreu um problema ao listar projetos. Tente novamente mais tarde");
		}
	}

	@Override
	public void update(Project project) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(project.getId()));
		Update update = new Update();
		
		update.set("url", project.getUrl());
		update.set("name", project.getName());
		
		mongoTemplate.updateFirst(query, update, Project.class);
	}

	@Override
	public void remove(Project project) throws Exception {
		try{
			mongoTemplate.remove(project);
		}catch(Exception ex){
			throw new Exception("Houve um problema ao deletar o projeto. Tente novamente mais tarde !");
		}
		
	}

}
