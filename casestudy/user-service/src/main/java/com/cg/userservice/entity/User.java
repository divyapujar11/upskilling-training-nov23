package com.cg.userservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "user")
public class User {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToMany(mappedBy = "mentor_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private int userId;
	private String userName;
	private String userEmail;
	private int mentorId;
	private int courseId;

}
