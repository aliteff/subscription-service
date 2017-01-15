package io.adambarreiro.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.adambarreiro.event.entity.Event;
import io.adambarreiro.event.repository.EventRepository;

@Component
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;

	public Event getEvent(Long newsletterId) {
		return eventRepository.findByNewsletterId(newsletterId);
	}
	
}
