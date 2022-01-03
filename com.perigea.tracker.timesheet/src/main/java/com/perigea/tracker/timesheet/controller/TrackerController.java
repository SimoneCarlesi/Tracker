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

import com.perigea.tracker.timesheet.converter.BodyConverterCommessaFatturabile;
import com.perigea.tracker.timesheet.converter.BodyConverterTimeSheet;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.impl.TrackerCommessaImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerRoleImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerTimeSheetImpl;
import com.perigea.tracker.timesheet.service.impl.TrackerUserImpl;


//@ TODO mapstruct controllare cosa fa per gestire il get e le entity
//@ TODO non restituire mai le entity
//@ TODO creare una response entity generica e usare come ritorno la response T
//@ TODO creare un dto generico di risposta che contenga data richiesta,, utente che la fa e il risultato

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

	// Metodo per creare un utente
	@PostMapping(value = "/createUser")
	public ResponseEntity <String> createUser(@RequestBody UtenteDto dto) {
		try {
			userService.createUser(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("Utente creato");
	}

	// Metodo per leggere un utente
	@GetMapping(value = "/readUser")
	public ResponseEntity <UtenteDto> readUser(@RequestParam String codicePersona) {
		try {
			UtenteDto dto=userService.readUser(codicePersona);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return null;
	}

	// Metodo per cancellare un utente
	@GetMapping(value = "/deleteUser")
	public ResponseEntity <String> deleteUser(@RequestParam String codicePersona) {
		try {
			userService.deleteUser(codicePersona);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("Cancellazione utente effettuata");
	}

	// Metodo per aggiornare un utente
	@PostMapping(value = "/updateUser")
	public ResponseEntity <UtenteDto> updateUser(@RequestBody UtenteDto dtoParam) {
		try {
			UtenteDto dto=userService.updateUser(dtoParam);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return null;
	}

	// Metodo per aggiornare lo status di un utente
	@PostMapping(value = "/editStatusUser")
	public ResponseEntity <UtenteDto> editStatusUser(@RequestBody UtenteDto dtoParam) {
		try {
			UtenteDto dto=userService.editStatusUser(dtoParam);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return null;
	}

	// Metodo per creare un ruolo
	@PostMapping(value = "/createRole")
	public ResponseEntity <String> createRole(@RequestBody RuoliDto dto) {
		try {
			roleService.createRole(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("Ruolo creato");
	}

	// Metodo per leggere un ruolo
	@GetMapping(value = "/readRole")
	public ResponseEntity <RuoliDto> readRole(@RequestParam String roleName) {
		try {
			RuoliDto dto=roleService.readRole(roleName);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return null;
	}

	// Metodo per cancellare un ruolo
	@GetMapping(value = "/deleteRole")
	public ResponseEntity <String> deleteRole(@RequestParam String roleName) {
		try {
			roleService.deleteRole(roleName);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("Cancellazione ruolo effettuata");
	}

	// Metodo per aggiornare un ruolo
	@PostMapping(value = "/updateRole")
	public ResponseEntity <RuoliDto> updateRole(@RequestBody RuoliDto dtoParam) {
		try {
			RuoliDto dto=roleService.updateRole(dtoParam);
			return ResponseEntity.ok().body(dto);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return null;
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/createTimeSheet")
	public ResponseEntity <String> createTimeSheet(@RequestBody BodyConverterTimeSheet bodyConverter) {
		try {
			timeSheetService.createTimeSheet(bodyConverter);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("TimeSheet creato");
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/createCommessaNonFatturabile")
	public ResponseEntity <String> createCommessaNonFatturabile(@RequestBody CommessaNonFatturabileDto commessaParam) {
		try {
			commessaService.createCommessaNonFatturabile(commessaParam);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("CommessaNonFatturabile creata");
	}
	
	// Metodo per creare un timesheet
		@PostMapping(value = "/createCommessaFatturabile")
		public ResponseEntity <String> createCommessaFatturabile(@RequestBody BodyConverterCommessaFatturabile commessaParam) {
			try {
				commessaService.createCommessaFatturabile(commessaParam);
			} catch (Exception e) {
				LOGGER.warn(e.getMessage());
			}
			return ResponseEntity.ok("CommessaFatturabile creata");
		}

	// Metodo per creare un timesheet
	@PostMapping(value = "/deleteCommessaNonFatturabile")
	public ResponseEntity <String> deleteCommessaNonFatturabile(@RequestParam CommessaNonFatturabileDto commessaParam) {
		try {
			commessaService.deleteCommessaNonFatturabile(commessaParam);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("CommessaNonFatturabile cancellata");
	}
	
	// Metodo per creare un timesheet
	@PostMapping(value = "/createCommessa")
	public ResponseEntity <String> createCommessa(@RequestBody CommessaDto commessaParam) {
		try {
			commessaService.createCommessa(commessaParam);
		} catch (Exception e) {
			LOGGER.warn(e.getMessage());
		}
		return ResponseEntity.ok("Commessa creata");
	}
}
