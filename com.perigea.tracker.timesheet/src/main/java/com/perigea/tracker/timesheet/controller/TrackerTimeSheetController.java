package com.perigea.tracker.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.converter.TimeSheetWrapper;
import com.perigea.tracker.timesheet.service.impl.TrackerTimeSheetImpl;

@RestController
public class TrackerTimeSheetController {
	

	@Autowired
	private TrackerTimeSheetImpl timeSheetService;
	

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-timesheet")
	public ResponseEntity <?> createTimeSheet(@RequestBody TimeSheetWrapper bodyConverter) {
		timeSheetService.createTimeSheet(bodyConverter);
		return ResponseEntity.ok("TimeSheet creato");
	}

}
