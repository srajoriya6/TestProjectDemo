package com.raystech.proj0.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raystech.proj0.dto.CollegeDTO;

@Repository("collegeDao")
public class CollegeDAOHibImpl implements CollegeDAOInt {

	/**
	 * Object of SessionFactory
	 */
	@Autowired
	SessionFactory sessionFactory = null;

	@Override
	public long add(CollegeDTO dto) {
		System.out.println("College dao start========================================================================");
		long pk = (long) sessionFactory.getCurrentSession().save(dto);
		System.out.println("College dao END========================================================================");
		return pk;
	}

	@Override
	public void update(CollegeDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	@Override
	public void delete(CollegeDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	@Override
	public CollegeDTO findByPK(long pk) {
		System.out.println("Collge dao findby pk start");
		CollegeDTO dto = null;
		List list = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class).add(Restrictions.eq("id", pk))
				.list();
		if (list.size() == 1) {
			dto = (CollegeDTO) list.get(0);
		}
		System.out.println("Collge dao findby pk end");
		return dto;
	}

	@Override
	public List search(CollegeDTO dto) {
		return search(dto, 0, 0);
	}

	@Override
	public List search(CollegeDTO dto, int pageNo, int pageSize) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CollegeDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getAddress() != null && dto.getAddress().length() > 0) {
				criteria.add(Restrictions.like("address", dto.getAddress() + "%"));
			}
		}

		List list = criteria.list();
		return list;

	}

}
