package in.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.login.entity.Login;
import in.login.repository.LoginRepository;
import jakarta.validation.Valid;

@RestController
public class LoginController {
	
	@Autowired
   private LoginRepository loginrepo;
	
	
	
	// fetch single record
	@GetMapping("/fetchSingle/{id}")
	public Login getLogin(@PathVariable Long id) {
		Login login= loginrepo.findById(id).get(); 
		return login;
	}
	//fetch all data
	@GetMapping("/allData")
	public List<Login> AllLog(){
		List<Login> login= loginrepo.findAll();
		return login;
		
	}
	// creating record
	@PostMapping("/saveLogin")
	public Login createLogin(@Valid @RequestBody Login login){
		 loginrepo.save(login);
		return login;
	}
	// Delete login data by id
	@DeleteMapping("/deleteLogin/{id}")
	public String deleteLogin(@PathVariable Long id) {
		Login login= loginrepo.findById(id).get();
		if(login!=null) 
			loginrepo.delete(login);
		return "Delete successfully";
	}

}
