package io.adambarreiro.subscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.adambarreiro.subscription.entity.Subscription;
import io.adambarreiro.subscription.entity.SubscriptionResponse;
import io.adambarreiro.subscription.service.SubscriptionService;

@RestController
@RequestMapping(path="/subscription", consumes="application/json")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionService subscriptionService;

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<SubscriptionResponse> create(@RequestBody Subscription subscription) {
    	if (isValid(subscription)) {
    		Long subscriptionId = subscriptionService.create(subscription);
        	return ResponseEntity.ok(new SubscriptionResponse(subscriptionId));
    	} else {
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubscriptionResponse(HttpStatus.BAD_REQUEST.value(), "A compulsory parameter is missing") );
    	}
    	
    }

	private boolean isValid(Subscription subscription) {
		if (!StringUtils.isEmpty(subscription.getNewsletterId()) && !StringUtils.isEmpty(subscription.getDateOfBirth()) && !StringUtils.isEmpty(subscription.getEmail())) {
    		return true;
    	}
    	return false;
	}
    
    
}
