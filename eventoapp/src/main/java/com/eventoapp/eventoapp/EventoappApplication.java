package com.eventoapp.eventoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.eventoapp.*"})
@EntityScan(basePackages = "com.eventoapp.models")
@EnableJpaRepositories(basePackages = {"com.eventoapp.repository"})
@EnableTransactionManagement
public class EventoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
	//	System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}
