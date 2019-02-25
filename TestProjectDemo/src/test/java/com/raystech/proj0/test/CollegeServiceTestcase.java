package com.raystech.proj0.test;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.raystech.proj0.dto.CollegeDTO;
import com.raystech.proj0.service.CollegeServiceInt;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/dispatcher-servlet.xml")
public class CollegeServiceTestcase {

	@Autowired
	CollegeServiceInt collegeService;

	 //@Test
	@Ignore
	public final void testAdd() {
		CollegeDTO collegeDto = new CollegeDTO();
		collegeDto.setName("SUMIT");
		collegeDto.setAddress("INDORE");
		long pk = collegeService.add(collegeDto);
		System.out.println(pk);
		Assert.assertEquals(pk, collegeDto.getId());
		Assert.assertEquals("SUMIT", collegeDto.getName());
	}

	@Ignore
	public final void testUpdate() {
		long pk = 5;
		CollegeDTO collegeDto = new CollegeDTO();
		collegeDto.setId(pk);
		collegeDto.setName("AMIT");
		collegeDto.setAddress("BHOPAL");
		collegeService.update(collegeDto);
		// Assert.assertEquals(pk, collegeDto.getId());
	}

	//@Ignore
	@Test
	public final void testDelete() {
		long pk = 5;
		collegeService.delete(pk);

	}

	@Ignore
	public final void testFindByPK() {
		CollegeDTO dto = collegeService.findByPK(16);
		Assert.assertEquals(16, dto.getId());
		System.out.println(dto.getId());
	}

	@Ignore
	public final void testSearchCollegeDTO() {
		fail("Not yet implemented");
	}

	@Ignore
	public final void testSearchCollegeDTOIntInt() {
		fail("Not yet implemented");
	}

}
