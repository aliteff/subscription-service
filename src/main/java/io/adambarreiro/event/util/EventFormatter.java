package io.adambarreiro.event.util;

import java.util.List;

import org.springframework.stereotype.Component;

import io.adambarreiro.event.entity.Event;

/**
 * Formatter class for events
 * @author adambarreiro
 *
 */
@Component
public class EventFormatter {

	/**
	 * Transforms a list of events into a single formatted string.
	 * @param events
	 * @return
	 */
	public String asStringOfNewsletterId(List<Event> events) {
		StringBuilder result = new StringBuilder("");
		for (Event event : events) {
			result.append(event.getNewsletterId()).append(" | ");
		}
		return result.toString();
	}
}
