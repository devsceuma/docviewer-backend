package br.com.docviewer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import br.com.docviewer.CryptUtil;
import br.com.docviewer.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(User user) throws Exception {
		user.setPassword(CryptUtil.ConvertToMD5(user.getPassword()));
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(user.getUsername()).and("password").is(user.getPassword()));
		User recoveredUser = mongoTemplate.findOne(query, User.class);
		
		if(recoveredUser == null){
			mongoTemplate.save(user);
		}else{
			throw new Exception("Usuário já existe na base de dados");
		}

		
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username).and("password").is(CryptUtil.ConvertToMD5(password)));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public List<User> getAll() throws Exception {
		return mongoTemplate.findAll(User.class);
	}

}
