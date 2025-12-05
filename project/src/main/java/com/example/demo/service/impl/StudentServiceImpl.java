package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.entity.login;
import com.example.demo.repository.studentRepository;
import com.example.demo.service.Studentservice;


@Service
public  class StudentServiceImpl implements Studentservice {
	
	private studentRepository studentrepository;
	
	

	public StudentServiceImpl(studentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}



	@Override
	public List<Student> getallstudents() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}



	@Override
	public Student saveStudents(Student student) {
		
		return studentrepository.save(student);
	}



	@Override
	public Student getstudentbyid(Long id) {
		return studentrepository.findById(id).get();
		 
	}



	@Override
	public Student updatestudent(Student student) {
		// TODO Auto-generated method stub
		return studentrepository.save(student);
	}



	@Override
	public void deletestudentbyid(Long id) {
		// TODO Auto-generated method stub
		studentrepository.deleteById(id);
	}

	
//	public login getusernameandpass()
//	{
//		studentrepository.findBy
//	}


	
	
	

}
