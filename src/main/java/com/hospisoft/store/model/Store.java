package com.hospisoft.store.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hospisoft.store.dto.StoreDTO;

@SqlResultSetMappings({ @SqlResultSetMapping(name = "getStoreDataTable", classes = {
		@ConstructorResult(targetClass = StoreDTO.class, columns = { 
				@ColumnResult(name = "id", type = Integer.class),
				@ColumnResult(name = "storename", type = String.class),
				@ColumnResult(name = "isactive", type = Boolean.class),
				@ColumnResult(name = "created", type = Date.class) }) }), 
	})

@Entity
@Table(name = "store")
public class Store {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "storename", nullable = false)
	private String storeName;

	@Column(name = "isactive", nullable = false)
	private boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created", nullable = false)
	private Date created;

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

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
