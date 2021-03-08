package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.EmpValidation;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;

@Controller
public class EmpController {

	@Autowired
	EmpService empService;
	@Autowired
	DeptService deptService;
	@Autowired
	JobService jobService;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	// 등록페이지
	@GetMapping("/insertEmp")
	public String insertEmp(EmpVO vo, Model model, DeptSearchVO deptvo, JobVO jobvo) {// vo 를 사용하지 않아도 인수 써줘야함
		deptvo.setStart(1);
		deptvo.setEnd(1000);

		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
		return "/emp/insertEmp";
	}

	// 등록처리
	@PostMapping("/insertEmp")
	public String insertEmpProc(EmpVO vo, BindingResult result, DeptSearchVO deptvo, JobVO jobvo, Model model) {
		// 입력값 검증
		EmpValidation empValidation = new EmpValidation();
		empValidation.validate(vo, result);
		
		
		if (result.hasErrors()) {// 에러가 1개라도 있으면
			model.addAttribute("deptList", deptService.getSearchDept(deptvo));
			model.addAttribute("jobList", jobService.getSearchJob(jobvo));
			return "/emp/insertEmp"; // 다시 등록 페이지로
		} else {
			empService.insertEmp(vo);
			return "redirect:getSearchEmp";
		}
	}

	// 수정페이지
	@GetMapping("/updateEmp")
	public String updateEmp(EmpVO vo, Model model, DeptSearchVO deptvo, JobVO jobvo) {
		model.addAttribute("empVO", empService.getEmp(vo));
		model.addAttribute("deptList", deptService.getSearchDept(deptvo));
		model.addAttribute("jobList", jobService.getSearchJob(jobvo));
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
	@GetMapping("/getEmp") /// {employee_id}
	public String getEmp(Model model, @ModelAttribute("employee") EmpVO vo) {
		// ,@RequestParam(value = "id", required = true, defaultValue = "100") String
		// employee_id
		// ,@PathVariable String employee_id
		// HttpServletRequest request

		// 1.getParameter
		// String employee_id = request.getParameter("employee_id");

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