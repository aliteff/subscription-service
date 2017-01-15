package io.adambarreiro.email.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entity for sending mails
 * @author adambarreiro
 *
 */
@Entity
public class Email {
	
	@Id
	private String email;

	protected Email() {
	}
	
	public Email(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
