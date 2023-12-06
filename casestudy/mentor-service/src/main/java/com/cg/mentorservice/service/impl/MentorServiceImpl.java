package com.cg.mentorservice.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cg.mentorservice.dto.MentorDto;
import com.cg.mentorservice.entity.Mentor;
import com.cg.mentorservice.repository.MentorRepository;
import com.cg.mentorservice.service.MentorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MentorServiceImpl implements MentorService {
	
	private MentorRepository mentorRepository;
	private ModelMapper modelMapper;
	

	@Override
	public MentorDto saveMentor(MentorDto mentorDto) {
		
		Mentor mentor = modelMapper.map(mentorDto,Mentor.class);
		Mentor savedMentor = mentorRepository.save(mentor);
		return modelMapper.map(savedMentor, MentorDto.class);
	}

	@Override
	public MentorDto getMentorById(int mentorId) {
		Mentor mentor =  mentorRepository.findById(mentorId).orElse(null);
		MentorDto mentorDto = modelMapper.map(mentor, MentorDto.class);
		return mentorDto;
	}

	@Override
	public List<MentorDto> getAllMentors() {
		List<Mentor> mentors = mentorRepository.findAll();
		return mentors.stream()
				.map(mentor -> modelMapper.map(mentor, MentorDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public MentorDto updateMentor(MentorDto mentorDto) {
		Mentor mentor = modelMapper.map(mentorDto,Mentor.class);
		Mentor savedMentor = mentorRepository.save(mentor);
		return modelMapper.map(savedMentor, MentorDto.class);
	}

	@Override
	public void deleteMentor(int mentorId) {
		mentorRepository.deleteById(mentorId);
	}
	
	 public byte[] generateMentorsReport() {
	        List<Mentor> mentors = mentorRepository.findAll();

	        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	             PDDocument document = new PDDocument()) {

	            PDPage page = new PDPage();
	            document.addPage(page);

	            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {

	            	// Add mentor details
	                
	            	
	                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
	                contentStream.beginText();
	                contentStream.newLineAtOffset(50, 700);
	                contentStream.showText("Mentors Report");
	                contentStream.endText();
	           	 
	                int yOffset = 680;
	               
	             // Add a line
                	contentStream.moveTo(50, yOffset);
                    contentStream.lineTo(150, yOffset);
                    contentStream.stroke();
                    yOffset -= 20;
                   
	                for (Mentor mentor : mentors) {
	                	
	                    contentStream.beginText();
	                    contentStream.newLineAtOffset(50, yOffset);
	                    contentStream.showText("Mentor ID: " + mentor.getMentorId());
	                    contentStream.newLineAtOffset(0, -20);
	                    contentStream.showText("Mentor Name: " + mentor.getMentorName());
	                    contentStream.newLineAtOffset(0, -20);
	                    contentStream.showText("User ID: " + mentor.getUserId());
	                    contentStream.newLineAtOffset(0, -20);
	                    contentStream.showText("Work Duration: " + mentor.getWorkDuration());
	                    contentStream.endText();
	                    yOffset -= 80; // Adjust the vertical offset for the line
	                    // Add a line after each mentor
	                    contentStream.moveTo(50, yOffset);
	                    contentStream.lineTo(550, yOffset);
	                    contentStream.stroke();
	                    
	                    yOffset -= 30; // Adjust the vertical offset for the next mentor
	                }
	            }

	            document.save(outputStream);
	            return outputStream.toByteArray();
	        } catch (IOException e) {
	            // Handle exception
	            e.printStackTrace();
	            return null;
	        }
	    }
}
