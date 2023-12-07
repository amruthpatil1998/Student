package com.student.pkg.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.student.pkg.entity.Student;
import com.student.pkg.madel.StdModel;
import com.student.pkg.service.StdService;

@RestController
public class StdController {

	@Autowired
	StdService service;

	@GetMapping("/test")
	public String test() {
		return "Hi";
	}

	@PostMapping("/resister")
	public String reister(@RequestBody StdModel s) {
		
		Student st = new Student();
		
		BeanUtils.copyProperties(s, st);

		Student validation = service.validation(st);
		if(validation==null)
			return "not resister";
		
		return "Resister";
	}
	@GetMapping("/getid/{id}")
	public Student getStdById(@PathVariable("id") String id) {
		Student std = service.getById(id);
		return std;
	}
}
