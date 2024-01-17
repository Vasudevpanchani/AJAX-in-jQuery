package com.example.crudexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudexample.dto.ResponseDto;
import com.example.crudexample.model.Student;
import com.example.crudexample.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	StudentRepo studentrepo;

	ResponseDto response = new ResponseDto();
	
	private void setResponseData(int status, String message, Object data)
	{
		response.setStatus(status);
		response.setMessage(message);
		response.setData(data);
	}
	
	@Override
	public ResponseDto getAllStudent() {
		List<Student> allStudent = studentrepo.findAll();
		if(allStudent.isEmpty())
		{
			setResponseData(400, "List is empty", "Any student is not there");
		}else {
			setResponseData(200, "All Students", allStudent);
		}
		return response;
	}

	@Override
	public ResponseDto addStudent(Student student) {
		setResponseData(200, "Student Added Successfully", studentrepo.save(student));
		return response;
	}

	@Override
	public ResponseDto deleteStudent(long studId) {
		Student student = studentrepo.findById(studId).get();
		if(student != null)
		{
			studentrepo.deleteById(studId);
			setResponseData(200, "Student Deleted", "Successfully Deleted");
		}else {
			setResponseData(400, "Student Not Deleted", "Student Not Found");
		}
		return response;
	}

	@Override
	public ResponseDto editStudent(Student student) {
		Student newStudent = studentrepo.findById(student.getStudId()).get();
		newStudent.setStudId(student.getStudId());
		newStudent.setStudName(student.getStudName());
		newStudent.setStudGender(student.getStudGender());
		newStudent.setStudAge(student.getStudAge());
		newStudent.setStudCity(student.getStudCity());
		setResponseData(200, "Student Edited", studentrepo.save(newStudent));
		return response;
	}
}
