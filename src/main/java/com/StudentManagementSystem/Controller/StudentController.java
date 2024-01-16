package com.StudentManagementSystem.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Service.StudentService;

@CrossOrigin(origins = "http://*")
@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	StudentService studentServiceImp;
 
	@PostMapping()
	public boolean addStudents(@RequestBody Student student){
		try {
			
			 studentServiceImp.addStudentInDataBase(student);
			 return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@DeleteMapping("/{id}")
	public boolean deleteStudents(@PathVariable int id) {
		System.out.print(id);
		try {
			studentServiceImp.deleteStudentFromDataBase(id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
   
	
	@PutMapping("/{id}")
	public boolean updateStudents(@PathVariable int id, @RequestBody Student student) {
		System.out.print(id);
		try {
			student.setId(id);
			if(studentServiceImp.updateStudentInDataBase(student)){
			return true;}
			else{
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@GetMapping("/{id}")
	public Optional<Student>  getStudents(@PathVariable int id) {
		try {
			return studentServiceImp.getStudentFromDataBase(id);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	  @GetMapping("/{name}")
	public Optional<Student>  getStudentsByName(@RequestParam String name) {
		try {
			return studentServiceImp.getStudentByNameFromDataBase(name);
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	  
	  
	@GetMapping()
	public Iterable<Student>  getAllStudents() {
		try {
			return studentServiceImp.getAllStudentFromDataBase();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
