package com.everis.sumativa2.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa2.models.Login;
import com.everis.sumativa2.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;

	public void save(Login login) {
		loginRepository.save(login);
	}
	
	public Login registrar(Login login) {
		 String hashed = BCrypt.hashpw(login.getPassword(), BCrypt.gensalt());
		 System.out.println("password hashed "+ hashed);
	     login.setPassword(hashed);
		return loginRepository.save(login);
	}
	
	public Login findByEmail(String email) {
		return loginRepository.findByEmail(email);
	}

	public boolean autenticacion(String email,String password) {
		Login login = loginRepository.findByEmail(email);
		
		if(login == null) {
			return false;
		}else {
			if(BCrypt.checkpw(password, login.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
}
