package com.mobigic.services;



import org.springframework.stereotype.Service;

import com.mobigic.entities.User;
import com.mobigic.payloads.UserDto;




public interface UserService1 {

	
	UserDto createUser(UserDto user);
	
    User findById(Integer userId);
    
    public boolean checkExist(String userid);

    User getUserById(String user);
    
	User validate(UserDto dto);

	
	
}
