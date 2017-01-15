package io.adambarreiro.email.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.adambarreiro.email.entity.Email;
import io.adambarreiro.email.service.EmailService;
import io.adambarreiro.event.entity.Event;
import io.adambarreiro.event.service.EventService;
import io.adambarreiro.subscription.entity.Subscription;
import io.adambarreiro.subscription.service.SubscriptionService;

/**
 * REST API for sending emails to users with the events
 * associated to their subscriptions.
 * @author adambarreiro
 *
 */
@RestController
@RequestMapping(path="/email", consumes="application/json")
public class EmailController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SubscriptionService subscriptionService;
	
	@Autowired
	private EmailService emailService;

	/**
	 * Given a valid email, searches for its subscriptions
	 * and its associated events, to send them via email
	 * @param email
	 * @return
	 */
    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> send(@RequestBody Email email) {
    	List<Subscription> subscriptions = subscriptionService.getSubscriptions(email.getEmail());
    	List<Event> events = new ArrayList<Event>();
    	for (Subscription subscription : subscriptions) {
    		Event event = eventService.getEvent(subscription.getNewsletterId());
    		events.add(event);
    	}
    	boolean sent = emailService.send(email.getEmail(), events);
    	if (sent) {
    		return ResponseEntity.ok("{\"mailSent\": true}");
    	} else {
    		return ResponseEntity.ok("{\"mailSent\": false}");
    	}
    	

    }
    
    
}