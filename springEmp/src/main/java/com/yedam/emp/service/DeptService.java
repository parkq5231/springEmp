package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.DeptVO;

public interface DeptService {
	// 등록
	public int insertDept(DeptVO deptvo);

	// 수정
	public int updateDept(DeptVO deptvo);

	// 삭제
	public int deleteDept(DeptVO deptvo);

	// 단건조회
	public DeptVO getDept(DeptVO deptvo);

	// 전체 or 검색 조회
	public List<DeptVO> getSearchDept(DeptVO deptvo);

}
