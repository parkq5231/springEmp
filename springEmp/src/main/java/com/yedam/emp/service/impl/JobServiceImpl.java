package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.JobVO;
import com.yedam.emp.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	JobMapper jobMapper;

	@Override
	public int insertJob(JobVO vo) {
		return jobMapper.insertJob(vo);
	}

	@Override
	public int updateJob(JobVO vo) {
		return jobMapper.updateJob(vo);
	}

	@Override
	public int deleteJob(JobVO vo) {
		return jobMapper.deleteJob(vo);
	}

	@Override
	public JobVO getJob(JobVO vo) {
		return jobMapper.getJob(vo);
	}

	@Override
	public List<JobVO> getSearchJob(JobVO vo) {
		return jobMapper.getSearchJob(vo);
	}

	@Override
	public int getCount(JobVO vo) {
		return jobMapper.getCount(vo);
	}

}
