package com.yedam.emp;

import lombok.Data;

@Data
public class DeptSearchVO extends DeptVO {
	// paging
	Integer page = 1;
	Integer start = 1;
	Integer end = 10;
}
