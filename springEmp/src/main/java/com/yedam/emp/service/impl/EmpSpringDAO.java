package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpSpringDAO {
	@Autowired
	JdbcTemplate jdbc;
	private final String INSERT_EMP = "INSERT INTO EMPLOYEES "//
			+ "(EMPLOYEE_ID, "//
			+ "LAST_NAME, "//
			+ "EMAIL, "//
			+ "HIRE_DATE, "//
			+ "JOB_ID, "//
			+ "DEPARTMENT_ID)"//
			+ "VALUES(?,?,?,?,?,?)";
	private final String UPDATE_EMP = "UPDATE EMPLOYEES "//
			+ "SET LAST_NAME = ?, "//
			+ "EMAIL =  ?, "//
			+ "JOB_ID = ?, "//
			+ "MANAGER_ID = ? "//
			+ "WHERE EMPLOYEE_ID = ?";

	private final String DELETE_EMP = "DELETE FROM EMPLOYEES"//
			+ "WHERE EMPLOYEE_ID = ?";
	private final String GET_EMP = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
	private final String GET_SEARCH_EMP = "SELECT * FROM EMPLOYEES ORDER BY EMPLOYEE_ID";

	// 등록
	public int insertEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(INSERT_EMP //
				, vo.getEmployee_id()//
				, vo.getLast_name()//
				, vo.getEmail()//
				, vo.getHire_date()//
				, vo.getJob_id()//
				, vo.getDepartment_id());
		return result;
	}

	// 수정
	public int updateEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(UPDATE_EMP //
				, vo.getLast_name()//
				, vo.getEmail()//
				, vo.getJob_id()//
				, vo.getManager_id()//
				, vo.getEmployee_id());
		return result;
	}

	// 삭제
	public int deleteEmp(EmpVO vo) {
		int result = 0;
		result = jdbc.update(DELETE_EMP, vo.getEmployee_id());
		return result;
	}

	// 단건조회
	public EmpVO getEmp(EmpVO vo) {
		return jdbc.queryForObject(GET_EMP, new EmpRowMapper(), vo.getEmployee_id());
	}

	// 검색조회
	public List<EmpVO> getSearchEmp(EmpVO vo) {

		return jdbc.query(GET_SEARCH_EMP, new EmpRowMapper());
	}

	// rowmapper
	class EmpRowMapper implements RowMapper<EmpVO> {

		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO vo = new EmpVO();
			vo.setEmployee_id(rs.getString("employee_id"));
			vo.setFirst_name(rs.getString("first_name"));
			vo.setLast_name(rs.getString("last_name"));
			vo.setEmail(rs.getString("email"));
			vo.setHire_date(rs.getDate("hire_date"));
			vo.setJob_id(rs.getString("job_id"));
			vo.setSalary(rs.getString("salary"));
			vo.setDepartment_id(rs.getString("department_id"));
			return vo;
		}

	}
}
