package com.perigea.tracker.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.service.impl.TrackerRoleImpl;

@RestController
public class TrackerRoleController {
	
	@Autowired
	private TrackerRoleImpl roleService;
	

	// Metodo per creare un ruolo
	@PostMapping(value = "/create-role")
	public ResponseEntity <?> createRole(@RequestBody RuoliDto dto) {
		roleService.createRole(dto);
		return ResponseEntity.ok("Ruolo creato");
	}

	// Metodo per leggere un ruolo
	@GetMapping(value = "/read-role")
	public ResponseEntity <?> readRole(@RequestParam String roleName) {
		RuoliDto dto=roleService.readRole(roleName);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per cancellare un ruolo
	@GetMapping(value = "/delete-role")
	public ResponseEntity <?> deleteRole(@RequestParam String roleName) {
		roleService.deleteRole(roleName);
		return ResponseEntity.ok("Cancellazione ruolo effettuata");
	}

	// Metodo per aggiornare un ruolo
	@PostMapping(value = "/update-role")
	public ResponseEntity <?> updateRole(@RequestBody RuoliDto dtoParam) {
		RuoliDto dto=roleService.updateRole(dtoParam);
		return ResponseEntity.ok().body(dto);
	}

}
