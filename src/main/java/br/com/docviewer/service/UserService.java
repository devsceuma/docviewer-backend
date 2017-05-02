package br.com.docviewer.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.docviewer.model.User;

public interface UserService extends CRUDService<User>{

	User findByUsernameAndPassword(String username, String password) throws Exception;
}
