package com.perigea.tracker.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.ServiceImpl;

@RestController
public class Controller {

	@Autowired
	private ServiceImpl service;

	// Metodo per lanciare nuovi thread
	@GetMapping(value = "/login")
	public ResponseEntity <String> login(@RequestParam String key, @RequestParam String createUser) {
		service.login(key, createUser);
		return ResponseEntity.ok("Login effettuato");
	}

	// Metodo per lanciare nuovi thread
	@PostMapping(value = "/createUser")
	public ResponseEntity <String> createUser(@RequestBody UtenteDto dto, @RequestParam String key) {
		service.createUser(dto, key);
		return ResponseEntity.ok("Utente creato");
	}

	// Metodo per lanciare nuovi thread
	@GetMapping(value = "/readUser")
	public ResponseEntity <String> readUser(@RequestParam String key, @RequestBody UtenteDto dto) {
		service.readUser(dto, key);
		return ResponseEntity.ok("Lettura utente effettuata");
	}

	// Metodo per lanciare nuovi thread
	@GetMapping(value = "/deleteUser")
	public ResponseEntity <String> deleteUser(@RequestParam String key, @RequestParam String dto) {
		service.deleteUser(dto, key);
		return ResponseEntity.ok("Cancellazione utente effettuata");
	}



}
