package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	// EmpSpringDAO empStringDAO;
	// EmpMybatisDAO empStringDAO;
	EmpMapper empStringDAO;

	// CRUD 중 CUD는 void 타입도 상관없음

	// @Transactional
	public int insertEmp(EmpVO vo) {
		// empStringDAO.insertEmp(vo); // 자동 커밋
		return empStringDAO.insertEmp(vo); // uk 에러 발생
	}

	public int updateEmp(EmpVO vo) {
		return empStringDAO.updateEmp(vo);
	}

	public int deleteEmp(EmpVO vo) {
		return empStringDAO.deleteEmp(vo);
	}

	public EmpVO getEmp(EmpVO vo) {
		return empStringDAO.getEmp(vo);
	}

	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		return empStringDAO.getSearchEmp(vo);
	}

	@Override
	public int getCount(EmpSearchVO vo) {
		return empStringDAO.getCount(vo);
	}

}
