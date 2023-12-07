package com.student.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.student.pkg.entity.Student;

@Component
public interface StdRepository extends JpaRepository<Student, String>{

}
