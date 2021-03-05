package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yedam.board.service.CommentsVO;

public interface CommentsMapper {
	// 등록
	public void insertComments(CommentsVO vo);

	// 수정
	public void updateComments(CommentsVO vo);

	// 삭제
	public void deleteComments(CommentsVO vo);

	// 단건조회
	public CommentsVO getComments(CommentsVO vo);

	// 전체조회
	public List<CommentsVO> getSearchComments(CommentsVO vo);

}
