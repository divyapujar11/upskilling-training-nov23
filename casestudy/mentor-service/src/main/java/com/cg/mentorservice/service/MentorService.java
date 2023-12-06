package com.cg.mentorservice.service;

import java.util.List;

import com.cg.mentorservice.dto.MentorDto;

public interface MentorService {
	
	MentorDto saveMentor(MentorDto mentorDto);
	MentorDto getMentorById(int mentorId);
	List<MentorDto> getAllMentors();
	MentorDto updateMentor(MentorDto mentorDto);
	void deleteMentor(int mentorId);
	byte[] generateMentorsReport();

}
