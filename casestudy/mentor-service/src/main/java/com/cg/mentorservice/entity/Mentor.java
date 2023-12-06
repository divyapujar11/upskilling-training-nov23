package com.cg.mentorservice.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentor")
public class Mentor {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@ManyToOne
//    @JoinColumn(name = "mentor_id")
	private int mentorId;
	private String mentorName;
	private int userId;
	private LocalTime workDuration;

}
