package com.cg.adminservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.cg.adminservice.dto.AdminDto;
import com.cg.adminservice.dto.CourseDto;
import com.cg.adminservice.dto.MentorDto;
import com.cg.adminservice.dto.UserDto;
import com.cg.adminservice.entity.Admin;
import com.cg.adminservice.repository.AdminRepository;
import com.cg.adminservice.service.AdminService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	@Autowired
	private WebClient webClient;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdminDto saveAdmin(AdminDto adminDto) {
		Admin admin = modelMapper.map(adminDto, Admin.class);
		Admin createdAdmin = adminRepository.save(admin);
		return modelMapper.map(createdAdmin, AdminDto.class);
	}

	@Override
	public void deletAdmin(int id) {
		
		adminRepository.deleteById(id);
	}
	
	@Override
    public List<MentorDto> getAllMentors() {
        List<MentorDto> mentors = webClient.get()
                .uri("http://localhost:8082/api/mentors/all")
                .retrieve()
                .bodyToFlux(MentorDto.class)
                .collectList()
                .block();

        return mentors;
    }

    @Override
    public List<UserDto> getAllUsersByMentorId(int mentorId) {
        List<UserDto> users = webClient.get()
                .uri("http://localhost:8083/api/users/byMentor/{mentorId}", mentorId)
                .retrieve()
                .bodyToFlux(UserDto.class)
                .collectList()
                .block();

        return users;
    }

    @Override
    public CourseDto getCourseByUserId(int userId) {
        CourseDto course = webClient.get()
                .uri("http://localhost:8084/api/courses/byUser/{userId}", userId)
                .retrieve()
                .bodyToMono(CourseDto.class)
                .block();

        return course;
    }
    
    @Override
    public List<UserDto> getAllUsersByCourseId(int courseId) {
    	 List<UserDto> users = webClient.get()
                .uri("http://localhost:8083/api/users/byCourse/{courseId}", courseId)
                .retrieve()
                .bodyToFlux(UserDto.class) .collectList()
                .block();

        return users;
    }
    
    @Override
    public ResponseEntity<MentorDto> saveMentorByWebClient(MentorDto mentorDto) {
        try {
            // Convert MentorDto to Mentor entity
            Admin admin = modelMapper.map(mentorDto, Admin.class);

            // Make a request to the Mentor microservice to save the mentor
            Mono<MentorDto> responseMono = webClient.method(HttpMethod.POST)
                    .uri("http://localhost:8082/api/mentors/save")
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(admin))
                    .retrieve()
                    .bodyToMono(MentorDto.class);

            // Retrieve the response
            MentorDto savedMentorDto = responseMono.block();

            // Return the ResponseEntity
            return ResponseEntity.ok(savedMentorDto);
        } catch (Exception e) {
            // Handle exceptions (e.g., WebClientException, etc.)
            e.printStackTrace();
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }
    
     CourseDto getCourseByWebClient(int courseId) {
		CourseDto dto;
		try {
			dto = webClient.get()
					.uri("http://localhost:8084/api/courses/" + courseId)
					.retrieve()
					.bodyToMono(CourseDto.class).block();
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return dto;
    }
    
     UserDto getUserByWebClient(int userId) {
		UserDto dto;
		try {
			dto = webClient.get()
					.uri("http://localhost:8083/api/users/" + userId)
					.retrieve()
					.bodyToMono(UserDto.class).block();
		}catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return dto;
    }
    
    List<UserDto> getUsersByWebClient() {
		
		return webClient.get()
				.uri("http://localhost:8083/api/users/all" )
				.retrieve()
				.bodyToFlux(UserDto.class)
                .collectList()
                .block();
    }
    
    public ResponseEntity<byte[]> downloadMentorsReport() {
        try {
            // Make a request to the Mentor microservice to download the report
            byte[] reportBytes = webClient.get()
                    .uri("http://localhost:8082/api/mentors/downloadReport")
                    .retrieve()
                    .bodyToMono(byte[].class)
                    .block();

            // Set up HTTP headers for the response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "mentors_report.pdf");

            // Return the response entity with headers and resource
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(reportBytes.length)
                    .body(reportBytes);
        } catch (Exception e) {
            // Handle exceptions (e.g., WebClientException, etc.)
            e.printStackTrace();
            return ResponseEntity.status(500).build(); // Internal Server Error
        }
    }

}
