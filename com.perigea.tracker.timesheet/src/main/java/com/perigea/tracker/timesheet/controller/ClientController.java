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
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService commessaService;
	
	@PostMapping(value = "/create-anagrafica-cliente")
	public ResponseEntity <GenericWrapperResponse<AnagraficaClienteDto>> createUser(@RequestBody AnagraficaClienteDto dtoParam) {
		AnagraficaClienteDto dto=commessaService.createCustomerPersonalData(dtoParam);
		GenericWrapperResponse<AnagraficaClienteDto>genericDto=GenericWrapperResponse.<AnagraficaClienteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}
}
