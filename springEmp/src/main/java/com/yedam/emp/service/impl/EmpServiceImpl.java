package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpSpringDAO empStringDAO;

	@Override
	public int insertEmp(EmpVO vo) {
		return 0;
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return 0;
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return 0;
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return null;
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return empStringDAO.getSearchEmp(vo);
	}

}
