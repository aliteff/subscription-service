package io.adambarreiro.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @RequestMapping(path="/{newsletterId}", consumes="application/json",method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<Event> get(@PathVariable("newsletterId") Long newsletterId) {
    	Event event = eventService.getEvent(newsletterId);
    	if (event != null) {
    		return ResponseEntity.ok(event);
    	} else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    	}
    }
    
    
}