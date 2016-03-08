package com.icoding.core.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icoding.core.config.TableConstant;

@Entity
@Table(name = TableConstant.USER_TBL)
public class User extends BaseEntity {

	private static final long serialVersionUID = -6465079670905085087L;

	@Column(name = "username")
	private String username;

	@Column(name = "password", length = 65)
	@JsonIgnore
	private String password;

	@Column(name = "firstname", length = 50)
	private String firstName;

	@Column(name = "lastname", length = 50)
	private String lastName;

	@Column(name = "birthDay")
	private Date birthDay;

	@Column(name = "photo", length = 100)
	private String photo;

	@Column(name = "gender", length = 1)
	private String gender = "0";

	@Column(name = "status", length = 1)
	private String status = "0";

	@Column(name = "email")
	private String email;

	@Column(name = "address", length = 255)
	private String address;

	@Column(name = "skype", length = 50)
	private String skype;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "mobile", length = 20)
	private String mobile;

	@Column(name = "introduction", length = 1000)
	private String introduction;

	@ManyToOne
	@JoinColumn(name = "createdBy")
	private User createdBy;

	@ManyToOne
	@JoinColumn(name = "role")
	private Role role;

	@Column(name = "is_root", length = 1)
	private String isRoot = "1";
}
