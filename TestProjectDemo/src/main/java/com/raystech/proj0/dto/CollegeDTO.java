package com.raystech.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "st_college")
public class CollegeDTO extends BaseDTO {
	/**
	 * Name of College
	 */
	@Column(name = "NAME")
	private String name;
	/**
	 * Address of College
	 */
	@Column(name = "ADDRESS")
	private String address;

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
