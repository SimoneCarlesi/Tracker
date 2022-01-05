package com.perigea.tracker.timesheet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ TODO fare una generic response che estente runtime exception
@ResponseStatus(HttpStatus.FORBIDDEN)
public class ClientException extends RuntimeException {
	private static final long serialVersionUID = 4093329276438371635L;

	public ClientException(String exception) {
		super(exception);
	}
}
