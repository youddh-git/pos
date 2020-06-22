package com.hospisoft.store.service;

import com.hospisoft.store.model.User;

public interface UserService {
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	
	User findByUserName(String userName) throws Exception;
}
