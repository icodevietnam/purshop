package com.icoding.core.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icoding.core.config.TableConstant;

@Entity
@Table(name = TableConstant.ROLE_TBL)
public class Role extends BaseEntity {

	private static final long serialVersionUID = 8136917216433316968L;

	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name= "description",length = 255)
	private String description;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "role")
	@Fetch(FetchMode.SELECT)
	private Set<User> listUsers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getListUsers() {
		return listUsers;
	}

	public void setListUsers(Set<User> listUsers) {
		this.listUsers = listUsers;
	}

}
