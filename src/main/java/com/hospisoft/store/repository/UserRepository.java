package com.hospisoft.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospisoft.store.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>,GenericRepository {
	User findByUserName(String userName);	
}
