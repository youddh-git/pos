package com.hospisoft.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.dto.UserTypeDTO;
import com.hospisoft.store.model.Store;
import com.hospisoft.store.model.UserType;
import com.hospisoft.store.repository.StoreRepository;
import com.hospisoft.store.repository.UserTypeRepository;
import com.hospisoft.store.service.StoreService;
import com.hospisoft.store.service.UserTypeService;

@Service
public class UserTypeServiceImpl implements UserTypeService {
	@Autowired
	private UserTypeRepository userTypeRepository;

	@Override
	public List<UserType> userTypes() throws Exception {
		// TODO Auto-generated method stub
		return userTypeRepository.findAll();
	}

	@Override
	public UserType saveUserType(UserType store) throws Exception {
		// TODO Auto-generated method stub
		return userTypeRepository.save(store);
	}

	@Override
	public void deleteUserType(UserType store) throws Exception {
		// TODO Auto-generated method stub
		try {
			userTypeRepository.delete(store);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public UserType findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (userTypeRepository.findById(id).isPresent()) {
			return userTypeRepository.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<UserType> findByUserTypeName(String storeName) throws Exception {
		// TODO Auto-generated method stub
		return userTypeRepository.findByUserTypeName(storeName);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		try {
			userTypeRepository.deleteById(id);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public DataTablesOutput<UserTypeDTO> userTypesDataTable(DataTablesInput datatable_input) throws Exception {
		try {
			// TODO Auto-generated method stub
			return userTypeRepository.getUserTypeDataTable(datatable_input);// approverRepository.findAll(input);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
