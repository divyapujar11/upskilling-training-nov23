package com.cg.mentorservice.dto;

import java.time.LocalTime;

import jakarta.persistence.Column;
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
public class MentorDto {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = false)
	private int mentorId;
	private String mentorName;
	private int userId;
	private LocalTime workDuration;


}
