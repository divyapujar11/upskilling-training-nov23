package com.cg.adminservice.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminEmail;
	private int mentorid;
	private int userid;

}
