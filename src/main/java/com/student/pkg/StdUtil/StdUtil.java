package com.student.pkg.StdUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;
import com.student.pkg.entity.Student;


@Component
public class StdUtil {

	LocalDateTime ltd=LocalDateTime.now();
	private static byte[] key;
	private static SecretKeySpec secretKey;
	private String keyField = "AMMU123!@#";

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

	private void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String decrypt(String strToDecrypt) {
		System.out.println("KEYFIELD : "+keyField);
		try {
			setKey(keyField);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public String encrypt(String strToEncrypt) {
		System.out.println("KEYFIELD : "+keyField);
		try {
			setKey(keyField);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}
	
}
