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
		
		//encript
		//phone nb
		String phNo = s.getPhNo();	
		String encPhNo = vali.encrypt(phNo);
		s.setPhNo(encPhNo);
		
		//password
		String passwared = s.getPasswared();
		String ecnPassword = vali.encrypt(passwared);
		s.setPasswared(ecnPassword);
		Student save = repo.save(s);

		System.out.println(save);
		return s;

	}

	@Override
	public Student getById(String id) {
		Student byId = repo.findById(id).get();
		
		System.out.println("Encript DATA : "+byId);
		
		//decript
		String phNo = byId.getPhNo();
		String decPhNo = vali.decrypt(phNo);
		byId.setPhNo(decPhNo);
		
		String password = byId.getPasswared();
		 String decPassword = vali.decrypt(password);
		byId.setPasswared(decPassword);
		
		System.out.println("Decript DATA : "+byId);
		
		return byId;
	}

}
