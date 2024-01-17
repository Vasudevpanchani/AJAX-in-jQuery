package com.example.crudexample.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.crudexample.dto.ResponseDto;
import com.example.crudexample.model.Student;
import com.example.crudexample.service.StudentService;

@Controller
public class MainController 
{
	@Autowired
	StudentService studentservice;
	
	@GetMapping("/allStudents")
	@ResponseBody
	public ResponseDto findAllStudents()
	{
		return studentservice.getAllStudent();
	}
	
	@PostMapping("/addStudent")
	@ResponseBody
	public ResponseDto addNewStudent(@RequestBody Student student)
	{
		return studentservice.addStudent(student);
	}
	
	@DeleteMapping("/deleteStudent")
	@ResponseBody
	public ResponseDto delStudent(@RequestParam("student_id") long studId)
	{
		return studentservice.deleteStudent(studId);
	}
	
	@PutMapping("/editStudent")
	@ResponseBody
	public ResponseDto edtStudent(@RequestBody Student student)
	{
		return studentservice.editStudent(student);
	}
}
