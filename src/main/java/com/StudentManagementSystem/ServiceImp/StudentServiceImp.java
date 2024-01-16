package com.StudentManagementSystem.ServiceImp;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.StudentManagementSystem.Entity.Student;
import com.StudentManagementSystem.Repository.StudentRepo;
import com.StudentManagementSystem.Service.StudentService;

@Component
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepo studentrepo;
	@Override
	public boolean addStudentInDataBase(Student student) {
		// TODO Auto-generated method stub	
		if(student!=null) {
		studentrepo.save(student);
		return true;}
		
		return false;
	}
	
	@Override
	public boolean deleteStudentFromDataBase(int id) {
		// TODO Auto-generated method stub
		  try {
		        studentrepo.deleteById(id);
		        return true;
		    } catch (EmptyResultDataAccessException e) {
		        // if id is not found
		        e.printStackTrace(); 
		        return false;
		    } catch (Exception e) { 
		        e.printStackTrace(); 
		        return false;
		    }
	}
	
	@Override
	public boolean updateStudentInDataBase(Student student) {
		// TODO Auto-generated method stub
		try {
		studentrepo.save(student);
		return true;}
		 catch (Exception e) {
		        e.printStackTrace(); 
		        return false;
		    }
	}
	
	@Override
	public Optional<Student> getStudentFromDataBase(int id) {
	    try {
	        return studentrepo.findById(id);
	    } catch (Exception e) {
	        e.printStackTrace(); 
	        return Optional.empty();
	    }
	}
	
	  @Override
	    public Optional<Student> getStudentByNameFromDataBase(String name) {
		    try {
		        return studentrepo.findByName(name);
		    } catch (Exception e) {
		        e.printStackTrace(); 
		        return Optional.empty();
		    }
	  }
	  
	@Override
	public Iterable<Student> getAllStudentFromDataBase() {
		// TODO Auto-generated method stub
		try {
		return studentrepo.findAll();}
		catch (Exception e) {
	        e.printStackTrace(); 
	        return Collections.emptyList(); 
	    }
	}
}
