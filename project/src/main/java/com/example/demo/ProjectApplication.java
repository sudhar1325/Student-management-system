package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Student;
import com.example.demo.repository.studentRepository;

@SpringBootApplication
public class ProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Autowired
	private studentRepository studentrepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Student student1=new Student("pravin","murugan","pravin@gmail.com");
//		studentrepository.save(student1);
//		
//		
//		Student student2=new Student("sudhar","gobbi","sudhar@gmail.com");
//		studentrepository.save(student2);
//		
//		Student student3=new Student("surya","jay","surya@gmail.com");
//		studentrepository.save(student3);
		
	}
	
	
}
