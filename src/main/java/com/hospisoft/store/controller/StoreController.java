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

import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.model.Store;
import com.hospisoft.store.service.StoreService;

@RestController
//@CrossOrigin(origins = "${app.api.settings.cross-origin.urls}")
@CrossOrigin(origins="*")
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	StoreService storeService;
	
	@GetMapping(value = "")
	public ResponseEntity<?> storeList() {
		try {
			List<Store> storeList = storeService.stores();
			if (!CollectionUtils.isEmpty(storeList)) {
				return new ResponseEntity<Object>(storeList, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(0, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "")
	public  ResponseEntity<?> approvalList(@Valid @RequestBody DataTablesInput dataTablesInput) {
		try {
			DataTablesOutput<StoreDTO> storeList = storeService.storesDataTable(dataTablesInput);
			return new ResponseEntity<Object>(storeList, HttpStatus.OK);			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "/save")
	public ResponseEntity<?> saveStore(@RequestBody Store store) {
		try {
			Store storeObject = storeService.saveStore(store);
			if (storeObject != null) {
				return new ResponseEntity<Object>(storeObject, HttpStatus.CREATED);
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
			storeService.deleteById(id);			
			return new ResponseEntity<Object>(id, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
