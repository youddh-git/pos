package com.hospisoft.store.constants;

public interface QueryConstants {
	public static final String GET_STORE_DATA_TABLE = "SELECT s.id,s.storename,s.isactive,s.created FROM store s " + 
			"WHERE s.storename LIKE :search  " + 
			"ORDER BY s.id ASC LIMIT :length OFFSET :start ";
	public static final String GET_STORE_DATA_TABLE_COUNT = "SELECT COUNT(s.id) as total FROM store s " + 
			"WHERE s.storename LIKE :search  ";
	
	public static final String GET_USER_TYPE_DATA_TABLE = "SELECT s.id,s.storename,s.isactive,s.created FROM store s " + 
			"WHERE s.storename LIKE :search  " + 
			"ORDER BY s.id ASC LIMIT :length OFFSET :start ";
	public static final String GET_USER_TYPE_DATA_TABLE_COUNT = "SELECT COUNT(s.id) as total FROM store s " + 
			"WHERE s.storename LIKE :search  ";

}
