package io.adambarreiro.subscription.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.adambarreiro.subscription.entity.Subscription;
import io.adambarreiro.subscription.repository.SubscriptionRepository;

@Component
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepository;

	public List<Subscription> getSubscriptions(String email) {
		return subscriptionRepository.findByEmail(email);
	}

	public Long create(Subscription subscription) {
		Subscription result = subscriptionRepository.save(subscription);
		return result.getSubscriptionId();
	}
	
	

}
