package com.student.pkg.StdUtil;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Component;
import com.student.pkg.entity.Student;


@Component
public class StdUtil {

	LocalDateTime ltd=LocalDateTime.now();

	public Boolean validate(Student s) {
		
		String regex = "[a-zA-Z]+\\.?";
		String regex1 = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
	    String regex2 = "^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$";
		String regex3 = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
						+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		String regex4 = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
		String regex5="^\\d{4}-\\d{2}-\\d{2}$";

		if(!s.getName().matches(regex) && !(s.getName()==null)) {
			System.out.println("Plese Enter valid Name");
			return false;
		}
		if(!s.getLastName().matches(regex) && !(s.getLastName()==null)) {
			System.out.println("Plese Enter valid Last Name");
			return false;
		}
		if(!s.getBranch().matches(regex) && !(s.getBranch()==null)) {
			System.out.println("Plese Enter valid Branch Name");
			return false;
		}
		if(!s.getAge().matches(regex2) && !(s.getAge()==null)) {
			System.out.println("Plese Enter valid Age");
			return false;
		}
		if(!s.getEmail().matches(regex3) && !(s.getEmail()==null)) {
			System.out.println("Plese Enter valid Email");
			return false;
		}
		if(!s.getPasswared().matches(regex4) && !(s.getPasswared()==null)) {
			System.out.println("Plese Enter valid password");
			return false;
		}
		if(!s.getPhNo().matches(regex1) && !(s.getPhNo()==null)) {
			System.out.println("Plese Enter valid Phone number ");
			return false;
		}
		if(!s.getDateOfBirth().matches(regex5) && !(s.getDateOfBirth()==null)) {
			System.out.println("Plese Enter valid DateOfBirth");
			return false;
		}
		
		return true;
	}
	public String setDate() {
		String valueOf = String.valueOf(ltd);
		String date = valueOf.substring(0,10);
		return date;
	}
	
	public String setUsn() {
		Random usn=new Random();
		int nextInt = usn.nextInt(100);
		String valueOf = String.valueOf(nextInt);
		return valueOf;
	}


}
