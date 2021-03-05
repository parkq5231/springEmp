package com.yedam.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentsVO {
	private String id;
	private String name;
	private String content;
	private String board_id;
	// @JsonIgnore
	private String out_msg;
	// @JsonIgnore
	private String[] ids;
	@JsonFormat(pattern = "yyyy/MM/dd/ HH:mm:ss")
	private Date wdate;
}
