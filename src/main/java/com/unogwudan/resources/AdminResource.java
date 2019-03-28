package com.unogwudan.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unogwudan.entities.Admin;
import com.unogwudan.repositories.AdminRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminResource {
	
	@Autowired
	private AdminRepository repository;

	@GetMapping("admin")
	public List<Admin> getAdmins() {
		return repository.findAll();
	}
}
