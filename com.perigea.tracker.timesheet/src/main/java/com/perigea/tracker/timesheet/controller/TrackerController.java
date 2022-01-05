package com.perigea.tracker.timesheet.controller;

import java.util.Date;

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
import com.perigea.tracker.timesheet.converter.TimeSheetWrapper;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.GenericWrapperResponse;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.impl.TrackerCommessaImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerRoleImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerTimeSheetImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerUserImpl;

//@ TODO controller advise, exception handler
//@ TODO mapstruct controllare cosa fa per gestire il get e le entity ( come metterlo nel pom)

@RestController
public class TrackerController {

	@Autowired
	private TrackerUserImpl userService;

	@Autowired
	private TrackerRoleImpl roleService;

	@Autowired
	private TrackerTimeSheetImpl timeSheetService;

	@Autowired
	private TrackerCommessaImpl commessaService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);

	//@ TODO avere un builder per genericWrapperResponse ( costruttore o metodo di utilità per creare una response)
	// Metodo per creare un utente
	@PostMapping(value = "/createUser")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> createUser(@RequestBody UtenteDto dtoParam, @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		UtenteDto dto=userService.createUser(dtoParam);
		GenericWrapperResponse<UtenteDto> genericDto=new GenericWrapperResponse<>();
		Date date=new Date();
		genericDto.setDataRichiesta(date);
		genericDto.setUtenteModifica(nomeModifica+ " " + cognomeModifica);
		genericDto.setRisultato(dto);
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per leggere un utente
	@GetMapping(value = "/readUser")
	public ResponseEntity <?> readUser(@RequestParam String codicePersona) {
		UtenteDto dto=userService.readUser(codicePersona);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per cancellare un utente
	@GetMapping(value = "/deleteUser")
	public ResponseEntity <?> deleteUser(@RequestParam String codicePersona) {
		userService.deleteUser(codicePersona);
		return ResponseEntity.ok("Cancellazione utente effettuata");
	}

	// Metodo per aggiornare un utente
	@PostMapping(value = "/updateUser")
	public ResponseEntity <?> updateUser(@RequestBody UtenteDto dtoParam) {
		UtenteDto dto=userService.updateUser(dtoParam);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per aggiornare lo status di un utente
	@PostMapping(value = "/editStatusUser")
	public ResponseEntity <?> editStatusUser(@RequestBody UtenteDto dtoParam) {
		UtenteDto dto=userService.editStatusUser(dtoParam);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per creare un ruolo
	@PostMapping(value = "/createRole")
	public ResponseEntity <?> createRole(@RequestBody RuoliDto dto) {
		roleService.createRole(dto);
		return ResponseEntity.ok("Ruolo creato");
	}

	// Metodo per leggere un ruolo
	@GetMapping(value = "/readRole")
	public ResponseEntity <?> readRole(@RequestParam String roleName) {
		RuoliDto dto=roleService.readRole(roleName);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per cancellare un ruolo
	@GetMapping(value = "/deleteRole")
	public ResponseEntity <?> deleteRole(@RequestParam String roleName) {
		roleService.deleteRole(roleName);
		return ResponseEntity.ok("Cancellazione ruolo effettuata");
	}

	// Metodo per aggiornare un ruolo
	@PostMapping(value = "/updateRole")
	public ResponseEntity <?> updateRole(@RequestBody RuoliDto dtoParam) {
		RuoliDto dto=roleService.updateRole(dtoParam);
		return ResponseEntity.ok().body(dto);
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/createTimeSheet")
	public ResponseEntity <?> createTimeSheet(@RequestBody TimeSheetWrapper bodyConverter) {
		timeSheetService.createTimeSheet(bodyConverter);
		return ResponseEntity.ok("TimeSheet creato");
	}


	// Metodo per creare un timesheet
	@PostMapping(value = "/createCommessaFatturabile")
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
	@GetMapping(value = "/deleteCommessaNonFatturabile")
	public ResponseEntity <?> deleteCommessaNonFatturabile(@RequestParam String codiceCommessa) {
		commessaService.deleteCommessaNonFatturabile(codiceCommessa);
		return ResponseEntity.ok("CommessaNonFatturabile cancellata");
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/createCommessa")
	public ResponseEntity <?> createCommessa(@RequestBody CommessaDto commessaParam) {
		commessaService.createCommessa(commessaParam);
		return ResponseEntity.ok("Commessa creata");
	}

	// Metodo per creare un timesheet
	@GetMapping(value = "/deleteCommessa")
	public ResponseEntity <?> deleteCommessa(@RequestParam String codiceCommessa) {
		commessaService.deleteCommessa(codiceCommessa);
		return ResponseEntity.ok("Commessa cancellata");
	}
}
