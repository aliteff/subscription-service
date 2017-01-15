package io.adambarreiro.event.repository;

import org.springframework.data.repository.CrudRepository;

import io.adambarreiro.event.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	Event findByNewsletterId(Long newsletterId);
	
}
