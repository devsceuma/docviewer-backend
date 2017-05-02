package br.com.docviewer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.docviewer.model.User;
import br.com.docviewer.repository.UserRepository;
import br.com.docviewer.service.UserService;

@RestController
@RequestMapping(value="/user-api")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/save", consumes={"application/json"})
	public ResponseEntity<User> save(@Valid @RequestBody User user) throws Exception{
		try{
			userService.save(user);
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
			User user = userService.findByUsernameAndPassword(username, password);
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findAllUsers",headers="Accept=application/json")
	public @ResponseBody Iterable<User> getAllUsers() throws Exception{
		try{
			return userService.getAll();
		}catch(Exception ex){
			throw new Exception("Houve um problema ao carregar os usuários. Tente novamente mais tarde");
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/remove", consumes={"application/json"})
	public <T> ResponseEntity<T> remove(@Valid @RequestBody User user) throws Exception{
		try{
			userService.delete(user);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/update", consumes={"application/json"})
	public <T> ResponseEntity<T> update(@Valid @RequestBody User user) throws Exception{
		try{
			userService.save(user);
			return new ResponseEntity<T>(HttpStatus.CREATED);
		}catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}
