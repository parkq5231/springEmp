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
		return sqlSession.insert("EmpDAO.insertEmp",vo);
	}

	// 수정
	public int updateEmp(EmpVO vo) {
		return sqlSession.update("EmpDAO.updateEmp",vo);
	}

	// 삭제
	public int deleteEmp(EmpVO vo) {
		return sqlSession.delete("EmpDAO.deleteEmp",vo);
	}

	// 단건조회
	public EmpVO getEmp(EmpVO vo) {
		return sqlSession.selectOne("EmpDAO.getEmp",vo);
	}

	// 전체 or 검색 조회
	public List<EmpVO> getSearchEmp(EmpVO vo) {
		System.out.println("mybatis list");
		return sqlSession.selectList("EmpDAO.getSearchEmp", vo);
	}
}
