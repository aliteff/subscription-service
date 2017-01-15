package io.adambarreiro.core.serializer;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.adambarreiro.subscription.entity.Subscription;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionDeserializationTest {

	private JacksonTester<Subscription> json;

	@Before
	public void setup() {
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}

	@Test
	public void correctSerializationTest() throws Exception {
		String content = "{\"newsletterId\":1,\"email\":\"adam@mail.com\",\"dateOfBirth\":\"1990-09-14\",\"consent\":true,\"firstName\":\"Adam\",\"gender\":\"M\"}";
		assertThat(this.json.parse(content)).isEqualToComparingFieldByField(new Subscription(1L,"adam@mail.com",LocalDate.parse("1990-09-14"),true,"Adam",'M'));
	}
	
	@Test
	public void correctIncompleteSerializationTest() throws Exception {
		String content = "{\"newsletterId\":1,\"email\":\"adam@mail.com\",\"dateOfBirth\":\"1990-09-14\",\"consent\":true}";
		assertThat(this.json.parse(content)).isEqualToComparingFieldByField(new Subscription(1L,"adam@mail.com",LocalDate.parse("1990-09-14"),true));
	}
	
	@Test(expected=JsonMappingException.class)
	public void incorrectDateOfBirthTest() throws Exception {
		String content = "{\"newsletterId\":1,\"email\":\"adam@mail.com\",\"dateOfBirth\":\"1990/09/14\",\"consent\":true}";
		assertThat(this.json.parse(content)).isEqualToComparingFieldByField(new Subscription(1L,"adam@mail.com",LocalDate.parse("1990-09-14"),true));
	}
	
	
}
