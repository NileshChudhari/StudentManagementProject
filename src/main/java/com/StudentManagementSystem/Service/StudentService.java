package com.StudentManagementSystem.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.StudentManagementSystem.Entity.Student;

@Service
public interface StudentService {
 boolean addStudentInDataBase(Student student);
 boolean deleteStudentFromDataBase(int id);
 boolean updateStudentInDataBase(Student student);
 Optional<Student> getStudentFromDataBase(int id);
 Optional<Student> getStudentByNameFromDataBase(String name);
 Iterable<Student>getAllStudentFromDataBase();
}
