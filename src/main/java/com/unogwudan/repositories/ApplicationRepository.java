package com.unogwudan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unogwudan.entities.Applicants;

@Repository
public interface ApplicationRepository extends JpaRepository<Applicants, Integer> {

}
