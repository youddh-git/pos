package com.hospisoft.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospisoft.store.model.Store;

public interface StoreRepository  extends JpaRepository<Store, Integer>,GenericRepository {
	
	
	List<Store> findByStoreName(String storeName);
	void deleteById(Integer id);
}
