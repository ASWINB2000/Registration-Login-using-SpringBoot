package com.registration.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.registration.dto.UserDto;
import com.registration.model.User;
import com.registration.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository rep;
	
	private static final String DEFAULT_ROLE = "USER";
	@Override
	public User save(UserDto userDto) {
		 String role = userDto.getRole();
	        if (role == null || role.isEmpty()) {
	            role = DEFAULT_ROLE;
	        }
		User user=new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) ,role,userDto.getFullname());
		return rep.save(user);
	}
	
}
