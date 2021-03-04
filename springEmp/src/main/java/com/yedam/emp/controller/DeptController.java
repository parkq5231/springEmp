package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;

	// 등록 페이지
	@GetMapping("/insertDept")
	public String insertDept(DeptVO deptvo) {
		return "dept/insertDept";
	}

	// 등록 처리
	@PostMapping("/insertDept")
	public String insertDeptProc(DeptVO deptvo) {
		deptService.insertDept(deptvo);
		return "redirect:/getSearchDept";
	}

	// 수정 페이지
	@GetMapping("/updateDept")
	public String updateDept(DeptVO deptvo, Model model) {
		model.addAttribute("deptVO", deptService.getDept(deptvo));
		return "dept/updateDept";
	}

	// 수정 처리
	@PostMapping("/updateDept")
	public String updateDeptProc(DeptVO deptvo) {
		deptService.updateDept(deptvo);
		return "redirect:/getSearchDept";
	}

	// 삭제
	@GetMapping("/deleteDept")
	public String deleteDept(DeptVO deptvo) {
		deptService.deleteDept(deptvo);
		return "redirect:/getSearchDept";
	}

	// 단건조회
	@GetMapping("/getDept")
	public String getDept(DeptVO deptvo, Model model) {
		model.addAttribute("dept", deptService.getDept(deptvo));
		return "dept/getDept";
	}

	// 전체 or 검색 조회
	@GetMapping("/getSearchDept")
	public String getSearchDept(DeptSearchVO deptvo, Paging paging, Model model) {

		paging.setPageUnit(5);// 1 페이지 안에서 보이는 갯수
		paging.setPageSize(3);// 페이지 갯수가 3개라는 의미
		// paging
		if (paging.getPage() == null)
			paging.setPage(1);
		deptvo.setStart(paging.getFirst());
		deptvo.setEnd(paging.getLast());
		paging.setTotalRecord(deptService.getCount(deptvo));

		model.addAttribute("paging", paging);
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		return "dept/getSearchDept";
	}
}// end of class