package com.example.crudexample.service;

import com.example.crudexample.dto.ResponseDto;
import com.example.crudexample.model.Student;

public interface StudentService 
{
	ResponseDto getAllStudent();
	
	ResponseDto addStudent(Student student);
	
	ResponseDto deleteStudent(long studId);
	
	ResponseDto editStudent(Student student);
}
