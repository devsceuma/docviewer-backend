package br.com.docviewer.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.docviewer.CryptUtil;
import br.com.docviewer.model.Project;
import br.com.docviewer.model.User;
import br.com.docviewer.repository.UserRepository;

@RestController
@RequestMapping(value="/user-api")
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository repositoryUser;
	
	@RequestMapping(method=RequestMethod.POST,value="/save", consumes={"application/json"})
	public ResponseEntity<User> save(@Valid @RequestBody User user) throws Exception{
		try{
			repositoryUser.save(user);
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception("Usuário já existe na base de dados");
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
	
	@RequestMapping(method=RequestMethod.GET,value="/findAllUsers",headers="Accept=application/json")
	public @ResponseBody List<User> getAllUsers() throws Exception{
		try{
			return repositoryUser.getAll();
		}catch(Exception ex){
			throw new Exception("Houve um problema ao carregar os usuários. Tente novamente mais tarde");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/remove", consumes={"application/json"})
	public <T> ResponseEntity<T> remove(@Valid @RequestBody User user) throws Exception{
		try{
			repositoryUser.delete(user);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update", consumes={"application/json"})
	public <T> ResponseEntity<T> update(@Valid @RequestBody User user) throws Exception{
		try{
			
			repositoryUser.update(user);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
/*	
	private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("cache-control", "no-cache");
        headers.add("Access-Control-Allow-Methods","GET, POST, PATCH, PUT, DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers","Origin, Content-Type, X-Auth-Token");
        headers.add("content-type","application/json;charset=utf-8;text/plain");
        return headers;
    }*/
}
