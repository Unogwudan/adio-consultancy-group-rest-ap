package com.unogwudan.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Applicants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String surname;
	private String phoneNumber;
	private String email;
	private String coverLetter;
	private String resume;
	private String passport;

	
	public Applicants() {
		super();
	}

	public Applicants(String firstName, String surname, String phoneNumber, String email, String coverLetter) {
		super();
		this.firstName = firstName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.coverLetter = coverLetter;
	}
	
//	public Applicants(Integer id, String firstName, String surname, String phoneNumber, String email, String resume,
//			String passport, String coverLetter) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.surname = surname;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.coverLetter = coverLetter;
//		this.resume = resume;
//		this.passport = passport;
//	}
	
//	public Applicants(Integer id, String firstName, String surname) {
//		super();
//		this.id = id;
//		this.firstName = firstName;
//		this.surname = surname;
//	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	
}
