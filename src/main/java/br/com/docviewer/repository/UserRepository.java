package br.com.docviewer.repository;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.docviewer.model.Project;
import br.com.docviewer.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Serializable> {
	
	@Modifying
	@SQLDelete(sql = "DELETE FROM user_has_projects")
	void projects(Project project);
	
	User findByUsernameAndPassword(String username,String password) throws Exception;
}
