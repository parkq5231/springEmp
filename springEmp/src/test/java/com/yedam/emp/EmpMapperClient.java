package com.yedam.emp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.impl.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/config/*-context.xml")
public class EmpMapperClient {

	@Autowired
	EmpMapper empMapper;
	@Autowired
	EmpService empService;

	@Test // insert
	public void insertEmp() {
		EmpVO vo = EmpVO.builder()//
				.employee_id("5018")//
				.first_name("kimkim4")//
				.last_name("abc4")//
				.email("5018@")//
				.hire_date(new java.sql.Date(new Date().getTime()))//
				.job_id("IT_PROG")//
				.department_id("10")//
				.build();
		int result = empService.insertEmp(vo);
		assertEquals(result, 1);
	}

	// @Test //update
	public void updateEmp() {
		EmpVO vo = EmpVO.builder()//
				.email("abcabc")//
				.employee_id("546")//
				.build();
		int result = empMapper.updateEmp(vo);
		assertEquals(result, 1);
	}

	// @Test //단건조회
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO resultVO = empMapper.getEmp(vo);
		// assertEquals("100", resultVO.getEmployee_id());
		assertNotNull(resultVO); // T or F
		System.out.println(resultVO);
	}

	// @Test
	public void getSearchEmp() {
		EmpVO vo = EmpVO.builder()//
				.employee_id("100")//
				.build();
		List<EmpVO> list = empMapper.getSearchEmp(vo);
		System.out.println(list);
	}

}
