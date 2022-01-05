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
public class TrackerUserController {

	@Autowired
	private TrackerUserImpl userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);

	//@ TODO avere un builder per genericWrapperResponse ( costruttore o metodo di utilità per creare una response)
	// Metodo per creare un utente
	@PostMapping(value = "/create-user")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> createUser(@RequestBody UtenteDto dtoParam, @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		UtenteDto dto=userService.createUser(dtoParam);
		Date date=new Date();
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per leggere un utente
	@GetMapping(value = "/read-user")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> readUser(@RequestParam String codicePersona,@RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		UtenteDto dto=userService.readUser(codicePersona);
		Date date=new Date();
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per cancellare un utente
	@GetMapping(value = "/delete-user")
	public ResponseEntity <?> deleteUser(@RequestParam String codicePersona) {
		userService.deleteUser(codicePersona);
		return ResponseEntity.ok("Cancellazione utente effettuata");
	}

	// Metodo per aggiornare un utente
	@PostMapping(value = "/update-user")
	public ResponseEntity <?> updateUser(@RequestBody UtenteDto dtoParam,@RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		UtenteDto dto=userService.updateUser(dtoParam);
		Date date=new Date();
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per aggiornare lo status di un utente
	@PostMapping(value = "/edit-status-user")
	public ResponseEntity <?> editStatusUser(@RequestBody UtenteDto dtoParam,@RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		UtenteDto dto=userService.editStatusUser(dtoParam);
		Date date=new Date();
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}


}
