package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired EmpService empService;
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	// 등록
	@GetMapping("/insertEmp") // insertPage
	public String insertEmp(EmpVO vo) {
		return "emp/insertEmp";
	}

	// 등록처리
	@PostMapping("/insertEmp")
	public String insertEmpProc(EmpVO vo) {
		return "redirect:/getSearchEmp";
	}

	// 수정
	@GetMapping("/updateEmp")
	public String updateEmp(EmpVO vo) {
		return "emp/updateEmp";
	}

	// 수정처리
	@PostMapping("/updateEmp")
	public String updateEmpProc(EmpVO vo) {
		return "redirect:/getSearchEmp";
	}
	// 단건조회

	@GetMapping("/getEmp")
	public String getEmp(EmpVO vo) {
		return "/emp/getEmp";
	}
	// 검색조회

	@GetMapping("/getSearchEmp")
	public String getSearchEmp(EmpVO vo, Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo));
		return "/emp/getSearchEmp";
	}

}