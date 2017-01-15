package io.adambarreiro.email.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// FIXME: Error when running test
@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(EmailController.class)
public class EmailControllerTest {
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void mailIsNotSentWhenAddressIsIncorrectTest() throws Exception {
		 this.mvc.perform(post("/email").contentType(MediaType.APPLICATION_JSON).content("{\"email\":\"notexist\"}"))
         .andExpect(status().isOk()).andExpect(content().string("true"));
	}
	
	// FIXME: Delete the '@Ignore' annotation when the email server is configured correctly
	@Ignore
	@Test
	public void mailIsSentWhenAddressIsCorrectTest() throws Exception {
		 this.mvc.perform(post("/email").contentType(MediaType.APPLICATION_JSON).content("{\"email\":\"adam@mail.com\"}"))
         .andExpect(status().isOk()).andExpect(content().string("true"));
	}

}
