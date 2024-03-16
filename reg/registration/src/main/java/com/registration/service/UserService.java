package com.registration.service;

import com.registration.dto.UserDto;
import com.registration.model.User;

public interface UserService {
	User save(UserDto userDto);
}
