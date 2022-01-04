package com.perigea.tracker.timesheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CommessaExceptions extends RuntimeException {
	private static final long serialVersionUID = 4093329276438371635L;

	public CommessaExceptions(String exception) {
		super(exception);
	}
}