package com.hospisoft.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospisoft.store.model.User;
import com.hospisoft.store.repository.UserRepository;
import com.hospisoft.store.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User findByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		User findByUserName = userRepository.findByUserName(userName);
		return findByUserName;
	}

	

	

}
