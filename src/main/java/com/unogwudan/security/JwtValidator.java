package com.unogwudan.security;

import org.springframework.stereotype.Component;
import com.unogwudan.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {

	private String secret = "adio";
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
		Claims body = Jwts.parser()
		.setSigningKey(secret)
		.parseClaimsJws(token)
		.getBody();
		
		jwtUser = new JwtUser();
		jwtUser.setUsername(body.getSubject());
		jwtUser.setId(Integer.parseInt((String) body.get("id")));
        jwtUser.setRole((String) body.get("role"));
		} catch(Exception e) {
			System.out.println("Error " + e);
			e.printStackTrace();
		}
		return jwtUser;
	}
}
