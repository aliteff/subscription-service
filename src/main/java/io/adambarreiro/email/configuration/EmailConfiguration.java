package io.adambarreiro.email.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {
	
    @Bean
    public JavaMailSenderImpl mailSender() {
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	mailSender.setHost("smtp.aol.com");
    	return mailSender;
    }
}
