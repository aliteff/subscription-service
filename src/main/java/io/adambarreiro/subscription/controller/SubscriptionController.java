package io.adambarreiro.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.adambarreiro.subscription.entity.Subscription;
import io.adambarreiro.subscription.service.SubscriptionService;

@RestController
@RequestMapping(path="/subscription", consumes="application/json")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;

    @RequestMapping(method=RequestMethod.PUT)
    public Long create(@RequestBody Subscription subscription) {
    	Long subscriptionId = subscriptionService.create(subscription);
    	return subscriptionId;
    }
    
    
}
