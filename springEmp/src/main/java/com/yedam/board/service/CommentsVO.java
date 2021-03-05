package com.yedam.board.service;

import lombok.Data;

@Data
public class CommentsVO {
	private String id;
	private String name;
	private String content;
	private String board_id;
	private String out_msg;
	private String[] ids;
}
