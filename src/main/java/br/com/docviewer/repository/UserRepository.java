package br.com.docviewer.repository;

import java.util.List;

import br.com.docviewer.model.User;

public interface UserRepository {

	List<User> getAll() throws Exception;
	void save(User user) throws Exception;
	User findByUsernameAndPassword(String username,String password) throws Exception;
	void delete(User user)throws Exception;
	void update(User user)throws Exception;
}
