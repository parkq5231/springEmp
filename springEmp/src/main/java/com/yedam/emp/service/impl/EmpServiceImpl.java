package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	// EmpSpringDAO empStringDAO;
	// EmpMybatisDAO empStringDAO;
	EmpMapper empStringDAO;

	// CRUD 중 CUD는 void 타입도 상관없음
	@Override
	public int insertEmp(EmpVO vo) {
		return empStringDAO.insertEmp(vo);
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return empStringDAO.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return empStringDAO.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return empStringDAO.getEmp(vo);
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		return empStringDAO.getSearchEmp(vo);
	}

}
