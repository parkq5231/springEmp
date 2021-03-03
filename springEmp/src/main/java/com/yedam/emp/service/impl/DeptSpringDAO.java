package com.yedam.emp.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptSpringDAO {
	@Autowired
	JdbcTemplate jdbc;

	private final String INSERT_DEPT = "INSERT INTO DEPARTMENTS "//
			+ "(DEPARTMENT_ID, "//
			+ "DEPARTMENT_NAME, "//
			+ "MANAGER_ID, "//
			+ "LOCATION_ID) "//
			+ "VALUES(?,?,?,?)";
	private final String UPDATE_DEPT = "UPDATE DEPARTMENTS "//
			+ "SET MANAGER_ID = ?, "//
			+ "LOCATION_ID = ? "//
			+ "WHERE DEPARMTENT_ID = ?";
	private final String DELETE_DEPT = "DELETE FROM DEPARTMENTS "//
			+ "WHERE DEPARTMENT_ID = ?";
	private final String GET_DEPT = "SELECT *FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
	private final String GET_SEARCH_DEPT = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID";

	// 등록
	public int insertDept(DeptVO deptvo) {
		int result = 0;
		result = jdbc.update(INSERT_DEPT, //
				deptvo.getDepartment_id(), //
				deptvo.getDepartment_name(), //
				deptvo.getManager_id(), //
				deptvo.getLocation_id());
		return result;
	}

	// 수정
	public int updateDept(DeptVO deptvo) {
		int result = 0;
		result = jdbc.update(UPDATE_DEPT, //
				deptvo.getManager_id(), //
				deptvo.getLocation_id(), //
				deptvo.getDepartment_id());
		return result;
	}

	// 삭제
	public int deleteDept(DeptVO deptvo) {
		int result = 0;
		result = jdbc.update(DELETE_DEPT, //
				deptvo.getDepartment_id());
		return result;
	}

	// 단건조회
	public DeptVO getDept(DeptVO deptvo) {
		return jdbc.queryForObject(GET_DEPT, new DeptRowMapper(), deptvo.getDepartment_id());
	}

	// 전체조회
	public List<DeptVO> getSearchDept(DeptVO deptvo) {
		return jdbc.query(GET_SEARCH_DEPT, new DeptRowMapper());
	}

	// RowMapper
	class DeptRowMapper implements RowMapper<DeptVO> {

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO deptvo = new DeptVO();

			deptvo.setDepartment_id(rs.getInt("department_id"));
			deptvo.setDepartment_name(rs.getString("department_name"));
			deptvo.setManager_id(rs.getInt("manager_id"));
			deptvo.setLocation_id(rs.getInt("location_id"));
			return deptvo;
		}

	}
}
