package com.unogwudan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unogwudan.entities.Admin;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>  {
	public Admin findByUsernameAndPassword(String username, String password);
}
