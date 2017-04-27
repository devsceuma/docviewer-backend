package br.com.docviewer.repository;

import br.com.docviewer.model.User;

public interface UserRepository {

	void save(User user) throws Exception;
	User findByUsernameAndPassword(String username,String password) throws Exception;
}
