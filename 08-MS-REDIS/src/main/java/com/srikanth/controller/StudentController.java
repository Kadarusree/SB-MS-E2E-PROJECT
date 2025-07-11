package com.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.entity.Student;
import com.srikanth.repo.StudentRepo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {
	
	
	@Autowired
	private StudentRepo mStudentRepo;
	
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student entity) {
		//TODO: process POST request
		Student save = mStudentRepo.save(entity);
		return save.toString();
	}
	
	// Additional methods for handling other CRUD operations can be added here
	
	
	@GetMapping("/getStudents")
	public Iterable<Student> getStudents(){
		return mStudentRepo.findAll();
	}
	

}
