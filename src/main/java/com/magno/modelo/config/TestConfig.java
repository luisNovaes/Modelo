package com.magno.modelo.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.magno.modelo.services.DBService;
import com.magno.modelo.services.EmailService;
import com.magno.modelo.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;		
	}
	
	@Bean
	public EmailService emalService() {
		return new MockEmailService();		
	}
}
