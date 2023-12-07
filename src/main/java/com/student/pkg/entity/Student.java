package com.student.pkg.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String university;
	private String usn;
	private String DateOfJoing;
	
	private String name;
	private String age;
	private String phNo;
	private String lastName;
	private String branch;
	private String email;
	private String dateOfBirth;
	private String passwared;
	
	
	
}
