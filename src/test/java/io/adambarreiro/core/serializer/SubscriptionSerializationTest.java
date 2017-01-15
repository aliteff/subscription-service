package io.adambarreiro.core.serializer;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.adambarreiro.subscription.entity.Subscription;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubscriptionSerializationTest {

	private JacksonTester<Subscription> json;
	
    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

	@Test
	public void correctSerializationTest() throws Exception {
		 Subscription subscription = new
		 Subscription(1L,"adam@mail.com",LocalDate.parse("1990-09-14"),
		 true,"Adam",'M');
		 assertThat(json.write(subscription)).isEqualToJson("subscriptionOk.json");
	}
	
	@Test
	public void correctIncompleteSerializationTest() throws Exception {
		 Subscription subscription = new
		 Subscription(1L,"adam@mail.com",LocalDate.parse("1990-09-14"),
		 true);
		 assertThat(json.write(subscription)).isEqualToJson("subscriptionIncompleteOk.json");
	}
	
	@Test(expected=DateTimeParseException.class)
	public void incorrectDateOfBirthTest() throws Exception {
		 Subscription subscription = new
		 Subscription(1L,"adam@mail.com",LocalDate.parse("1990/09/14"),
		 true,"Adam",'M');
		 assertThat(json.write(subscription)).isEqualToJson("subscriptionOk.json");
	}
}
