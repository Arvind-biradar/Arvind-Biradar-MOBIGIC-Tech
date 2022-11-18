package com.mobigic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mobigic.entities.Filedata;
import com.mobigic.entities.User;

@Repository
public interface FileStorage extends JpaRepository<Filedata, Integer>{

	List<Filedata> findByUser(User user);
	
}
