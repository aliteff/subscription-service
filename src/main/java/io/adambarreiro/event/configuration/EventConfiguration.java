package io.adambarreiro.event.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.adambarreiro.event.entity.Event;
import io.adambarreiro.event.repository.EventRepository;

@Configuration
public class EventConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(EventConfiguration.class);

    @Bean
	public CommandLineRunner eventPopulator(EventRepository repository) {
		return (args) -> {
			for (int i=0; i<20; i++) {
				Event event = new Event("Sport News Feed 20"+i);
				repository.save(event);
				log.info("Created Event " + event.getNewsletterId()+": "+ event.getName());
			}
		};
	}
}
