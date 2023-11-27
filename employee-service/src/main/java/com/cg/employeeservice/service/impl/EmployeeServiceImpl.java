package com.cg.employeeservice.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.cg.employeeservice.dto.APIResponseDto;
import com.cg.employeeservice.dto.DepartmentDto;
import com.cg.employeeservice.dto.EmployeeDto;
import com.cg.employeeservice.entity.Employee;
import com.cg.employeeservice.repository.EmployeeRespository;
import com.cg.employeeservice.service.APIClient;
import com.cg.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRespository employeeRespository;
	
	private APIClient apiClient;
	
	
//	private RestTemplate restTemplate;
	
//	private WebClient webClient;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode()
				);
		Employee savedEmployee = employeeRespository.save(employee);
		
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode()
				);
		
		return savedEmployeeDto;
	}

	@Override
	public APIResponseDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		
		Employee employee = employeeRespository.findById(employeeId).get();
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode() , DepartmentDto.class);
//		
//		DepartmentDto departmentDto = responseEntity.getBody();
//		
//		DepartmentDto departmentDto = webClient.get()
//					.uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//					.retrieve()
//					.bodyToMono(DepartmentDto.class)
//					.block();
//		

		 DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
		
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		
		return apiResponseDto;
	}

}
