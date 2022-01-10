package com.perigea.tracker.timesheet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.dto.GenericWrapperResponse;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.TimeSheetService;
import com.perigea.tracker.timesheet.wrapper.TimeSheetWrapper;

@RestController
public class TimeSheetController {
	

	@Autowired
	private TimeSheetService timeSheetService;
	

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-timesheet")
	public ResponseEntity <GenericWrapperResponse<TimeSheetDto>> createTimeSheet(@RequestBody TimeSheetWrapper bodyConverter) {
		TimeSheetDto dto=timeSheetService.createTimeSheet(bodyConverter.getUtente(),bodyConverter.getCommessa(),bodyConverter.getTimeDto());
		Date date=new Date();
		GenericWrapperResponse<TimeSheetDto> genericDto=GenericWrapperResponse.<TimeSheetDto>builder()
				.dataRichiesta(date)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

}
