package com.example.crudexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudexample.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
