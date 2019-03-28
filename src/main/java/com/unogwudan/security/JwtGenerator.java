package com.unogwudan.security;

import org.springframework.stereotype.Component;

import com.unogwudan.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
				.setSubject(jwtUser.getUsername());
				claims.put("role", jwtUser.getRole());
				claims.put("id", jwtUser.getId());
				
		return Jwts.builder().setClaims(claims)
		.signWith(SignatureAlgorithm.HS512, "adio")
		.compact();
	}

}
