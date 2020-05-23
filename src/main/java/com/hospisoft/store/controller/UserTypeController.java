package com.hospisoft.store.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospisoft.store.dto.UserTypeDTO;
import com.hospisoft.store.model.UserType;
import com.hospisoft.store.service.UserTypeService;

@RestController
//@CrossOrigin(origins = "${app.api.settings.cross-origin.urls}")
@CrossOrigin(origins="*")
@RequestMapping("/usertypes")
public class UserTypeController {
	
	@Autowired
	UserTypeService userTypeService;

	@GetMapping(value = "")
	public ResponseEntity<?> userTypeList() {
		try {
			List<UserType> storeList = userTypeService.userTypes();
			if (!CollectionUtils.isEmpty(storeList)) {
				return new ResponseEntity<Object>(storeList, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("", HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(value = "")
	public  ResponseEntity<?> approvalList(@Valid @RequestBody DataTablesInput dataTablesInput) {
		try {
			DataTablesOutput<UserTypeDTO> storeList = userTypeService.userTypesDataTable(dataTablesInput);
			return new ResponseEntity<Object>(storeList, HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "/save")
	public ResponseEntity<?> saveStore(@RequestBody UserType userType) {
		try {
			UserType userTypeObject = userTypeService.saveUserType(userType);
			if (userTypeObject != null) {
				return new ResponseEntity<Object>(userTypeObject, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Object>(0, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteStore(@PathVariable("id") Integer id) {
		try {
			userTypeService.deleteById(id);			
			return new ResponseEntity<Object>(id, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
