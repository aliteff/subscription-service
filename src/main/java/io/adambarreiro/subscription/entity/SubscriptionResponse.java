package io.adambarreiro.subscription.entity;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author adambarreiro
 *
 */

public class SubscriptionResponse {
	
	private Long subscriptionId;
	private int statusCode;
	private String message;
	
	public SubscriptionResponse(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
		this.statusCode = HttpStatus.OK.value();
	}
	
	public SubscriptionResponse(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public Long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	
}
