package io.adambarreiro.subscription.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.adambarreiro.subscription.entity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
	
	List<Subscription> findByEmail(String email);
	
}
