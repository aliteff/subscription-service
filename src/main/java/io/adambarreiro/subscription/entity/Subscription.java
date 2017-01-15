package io.adambarreiro.subscription.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.adambarreiro.core.serializer.LocalDateDeserializer;
import io.adambarreiro.core.serializer.LocalDateSerializer;

/**
 * 
 * @author adambarreiro
 *
 */

@Entity
public class Subscription {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long subscriptionId;
    private Long newsletterId;
    private String email;
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class) 
    private LocalDate dateOfBirth;
    private boolean consent;
    private String firstName;
    private char gender;
    
	public Subscription(Long newsletterId, String email, LocalDate dateOfBirth, boolean consent,
			String firstName, char gender) {
		super();
		this.newsletterId = newsletterId;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.firstName = firstName;
		this.gender = gender;
	}
    
	public Subscription(Long newsletterId, String email, LocalDate dateOfBirth, boolean consent) {
		super();
		this.newsletterId = newsletterId;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
	}
	
	protected Subscription() {
		
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Long getNewsletterId() {
		return newsletterId;
	}
	public void setNewsletterId(Long newsletterId) {
		this.newsletterId = newsletterId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isConsent() {
		return consent;
	}
	public void setConsent(boolean consent) {
		this.consent = consent;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
