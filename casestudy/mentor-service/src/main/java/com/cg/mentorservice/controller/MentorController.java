package com.cg.mentorservice.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mentorservice.dto.MentorDto;
import com.cg.mentorservice.service.MentorService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("api/mentors")
@AllArgsConstructor
public class MentorController {
	
	private MentorService mentorService;
	
	@PostMapping("/save")
    public MentorDto saveMentor(@RequestBody MentorDto mentorDto) {
		// Log the received MentorDto
	    System.out.println("Received MentorDto: " + mentorDto.toString());
        return mentorService.saveMentor(mentorDto);
    }

    @GetMapping("/{mentorId}")
    public MentorDto getMentorById(@PathVariable int mentorId) {
        return mentorService.getMentorById(mentorId);
    }

    @GetMapping("/all")
    public List<MentorDto> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @PutMapping("/update")
    public MentorDto updateMentor(@RequestBody MentorDto mentorDto) {
        return mentorService.updateMentor(mentorDto);
    }

    @DeleteMapping("/delete/{mentorId}")
    public void deleteMentor(@PathVariable int mentorId) {
        mentorService.deleteMentor(mentorId);
    }
    
    @GetMapping("/downloadReport")
    public ResponseEntity<byte[]> downloadMentorsReport() {
        byte[] reportBytes = mentorService.generateMentorsReport();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "mentors_report.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .body(reportBytes);
    }
	

}
