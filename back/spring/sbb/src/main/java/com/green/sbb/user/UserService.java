package com.green.sbb.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	// 유저 생성
	public SiteUser createUser(String username, String password, String email) {
		
		SiteUser user = new SiteUser();
		user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
		user.setEmail(email);
		this.userRepository.save(user);
		
		return user;
	}
	
}
