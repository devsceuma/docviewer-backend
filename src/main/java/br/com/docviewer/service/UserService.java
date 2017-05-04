package br.com.docviewer.service;

import br.com.docviewer.model.User;

public interface UserService extends CRUDService<User>{

	User findByUsernameAndPassword(String username, String password) throws Exception;
}
