package com.student.pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.pkg.StdUtil.StdUtil;
import com.student.pkg.entity.Student;
import com.student.pkg.repository.StdRepository;

@Service
public class StdServiceIpml implements StdService {

	@Autowired
	StdUtil vali;

	@Autowired
	StdRepository repo;

	@Override
	public Student validation(Student s) {

		Boolean validate = vali.validate(s);

		if (validate == true) {
			System.out.println("resistration complited");
		} else {
			System.out.println("resistration not complited");
		}

		String setUsn = vali.setUsn();
		s.setUsn("2av15me"+setUsn);
		
		String setDate = vali.setDate();
		s.setDateOfJoing(setDate);
		
		//
		
		Student save = repo.save(s);

		System.out.println(save);
		return s;

	}

}
