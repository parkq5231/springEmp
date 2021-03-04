package com.yedam.emp;

import lombok.Data;

@Data
public class EmpSearchVO extends EmpVO {
	// paging
	Integer page = 1;
	int start = 1;
	int end = 10;

}