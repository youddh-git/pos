package com.hospisoft.store.model;

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

import com.hospisoft.store.dto.UserTypeDTO;

@SqlResultSetMappings({ @SqlResultSetMapping(name = "getUserTypeDataTable", classes = {
		@ConstructorResult(targetClass = UserTypeDTO.class, columns = { @ColumnResult(name = "id", type = Integer.class),
				@ColumnResult(name = "usertypename", type = String.class),
				@ColumnResult(name = "usertype", type = Integer.class),
				@ColumnResult(name = "isactive", type = Boolean.class)
		}) 
	})

})

@Entity
@Table(name = "usertype")
public class UserType {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "usertypename", nullable = false)
	private String userTypeName;

	@Column(name = "usertype", nullable = false)
	private int userType;

	@Column(name = "isactive", nullable = false)
	private boolean isActive;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
