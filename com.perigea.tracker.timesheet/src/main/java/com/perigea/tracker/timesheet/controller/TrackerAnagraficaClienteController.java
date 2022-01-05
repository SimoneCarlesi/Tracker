package com.perigea.tracker.timesheet.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.GenericWrapperResponse;
import com.perigea.tracker.timesheet.service.impl.TrackerClientImpl;

@RestController
public class TrackerAnagraficaClienteController {

	@Autowired
	private TrackerClientImpl commessaService;
	
	@PostMapping(value = "/createAnagraficaCliente")
	public ResponseEntity <GenericWrapperResponse<AnagraficaClienteDto>> createUser(@RequestBody AnagraficaClienteDto dtoParam, @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		AnagraficaClienteDto dto=commessaService.createCustomerPersonalData(dtoParam);
		GenericWrapperResponse<AnagraficaClienteDto> genericDto=new GenericWrapperResponse<>();
		Date date=new Date();
		genericDto.setDataRichiesta(date);
		genericDto.setUtenteModifica(nomeModifica+ " " + cognomeModifica);
		genericDto.setRisultato(dto);
		return ResponseEntity.ok(genericDto);
	}
}
