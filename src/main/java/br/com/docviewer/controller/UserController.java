package br.com.docviewer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.docviewer.CryptUtil;
import br.com.docviewer.model.User;
import br.com.docviewer.repository.UserRepository;

@RestController
@RequestMapping(value="/user-api")
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository repositoryUser;
	
	@RequestMapping(method=RequestMethod.GET,value="/save"/*, consumes={"application/json"}*/)
	public void save(/*@Valid @RequestBody User user*/){
		try{
			repositoryUser.save(new User("Marcus", "markiing", CryptUtil.ConvertToMD5("123"), "mvcartagenes@gmail.com"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/login",headers="Accept=application/json")
	public @ResponseBody User login(HttpServletResponse response, HttpServletRequest request){
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = repositoryUser.findByUsernameAndPassword(username, password);
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
}
