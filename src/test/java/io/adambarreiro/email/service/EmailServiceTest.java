package io.adambarreiro.email.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.adambarreiro.event.entity.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	EmailService emailService;
	
	@Test
	public void mailIsNotSentWhenAddressIsIncorrectTest() {
		List<Event> events = new ArrayList<Event>();
		assertFalse(emailService.send("notexist", events ));
	}
	
	// FIXME: Delete the '@Ignore' annotation when the email server is configured correctly
	@Ignore
	@Test
	public void mailIsSentWhenAddressIsCorrectTest() {
		List<Event> events = new ArrayList<Event>();
		assertTrue(emailService.send("adam@mailautentico.com", events ));
	}

}
