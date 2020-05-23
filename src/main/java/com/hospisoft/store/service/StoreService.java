package com.hospisoft.store.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.model.Store;

public interface StoreService {
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Store> stores() throws Exception;
	DataTablesOutput<StoreDTO> storesDataTable(DataTablesInput dataTablesInput) throws Exception;
	Store saveStore(Store store) throws Exception;
	void deleteStore(Store store) throws Exception;
	void deleteById(Integer id);
	Store findById(Integer id) throws Exception;
	List<Store> findByStoreName(String storeName) throws Exception;
}
