package com.cg.student.Studentdetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.student.Studentdetails.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

}
