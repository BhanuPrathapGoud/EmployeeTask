package com.masai.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.mdel.Tasks;

@Repository
public interface TasksDao extends JpaRepository<Tasks , Integer >{

	
	
	
}
