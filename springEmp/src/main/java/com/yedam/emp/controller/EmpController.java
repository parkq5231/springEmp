package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	// 등록페이지
	@GetMapping("/insertEmp")
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}

	// 등록처리
	@PostMapping("/insertEmp")
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:getSearchEmp";
	}

	// 수정페이지
	@GetMapping("/updateEmp")
	public String updateEmp(EmpVO vo, Model model) {
		model.addAttribute("empVO", empService.getEmp(vo));
		return "/emp/updateEmp";
	}

	// 수정처리
	@PostMapping("/updateEmp")
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}

	// 삭제
	@GetMapping("/deleteEmp")
	public String deleteEmp(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";
	}

	// 단건조회
	@GetMapping("/getEmp")
	public String getEmp(EmpVO vo, Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "emp/getEmp";
	}

	// 검색조회
	@GetMapping("/getSearchEmp")
	public String getSearchEmp(EmpSearchVO vo, Paging paging, Model model) {
		paging.setPageUnit(5);// page record view
		paging.setPageSize(3);// page number
		// paging
		if (vo.getPage() == null)
			vo.setPage(1);

		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "emp/getSearchEmp";
	}
}// end of class