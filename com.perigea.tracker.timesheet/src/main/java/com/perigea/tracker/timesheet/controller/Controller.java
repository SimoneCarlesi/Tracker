package com.perigea.tracker.timesheet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.entity.Utente;
import com.perigea.tracker.timesheet.service.ServiceImpl;

@RestController
public class Controller {

	@Autowired
	private ServiceImpl service;

	//Metodo per effettuare il login
	@GetMapping(value = "/login")
	public ResponseEntity <String> login(@RequestParam String key, @RequestParam String username) {
		service.login(key, username);
		return ResponseEntity.ok("Login effettuato");
	}

	// Metodo per creare un utente
	@PostMapping(value = "/createUser")
	public ResponseEntity <String> createUser(@RequestBody UtenteDto dto, @RequestParam String key) {
		service.createUser(dto, key);
		return ResponseEntity.ok("Utente creato");
	}

	// Metodo per leggere un utente
	@GetMapping(value = "/readUser")
	public ResponseEntity <Utente> readUser(@RequestParam String key, @RequestParam String codicePersona) {
		Utente entity=service.readUser(codicePersona, key);
		return ResponseEntity.ok().body(entity);
	}

	// Metodo per cancellare un utente
	@GetMapping(value = "/deleteUser")
	public ResponseEntity <String> deleteUser(@RequestParam String key, @RequestParam String codicePersona) {
		service.deleteUser(codicePersona, key);
		return ResponseEntity.ok("Cancellazione utente effettuata");
	}

	// Metodo per aggiornare un utente
	@PostMapping(value = "/updateUser")
	public ResponseEntity <Utente> updateUser(@RequestParam String key, @RequestBody UtenteDto dto) {
		Utente entity=service.updateUser(dto, key);
		return ResponseEntity.ok().body(entity);
	}

	// Metodo per aggiornare lo status di un utente
	@PostMapping(value = "/editStatusUser")
	public ResponseEntity <Utente> editStatusUser(@RequestParam String key, @RequestBody UtenteDto dto) {
		Utente entity=service.editStatusUser(dto, key);
		return ResponseEntity.ok().body(entity);
	}

	// Metodo per creare un ruolo
	@PostMapping(value = "/createRole")
	public ResponseEntity <String> createRole(@RequestParam String key, @RequestBody RuoliDto dto) {
		service.createRole(dto, key);
		return ResponseEntity.ok("Ruolo creato");
	}

	// Metodo per leggere un ruolo
	@GetMapping(value = "/readRole")
	public ResponseEntity <Ruoli> readRole(@RequestParam String key, @RequestParam String roleName) {
		Ruoli entity=service.readRole(roleName, key);
		return ResponseEntity.ok().body(entity);
	}

	// Metodo per cancellare un ruolo
	@GetMapping(value = "/deleteRole")
	public ResponseEntity <String> deleteRole(@RequestParam String key, @RequestParam String roleName) {
		service.deleteRole(roleName, key);
		return ResponseEntity.ok("Cancellazione ruolo effettuata");
	}

	// Metodo per aggiornare un ruolo
	@PostMapping(value = "/updateRole")
	public ResponseEntity <Ruoli> updateRole(@RequestParam String key, @RequestBody RuoliDto dto) {
		Ruoli entity=service.updateRole(dto, key);
		return ResponseEntity.ok().body(entity);

	}
}
