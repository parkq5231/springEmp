package com.yedam.emp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.LoginValidation;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Controller
public class LoginController {

	@Resource
	UserService userService;

	// 패스워드 변경 페이지
	@GetMapping("/changePw")
	public String changePw() {
		return "user/changePw";
	}

	// 패스워드 변경 처리
	@PostMapping("/changePw")
	public String changePwProc(@Valid UserVO vo, BindingResult result, HttpSession session) {
		// validation(pw 일치여부 확인)
		LoginValidation logval = new LoginValidation();
		logval.validate(vo, result);

		/*
		 * if (!vo.getNewpassword().equals(vo.getNewpassword2())) { return
		 * "user/changePw"; }
		 */
		// 패스워드 변경 서비스
		String id = (String) session.getAttribute("loginid");
		vo.setId(id);
		int r = userService.updatePw(vo);
		if (r == 1) {
			return "redirect:/";
		} else {
			return "user/changePw";
		}
	}

	// 로그인 페이지
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	// 로그인처리
	@PostMapping("/login")
	public String loginProc(UserVO vo, HttpSession session) {
		if (userService.logCheck(vo)) {
			// 세션에 저장
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		} else {
			return "user/login";
		}
	}

	// 로그아웃처리
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
