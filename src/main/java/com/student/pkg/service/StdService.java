package com.student.pkg.service;

import com.student.pkg.entity.Student;

public interface StdService {

	public Student validation(Student st);

	public Student getById(String id);

}
