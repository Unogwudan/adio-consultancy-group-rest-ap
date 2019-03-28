package com.unogwudan.resources;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unogwudan.entities.Applicants;
import com.unogwudan.entities.Reponse;
import com.unogwudan.repositories.ApplicationRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicationResource {
	
	@Autowired
	private ApplicationRepository repository;
	private ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value="upload", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Reponse> apply(
			@RequestParam(required = true, value="resume") MultipartFile resume,
			@RequestParam(required = true, value="passport") MultipartFile passport,
			@RequestParam(required = true, value="model") String model) throws JsonParseException, JsonMappingException, IOException {
		
		List<Applicants> applicants = repository.findAll();
		
		if(applicants.size() > 3) {
			return new ResponseEntity<>(new Reponse(-1, "Application Closed"), HttpStatus.FORBIDDEN);
		} else {
			File resumeFile = new File("/home/unogwudan/uploads/" + resume.getOriginalFilename() + new Date());
			resumeFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(resumeFile);
			fout.write(resume.getBytes());
			fout.close();
			
			File passportFile = new File("/home/unogwudan/uploads/" + passport.getOriginalFilename() + new Date());
			passportFile.createNewFile();
			FileOutputStream fout1 = new FileOutputStream(passportFile);
			fout1.write(passport.getBytes());
			fout1.close();
			
			System.out.println(passportFile.getAbsolutePath());
			System.out.println(resumeFile.getAbsolutePath());
			
			Applicants applicant = mapper.readValue(model, Applicants.class);
			applicant.setPassport(passportFile.getAbsolutePath());
			applicant.setResume(resumeFile.getAbsolutePath());
			repository.save(applicant);
			return new ResponseEntity<>(new Reponse(201, "Successful"), HttpStatus.CREATED);
		}

	}
	
	@GetMapping
	public List<Applicants> findAll() {
		return repository.findAll();
	}
	
//	@PostMapping
//	public ResponseEntity<String> apply(@RequestBody Applicants applicant) {
//		List<Applicants> applicants = repository.findAll();
//		if(applicants.size() > 3) {
//			return new ResponseEntity<>("Application Closed!", HttpStatus.FORBIDDEN);
//		} else {
//			repository.save(applicant);
//			return new ResponseEntity<>("Successful", HttpStatus.OK);
//		}
//	}

}
