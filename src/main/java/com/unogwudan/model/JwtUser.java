package com.unogwudan.model;

public class JwtUser {
	private String username;
    private String email;
    private int id;
    private String role;
    private String password;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }
 

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return "JwtUser{" + "userName=" + username + ", id=" + id + ", role=" + role + '}';
    }
    
}
