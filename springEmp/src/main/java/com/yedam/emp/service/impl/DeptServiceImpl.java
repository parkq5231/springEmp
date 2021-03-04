package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	// DeptSpringDAO deptpringDAO;
	DeptMapper deptpringDAO;

	@Override
	public int insertDept(DeptVO deptvo) {
		return deptpringDAO.insertDept(deptvo);
	}

	@Override
	public int updateDept(DeptVO deptvo) {
		return deptpringDAO.updateDept(deptvo);
	}

	@Override
	public int deleteDept(DeptVO deptvo) {
		return deptpringDAO.deleteDept(deptvo);
	}

	@Override
	public DeptVO getDept(DeptVO deptvo) {
		return deptpringDAO.getDept(deptvo);
	}

	@Override
	public List<DeptVO> getSearchDept(DeptSearchVO deptvo) {
		return deptpringDAO.getSearchDept(deptvo);
	}

	@Override
	public int getCount(DeptSearchVO vo) {
		return deptpringDAO.getCount(vo);
	}

}
