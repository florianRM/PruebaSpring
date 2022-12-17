package com.jacaranda.pruebaspring.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.pruebaspring.model.Student;

@Service
public class StudentService {
	
	private List<Student> listStudent;
	
	public StudentService() {
		listStudent = new ArrayList<>();
		listStudent.add(new Student("Florian", "Ristea", 20));
		listStudent.add(new Student("Manolo", "Perez", 45));
		listStudent.add(new Student("Julio", "Alvarez", 25));
	}

	public boolean addStudent(Student student) {
		return listStudent.add(student);
	}
	
	public boolean removeStudent(Student student) {
		return listStudent.remove(student);
	}

	public Student getStudent(String name, String surname) {
		boolean encontrado = false;
		Student student = null;
		
		Iterator<Student> iterator = this.listStudent.iterator();
		while(iterator.hasNext() && !encontrado) {
			student = iterator.next();
			if(student.getName().equals(name) && student.getSurname().equals(surname)) {
				encontrado = true;
			}
			
		}
		
		if(encontrado) {
			return student;
		}
		
		return null;
	}

	
	public boolean updateStudent(String name, String surname, int edad) {
		boolean encontrado = false;
		Student student = null;
		
		Iterator<Student> iterator = this.listStudent.iterator();
		while(iterator.hasNext() && !encontrado) {
			student = iterator.next();
			if(student.getName().equals(name) && student.getSurname().equals(surname)) {
				student.setAge(edad);
				encontrado = true;
			}
			
		}
		
		return encontrado;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}
	
}
