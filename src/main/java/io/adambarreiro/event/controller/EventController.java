package io.adambarreiro.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.adambarreiro.event.entity.Event;
import io.adambarreiro.event.service.EventService;

/**
 * REST API for the management of events.
 * @author adambarreiro
 *
 */

@RestController
@RequestMapping(path="/event", consumes="application/json")
public class EventController {

	@Autowired
	private EventService eventService;
	
	/**
	 * Given a valid newsletterId, retrieves its associated event.
	 * @param newsletterId
	 * @return
	 */
    @RequestMapping(method=RequestMethod.GET)
    public Event get(@RequestBody Event newsletterId) {
    	return eventService.getEvent(newsletterId.getNewsletterId());
    }
    
    
}