package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.JobVO;

public interface JobService {
	// method
	// 등록
	public int insertJob(JobVO vo);

	// 수정
	public int updateJob(JobVO vo);

	// 삭제
	public int deleteJob(JobVO vo);

	// 단건조회
	public JobVO getJob(JobVO vo);

	// 전체 or 검색조회
	public List<JobVO> getSearchJob(JobVO vo);
	
	// 레코드건수
	public int getCount(JobVO vo);
}
