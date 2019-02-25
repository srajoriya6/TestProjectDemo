package com.raystech.proj0.rest;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raystech.proj0.ctl.BaseCtl;
import com.raystech.proj0.dto.CollegeDTO;
import com.raystech.proj0.form.CollegeForm;
import com.raystech.proj0.service.CollegeServiceInt;

/**
 * College RESTFull Web Service
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */
@Controller
@RequestMapping(value = "/rest/College")
public class CollegeRESTfullWS extends BaseCtl {

	/**
	 * Logger object
	 */
	private static Logger log = Logger.getLogger(CollegeRESTfullWS.class);

	/**
	 * College Service
	 */
	@Autowired
	private CollegeServiceInt service;

	/**
	 * Gets College information
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public CollegeDTO get(@PathVariable long id) {
		log.debug("CollegeCtl doDisplay() Start");
		CollegeDTO dto = service.findByPK(id);
		return dto;
	}

	/**
	 * Gets College list
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@ResponseBody
	public List getList(CollegeForm form, HttpSession session) {
		CollegeDTO dto = (CollegeDTO) form.getDto(session);
		return service.search(dto, form.getPageNo(), form.getPageSize());
	}

	/**
	 * Delete a College
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete/{id}")
	@ResponseBody
	public CollegeDTO delete(@PathVariable long id) throws Exception {
		CollegeDTO dto = service.findByPK(id);
		service.delete(id);
		return dto;

	}
}