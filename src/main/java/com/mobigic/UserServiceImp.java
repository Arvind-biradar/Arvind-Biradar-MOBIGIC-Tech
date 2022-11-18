package com.mobigic;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.mobigic.payloads.UserDto;
import com.mobigic.repositories.UserRepo;
import com.mobigic.services.UserService1;
import com.mobigic.entities.User;

@Service
public class UserServiceImp implements UserService1{

	@Autowired
	private UserRepo userepo;
	
	@Override
	public UserDto createUser(UserDto user) {
		// TODO Auto-generated method stub
		
		User user1=this.UserDtoToUser(user);
		User savedUser=this.userepo.save(user1);
		return this.UserToUserDto(savedUser);
	}
	
	
	@Override
	public boolean checkExist(String username) {
				
		
		return this.userepo.findByusername(username)!=null;
	}

	@Override
	public User getUserById(String username) {
		System.out.println("User Is");
		System.out.println(username);
		return this.userepo.findByusername(username);
	}

	User UserDtoToUser(UserDto user) {
		
		User user1=new User();
		user1.setPassword(user.getPassword());
		user1.setUsername(user.getUsername());
		
			return user1;
		
	}
	UserDto UserToUserDto(User user) {
		
		UserDto user1=new UserDto();
		user1.setPassword(user.getPassword());
		user1.setUsername(user.getUsername());
		
			return user1;		
	}


	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User validate(UserDto dto) {
//		
		User user=getUserById(dto.getUsername());
		
		System.out.println(dto.getPassword()+"=="+user.getPassword());
		if(dto.getPassword().equals(user.getPassword())  ) {
			return user;
		}else {
			return null;
		}
	}




	
}
