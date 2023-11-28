package com.cg.departmentservice.service.impl;

import org.springframework.stereotype.Service;

import com.cg.departmentservice.dto.DepartmentDto;
import com.cg.departmentservice.entity.Department;
import com.cg.departmentservice.mapper.DepartmentMapper;
import com.cg.departmentservice.repository.DepartmentRepository;
import com.cg.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

		
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}

