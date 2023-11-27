package com.cg.departmentservice.service;

import com.cg.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartmentDto(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
	
}
