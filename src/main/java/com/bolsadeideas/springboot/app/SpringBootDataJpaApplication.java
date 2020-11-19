package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootDataJpaApplication  implements CommandLineRunner {

	@Autowired
	IUploadFileService uploadFileService;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
		//En las siguientes lineas se hace la encriptacion de las contraseñas de admin y usuario
		//mediate passwordEncoder
		String password = "12345";
		for (int  i=0; i< 2 ;i++){
			String bcryptPassword = passwordEncoder.encode(password);
			System.out.println(bcryptPassword );
			//$2a$10$nKqhOFBbncLwX6EJywMMBO1fpVtemqFW18/BN0KNRZgLSbH0qYPZy
			//$2a$10$HSWVANI0xmQuQFOO5bFQTOPU.O9nmkCH9no/rue.6G8ihVyBp8bp.
		}
	}

}
