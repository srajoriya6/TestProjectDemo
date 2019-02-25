package com.raystech.proj0.service;

import java.util.List;

import com.raystech.proj0.dto.CollegeDTO;

public interface CollegeServiceInt {
	public long add(CollegeDTO dto);

	public void update(CollegeDTO dto);

	public void delete(long pk);

	public CollegeDTO findByPK(long pk);

	public List search(CollegeDTO dto);

	
	public List search(CollegeDTO dto, int pageNo, int pageSize);

}
