package com.example.demo.service;

import java.util.List;



import com.example.demo.entity.Student;


public interface Studentservice {
	
	List<Student> getallstudents();
	
	Student saveStudents(Student student);
	
	Student getstudentbyid(Long id);
	Student updatestudent(Student student);
    
	

	void deletestudentbyid(Long id);
}
