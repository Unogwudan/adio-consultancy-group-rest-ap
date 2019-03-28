package com.unogwudan.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unogwudan.entities.Admin;
import com.unogwudan.entities.Reponse;
import com.unogwudan.model.JwtUser;
import com.unogwudan.repositories.AdminRepository;
import com.unogwudan.security.JwtGenerator;

@RestController
@RequestMapping("token")
@CrossOrigin(origins = "http://localhost:3000")
public class TokenResource {

	private JwtGenerator generator;
	@Autowired
	private AdminRepository repository;
	
	TokenResource(JwtGenerator generator) {
		this.generator = generator;
	}
	
	@PostMapping
	public Reponse generate(@RequestBody Admin admin1) {
		System.out.println(admin1.getUsername() + " " + admin1.getPassword());
		Admin admin = repository.findByUsernameAndPassword(admin1.getUsername(), 
				admin1.getPassword());
		JwtUser jwtUser = new JwtUser();
		jwtUser.setId(admin.getId());
		jwtUser.setUsername(admin.getUsername());
		jwtUser.setRole(admin.getRole());
		
		String token =  generator.generate(jwtUser);
		
		return new Reponse(201, token);
	}
}
