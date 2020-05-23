package com.hospisoft.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.model.Store;
import com.hospisoft.store.repository.StoreRepository;
import com.hospisoft.store.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreRepository approverRepository;

	@Override
	public List<Store> stores() throws Exception {
		// TODO Auto-generated method stub
		return approverRepository.findAll();
	}

	@Override
	public Store saveStore(Store store) throws Exception {
		// TODO Auto-generated method stub
		return approverRepository.save(store);
	}

	@Override
	public void deleteStore(Store store) throws Exception {
		// TODO Auto-generated method stub
		try {
			approverRepository.delete(store);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public Store findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		if (approverRepository.findById(id).isPresent()) {
			return approverRepository.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public List<Store> findByStoreName(String storeName) throws Exception {
		// TODO Auto-generated method stub
		return approverRepository.findByStoreName(storeName);
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		try {
			approverRepository.deleteById(id);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public DataTablesOutput<StoreDTO> storesDataTable(DataTablesInput datatable_input) throws Exception {
		try {
			// TODO Auto-generated method stub
			return approverRepository.getStoreDataTable(datatable_input);// approverRepository.findAll(input);		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	

}
