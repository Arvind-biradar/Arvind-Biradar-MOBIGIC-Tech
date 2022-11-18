package com.mobigic.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobigic.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	@Query(value = "select * from users where username=:username",nativeQuery = true)
	User findByusername(@Param("username") String username);
}
