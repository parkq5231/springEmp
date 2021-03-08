package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	// 전체조회
	@GetMapping("/getUserList")
	public List<UserVO> getSearchUser(UserVO vo) {
		return userService.getSearchUser(vo);
	}

	// 단건조회
	@GetMapping("/getUser")
	public UserVO getUser(UserVO vo) {
		return userService.getUser(vo);
	}

	// 삭제
	@GetMapping(value = "/deleteUser")
	public Map deleteUser(UserVO vo) {
		int r = userService.deleteUser(vo);
		return Collections.singletonMap("cnt", r);
	}

	// 등록처리
	@PostMapping("/insertUser")
	public ResponseEntity<Object> insertUser(UserVO vo) throws JsonProcessingException {
		userService.insertUser(vo);
		UserVO userVO = userService.getUser(vo);
		if (userVO != null) {
			ObjectMapper mapper = new ObjectMapper();// jackson lib //json parse
			return ResponseEntity.status(200)//
					.body(mapper.writeValueAsString(userVO));
		} else {
			return ResponseEntity.status(500)//
					.body("1234 error");// userService.getUser(vo);
		}
	}

	// 수정
	@PostMapping("/updateUser")
	public UserVO updateUser(UserVO vo) {
		userService.updateUser(vo);
		return userService.getUser(vo);
	}

}// end of class
