package com.StudentManagementSystem.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.StudentManagementSystem.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	  @Query("SELECT s FROM Student s WHERE s.name = :name")
	    Optional<Student> findByName(@Param("name") String name);
}
