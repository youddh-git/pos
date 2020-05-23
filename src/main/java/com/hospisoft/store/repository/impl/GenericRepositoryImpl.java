package com.hospisoft.store.repository.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.hospisoft.store.constants.QueryConstants;
import com.hospisoft.store.dto.StoreDTO;
import com.hospisoft.store.dto.UserTypeDTO;
import com.hospisoft.store.repository.GenericRepository;

public class GenericRepositoryImpl implements GenericRepository {

	@PersistenceContext
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}
	
	@Override	
	public DataTablesOutput<StoreDTO> getStoreDataTable(DataTablesInput datatable_input) {
		try {
			// TODO Auto-generated method stub
			List<StoreDTO> stores = null;
			StringBuilder sbQuery = new StringBuilder(QueryConstants.GET_STORE_DATA_TABLE);
			Query query = getEntityManager().createNativeQuery(sbQuery.toString(),"getStoreDataTable");			
			query.setParameter("start", datatable_input.getStart());		
			query.setParameter("length", datatable_input.getLength());
			query.setParameter("search", datatable_input.getSearch().getValue()+"%");
			stores = query.getResultList();
			
			sbQuery = new StringBuilder(QueryConstants.GET_STORE_DATA_TABLE_COUNT);
			query = getEntityManager().createNativeQuery(sbQuery.toString());
			query.setParameter("search", datatable_input.getSearch().getValue()+"%");
			Long count = ((BigInteger)query.getResultList().get(0)).longValueExact();
			DataTablesOutput<StoreDTO> dataTablesOutput = new DataTablesOutput<StoreDTO>();
			dataTablesOutput.setData(stores);
			dataTablesOutput.setDraw(datatable_input.getDraw());
			dataTablesOutput.setRecordsFiltered(count);
			dataTablesOutput.setRecordsTotal(count);
						
			return dataTablesOutput;		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	@Override	
	public DataTablesOutput<UserTypeDTO> getUserTypeDataTable(DataTablesInput datatable_input) {
		try {
			// TODO Auto-generated method stub
			List<UserTypeDTO> userTypeDTOs = null;
			StringBuilder sbQuery = new StringBuilder(QueryConstants.GET_STORE_DATA_TABLE);
			Query query = getEntityManager().createNativeQuery(sbQuery.toString(),"getStoreDataTable");			
			query.setParameter("start", datatable_input.getStart());		
			query.setParameter("length", datatable_input.getLength());
			query.setParameter("search", datatable_input.getSearch().getValue()+"%");
			userTypeDTOs = query.getResultList();
			
			sbQuery = new StringBuilder(QueryConstants.GET_STORE_DATA_TABLE_COUNT);
			query = getEntityManager().createNativeQuery(sbQuery.toString());
			query.setParameter("search", datatable_input.getSearch().getValue()+"%");
			Long count = ((BigInteger)query.getResultList().get(0)).longValueExact();
			DataTablesOutput<UserTypeDTO> dataTablesOutput = new DataTablesOutput<UserTypeDTO>();
			dataTablesOutput.setData(userTypeDTOs);
			dataTablesOutput.setDraw(datatable_input.getDraw());
			dataTablesOutput.setRecordsFiltered(count);
			dataTablesOutput.setRecordsTotal(count);
						
			return dataTablesOutput;		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
