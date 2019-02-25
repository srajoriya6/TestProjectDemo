package com.raystech.proj0.ctl;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raystech.proj0.dto.CollegeDTO;
import com.raystech.proj0.form.CollegeForm;
import com.raystech.proj0.form.CollegeValidator;
import com.raystech.proj0.service.CollegeServiceInt;

//@Controller
// @RequestMapping(value = "/ctl/College")
@Controller
public class CollegeCtl extends BaseCtl {
	@Autowired
	CollegeServiceInt service;
	@Autowired
	CollegeValidator collegeValidator;

	@RequestMapping(value = "/College", method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id, @ModelAttribute("form") CollegeForm form,
			Model model) {
		System.out.println("College display view 1 start");
		CollegeDTO dto = new CollegeDTO();
		model.addAttribute("message", "Welcome to Spring College!!");
		/*
		 * dto.getId(); dto.getName(); dto.getAddress();
		 * System.out.println(dto.getId()); System.out.println(dto.getName());
		 * System.out.println(dto.getAddress());
		 */
		if (id != null && id > 0) {
			form.populate(dto);
		}
		return "College";
	}

	@RequestMapping(value = "/College", method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid CollegeForm form, BindingResult bindingResult, Model model,
			HttpSession session) {
		System.out.println("College submit 2 start");
		collegeValidator.validate(form, bindingResult);
		System.out.println("College submit 3 start");
		if (OP_SAVE.equalsIgnoreCase(operation)) {

			System.out.println("operation +++++++++=====" + operation);
			/*
			 * if (bindingResult.hasErrors()) { System.out.println("NO"); return
			 * "College"; }
			 */
			/* CollegeDTO dto = new CollegeDTO(); */
			/*
			 * dto.setId(1); dto.setName("SUMTI"); dto.setAddress("INDORE");
			 * System.out.println(dto);
			 */

			CollegeDTO dto = (CollegeDTO) form.getDto(session);
			if (dto.getId() > 0) {
				service.update(dto);
				String msg = "updateed    successfully";
				model.addAttribute("success", msg);
			} else {
				service.add(dto);
				String msg = "College Successfully Added";
				model.addAttribute("success", msg);
			}
		}
		System.out.println("College submit 2 end");
		return "College";
	}

	@RequestMapping(value = "/College/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") CollegeForm form, Model model) {
		System.out.println("list colelge");
		List list = service.search(null, form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list);

		int toCheckListSize = service.search(null).size();
		int buttonNumber = toCheckListSize / form.getPageSize();
		if (toCheckListSize % form.getPageSize() != 0) {
			buttonNumber++;
		}
		model.addAttribute("buttonNumber", buttonNumber);
		return "CollegeList";

	}

	/*
	 * @RequestMapping(value = "/College/search", method = RequestMethod.POST)
	 * public String searchList(Locale locale, @ModelAttribute("form")
	 * CollegeForm form,
	 * 
	 * @RequestParam(required = false) String operation, Model model,
	 * HttpSession session) { System.out.println("colelgelist post"); int pageNo
	 * = form.getPageNo();
	 * 
	 * 
	 * CollegeDTO dto = (CollegeDTO) form.getDto(session); List list =
	 * service.search(dto, pageNo, form.getPageSize());
	 * model.addAttribute("list", list);
	 * 
	 * 
	 * int toCheckListSize = service.search(dto).size(); int buttonNumber =
	 * toCheckListSize / form.getPageSize(); if (toCheckListSize %
	 * form.getPageSize() != 0) { buttonNumber++; }
	 * 
	 * model.addAttribute("buttonNumber", buttonNumber);
	 * 
	 * return "CollegeList"; }
	 */
}
