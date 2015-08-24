package com.doing.server.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User {
//fullname , role, email, phone1, phone2, password, photo, xlocation, ylocation, companyid
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "role" )
	private Integer role;
	
	@Size(min=3, max=50)
	@Column(name = "email")
	private String email;
	
	@Size(min=3, max=50)
	@Column(name = "phone1")
	private String phone1;
	
	@Size(min=3, max=50)
	@Column(name = "phone2")
	private String phone2;
	
	@Size(min=3, max=50)
	@Column(name = "password")
	private String password;

	@Size(min=3, max=50)
	@Column(name = "photo")
	private String photo;

	@Column(name = "xlocation")
	private Double xlocation;
	
	@Column(name = "ylocation")
	private Double ylocation;
	
	@Column(name = "companyid")
	private Integer companyid;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Double getXlocation() {
		return xlocation;
	}

	public void setXlocation(Double xlocation) {
		this.xlocation = xlocation;
	}

	public Double getYlocation() {
		return ylocation;
	}

	public void setYlocation(Double ylocation) {
		this.ylocation = ylocation;
	}

	public Integer getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + fullname + "" +"]";
	}
	
	
	

}
