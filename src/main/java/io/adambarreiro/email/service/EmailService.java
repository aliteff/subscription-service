package io.adambarreiro.email.service;

import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import io.adambarreiro.event.entity.Event;
import io.adambarreiro.event.util.EventFormatter;

/**
 * This component allows to send emails.
 * 
 * @author adambarreiro
 *
 */
@Component
public class EmailService {

	private static final String FROM = "subscription-api@dummy.com";
	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EventFormatter eventFormatter;

	/**
	 * Given a valid email address, sends a mail composed by a list of events
	 * 
	 * @param email
	 * @param events
	 * @return
	 */
	public boolean send(String email, List<Event> events) {
		MimeMessagePreparator preparator = getPreparator(email, events);
		try {
			this.mailSender.send(preparator);
			log.info("Mail sent to " + email);
			return true;
		} catch (MailException me) {
			log.error("Error sending email", me);
			return false;
		}
	}

	/**
	 * Generates the preparator of the message, formatting the recipient and the
	 * content of the email.
	 * 
	 * @param email
	 * @param events
	 * @return
	 */
	private MimeMessagePreparator getPreparator(String email, List<Event> events) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress(FROM));
				String eventsFormatted = eventFormatter.asStringOfNewsletterId(events);
				mimeMessage.setText(eventsFormatted);
			}
		};
		return preparator;
	}
}
