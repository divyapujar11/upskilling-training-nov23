package com.cg.studentcrud.Studentdetailscrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.studentcrud.Studentdetailscrud.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, Long> {

}
