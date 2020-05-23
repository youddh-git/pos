package com.hospisoft.store.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.hospisoft.store.dto.UserTypeDTO;
import com.hospisoft.store.model.UserType;

public interface UserTypeService {
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<UserType> userTypes() throws Exception;
	DataTablesOutput<UserTypeDTO> userTypesDataTable(DataTablesInput dataTablesInput) throws Exception;
	UserType saveUserType(UserType UserType) throws Exception;
	void deleteUserType(UserType UserType) throws Exception;
	void deleteById(Integer id);
	UserType findById(Integer id) throws Exception;
	List<UserType> findByUserTypeName(String UserTypeName) throws Exception;
}
