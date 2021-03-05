package com.yedam.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@RestController
public class CommentsController {

	@Autowired
	CommentsService commentsService;

	// 등록처리
	@RequestMapping("/insertComments")
	public String insertCommentsProc(CommentsVO vo) {
		commentsService.insertComments(vo);
		return "";
	}
	// 수정

	// 삭제
	@RequestMapping("/deleteComments")
	public String deleteCommentsProc(CommentsVO vo) {
		commentsService.deleteComments(vo);
		return "";
	}

	// 단건조회
	@RequestMapping("/getComments")
	public CommentsVO getComments(CommentsVO vo) {
		return commentsService.getComments(vo);
	}

	// 게시글 댓글 조회
	@RequestMapping("/getSearchComments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}
}// end of class
