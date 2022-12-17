package com.jacaranda.pruebaspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.pruebaspring.model.Student;
import com.jacaranda.pruebaspring.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("/listStudents")
	public String listStudent(Model modelo) {
		
		modelo.addAttribute("students", repositorio.getListStudent());
		return "listStudents";
	}
	
	@GetMapping("addStudent")
	public String addStudent(Model modelo) {
		
		Student student= new Student();
		
		modelo.addAttribute("student", student);
		
		return "addStudent";
	}
	
	@PostMapping("/addStudent/submit")
	public String addStudentSubmit(@ModelAttribute Student student) {
		repositorio.addStudent(student);
		
		return "redirect:/listStudents";
	}
	
	@GetMapping("/delStudent")
	public String delStudent(Model model, @RequestParam String name,
			@RequestParam String surname) {
		
		Student student = repositorio.getStudent(name, surname);
		
		model.addAttribute("student", student);
		
		return "delStudent";
	}
	
	@PostMapping("/delStudent/submit")
	public String listStudentsdelMethod (@ModelAttribute("student") Student student) {
		
		repositorio.removeStudent(student);
			
		return "redirect:/listStudents";
	}
	
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam String name,
			@RequestParam String surname) {
		
		Student student = repositorio.getStudent(name, surname);
		
		model.addAttribute("student", student);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/submit")
	public String listStudentseditMethod (@ModelAttribute("student") Student student) {
		
		repositorio.updateStudent(student.getName(), student.getSurname(), student.getAge());
			
		return "redirect:/listStudents";
	}
}
