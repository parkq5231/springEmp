package com.yedam.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.OrderMasterVO;

@Controller
public class OrderController {

	// 주문 폼
	@GetMapping("/insertOrder")
	public String insertOrder(OrderMasterVO vo) {
		System.out.println(vo);
		return "order/insertOrder";
	}

	// 주문처리
	@PostMapping("/insertOrder")
	public String insertOrderProc(OrderMasterVO vo) {
		System.out.println(vo);
		//master테이블 등록
		//detail(주문상세) list수만큼 등록(loop)
		return "redirect:/";
	}

}
