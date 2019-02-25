package com.raystech.proj0.form;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpRequest;

import com.raystech.proj0.dto.BaseDTO;
import com.raystech.proj0.dto.CollegeDTO;

public class CollegeForm extends BaseForm {
	@NotEmpty(message = "can be empty")
	protected String name;
	/**
	 * Address of College
	 */
	@NotEmpty(message = "can be empty")
	protected String address;

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
	public BaseDTO getDto(HttpSession session) {
		System.out.println("get dto ====sss");
		CollegeDTO dto = new CollegeDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAddress(address);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		if (createdDatetime > 0) {
			System.out.println("11");
			dto.setCreatedDatetime(new Timestamp(createdDatetime));
		} else {
			dto.setCreatedDatetime(new Timestamp(new Date().getTime()));
		}
		dto.setModifiedDatetime(new Timestamp(new Date().getTime()));

		System.out.println("get dto ====end");
		return dto;

	}

	@Override
	public void populate(BaseDTO bDto) {
		CollegeDTO dto = (CollegeDTO) bDto;
		id = dto.getId();
		name = dto.getName();
		address = dto.getAddress();
		super.populate(bDto);
	}

}
