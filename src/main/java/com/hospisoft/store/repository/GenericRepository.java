package com.hospisoft.store.repository;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.dto.UserTypeDTO;

public interface GenericRepository {
	
	DataTablesOutput<StoreDTO> getStoreDataTable(DataTablesInput datatable_input);
	DataTablesOutput<UserTypeDTO> getUserTypeDataTable(DataTablesInput datatable_input);
}
