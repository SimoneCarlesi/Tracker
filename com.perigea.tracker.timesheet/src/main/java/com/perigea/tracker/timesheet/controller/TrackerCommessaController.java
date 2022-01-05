package com.perigea.tracker.timesheet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.converter.CommessaFatturabileWrapper;
import com.perigea.tracker.timesheet.converter.CommessaNonFatturabileWrapper;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.service.impl.TrackerCommessaImpl;

@RestController
public class TrackerCommessaController {

	@Autowired
	private TrackerCommessaImpl commessaService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-commessa-fatturabile")
	public ResponseEntity <?> createCommessaFatturabile(@RequestBody CommessaFatturabileWrapper commessaParam) {
		commessaService.createCommessaFatturabile(commessaParam);
		return ResponseEntity.ok("CommessaFatturabile creata");
	}
	
	// Metodo per creare un timesheet
	@PostMapping(value = "/createCommessaNonFatturabile")
	public ResponseEntity <?> createCommessaNonFatturabile(@RequestBody CommessaNonFatturabileWrapper body) {
		commessaService.createCommessaNonFatturabile(body.getCommessaParam(),body.getCommessa());
		return ResponseEntity.ok("CommessaNonFatturabile creata");
	}

	// Metodo per creare un timesheet
	@GetMapping(value = "/delete-commessa-non-fatturabile")
	public ResponseEntity <?> deleteCommessaNonFatturabile(@RequestParam String codiceCommessa) {
		commessaService.deleteCommessaNonFatturabile(codiceCommessa);
		return ResponseEntity.ok("CommessaNonFatturabile cancellata");
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-commessa")
	public ResponseEntity <?> createCommessa(@RequestBody CommessaDto commessaParam) {
		commessaService.createCommessa(commessaParam);
		return ResponseEntity.ok("Commessa creata");
	}

	// Metodo per creare un timesheet
	@GetMapping(value = "/delete-commessa")
	public ResponseEntity <?> deleteCommessa(@RequestParam String codiceCommessa) {
		commessaService.deleteCommessa(codiceCommessa);
		return ResponseEntity.ok("Commessa cancellata");
	}
}
