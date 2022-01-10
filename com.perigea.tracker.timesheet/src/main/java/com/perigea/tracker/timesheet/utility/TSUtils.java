package com.perigea.tracker.timesheet.utility;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TSUtils {


	private TSUtils() {

	}

	public static final String uuid() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return UUID.randomUUID().toString();
	}

}
