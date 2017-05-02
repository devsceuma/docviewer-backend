package br.com.docviewer.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docviewer.model.User;
import br.com.docviewer.repository.UserRepository;
import br.com.docviewer.util.CryptUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User getById(Serializable id) {
		return userRepository.findOne((Integer) id);
	}

	@Override
	public Iterable<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(User id) {
		userRepository.delete(id);
		
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) throws Exception {
		return userRepository.findByUsernameAndPassword(username, CryptUtil.ConvertToMD5(password));
	}
	
	

}
