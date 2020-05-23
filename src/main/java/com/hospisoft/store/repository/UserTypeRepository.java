package com.hospisoft.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospisoft.store.model.UserType;

public interface UserTypeRepository  extends JpaRepository<UserType, Integer>,GenericRepository {
	
	List<UserType> findAll();
	List<UserType> findByUserTypeName(String storeName);
	void deleteById(Integer id);
}
