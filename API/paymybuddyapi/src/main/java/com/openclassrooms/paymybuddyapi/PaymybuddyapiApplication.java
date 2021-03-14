package com.openclassrooms.paymybuddyapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PaymybuddyapiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PaymybuddyapiApplication.class, args);
	}

	@Override
	public void run(String ...args){
		System.out.println("---------------------");
		System.out.println("PAY MY BUDDY API V0.8");
		System.out.println("---------------------");
	}

}
