package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Student;
import com.example.demo.entity.login;
import com.example.demo.service.Studentservice;

@Controller
public class StudentController {
	
	private Studentservice studentservice;

	public StudentController(Studentservice studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	
	@GetMapping("/login")
	public String login(Model model)
	{
		
		model.addAttribute("loginreq", new login());
		return "login";
	}
	
	@PostMapping("/loginuser")
	public String loginuser(@ModelAttribute("loginreq") login loginreq,Model model)
	{
		System.out.println(loginreq.toString());
		
		return "redirect:/stu";
	}
	
	//handler method to handle list of students
	
	@GetMapping("/stu")
	public String liststudents(Model model)
	{
		model.addAttribute("students", studentservice.getallstudents());
		return "students";
	}
	
	@GetMapping("/stu/new")
	public String createstudentform(Model model)
	{
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/stu")
	public String savestudent(@ModelAttribute("student") Student student)
	{
		
		studentservice.saveStudents(student);
		return "redirect:/stu";
		
	}
	
	@GetMapping("/stu/edit/{id}")
	public String editstudent(@PathVariable Long id,Model model)
	{
		model.addAttribute("student", studentservice.getstudentbyid(id));
		return "edit_student";
	}
	
	@PostMapping("/stu/{id}")
	public String updatestudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model)
	{
		//get student from database
		Student existingstudent = studentservice.getstudentbyid(id);
		existingstudent.setId(id);
		existingstudent.setFirstname(student.getFirstname());
		existingstudent.setLastname(student.getLastname());
		existingstudent.setEmail(student.getEmail());
		
		studentservice.updatestudent(existingstudent);
		return "redirect:/stu";
		
	}
	
	@GetMapping("/stu/{id}")
	public String deletestudent(@PathVariable Long id)
	{
		studentservice.deletestudentbyid(id);
		return "redirect:/stu";
	}

}
