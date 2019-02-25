package com.raystech.proj0.dao;

import java.util.List;

import com.raystech.proj0.dto.CollegeDTO;

public interface CollegeDAOInt {
	public long add(CollegeDTO dto);

	public void update(CollegeDTO dto);

	public void delete(CollegeDTO dto);

	public List search(CollegeDTO dto);

	public List search(CollegeDTO dto, int pageNo, int pageSize);

	public CollegeDTO findByPK(long pk);
}
