package br.com.docviewer.repository;

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
		mongoTemplate.save(user);

		
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) throws Exception {
		Query query = new Query();
		query.addCriteria(Criteria.where("username").is(username).and("password").is(CryptUtil.ConvertToMD5(password)));
		return mongoTemplate.findOne(query, User.class);
	}

}
