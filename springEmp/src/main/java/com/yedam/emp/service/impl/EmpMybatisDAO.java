package com.yedam.emp.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {

	@Autowired
	SqlSessionTemplate sqlSession;

	// 등록
	public int insertEmp(EmpVO vo) {
		int result = 0;
		return result;
	}

	// 수정
	public int updateEmp(EmpVO vo) {
		int result = 0;
		return result;
	}

	// 삭제
	public int deleteEmp(EmpVO vo) {
		int result = 0;
		return result;
	}

	// 단건조회
	public EmpVO getEmp(EmpVO vo) {
		return vo;
	}

	// 삭제
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		System.out.println("mybatis list");
		return sqlSession.selectList("EmpDAO.getSearchEmp", vo);
	}
}
