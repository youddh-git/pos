package com.hospisoft.store.dto;

import java.util.Date;

public class StoreDTO {	
	private Integer id;
	private String storeName;
	private boolean isActive;
	private Date created;
	
	public StoreDTO() {
		super();
	}
	public StoreDTO(Integer id, String storeName, boolean isActive, Date created) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.isActive = isActive;
		this.created = created;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
