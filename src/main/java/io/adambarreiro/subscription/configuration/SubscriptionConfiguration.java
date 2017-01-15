package io.adambarreiro.subscription.configuration;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.adambarreiro.subscription.entity.Subscription;
import io.adambarreiro.subscription.repository.SubscriptionRepository;

@Configuration
public class SubscriptionConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(SubscriptionConfiguration.class);

    @Bean
	public CommandLineRunner subscriptionPopulator(SubscriptionRepository repository) {
		return (args) -> {
			for (int i=0; i<20; i++) {
				Subscription subscription = new Subscription(1L,"adam@a.com",LocalDate.parse("1990-09-14"),true,"Adam",'M');
				repository.save(subscription);
				log.info("Created Subscription with subscriptionId " + subscription.getSubscriptionId());
			}
		};
	}
}
