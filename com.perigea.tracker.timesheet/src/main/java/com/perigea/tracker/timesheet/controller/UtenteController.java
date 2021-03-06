package com.perigea.tracker.timesheet.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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

import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.GenericWrapperResponse;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.service.CommessaService;
import com.perigea.tracker.timesheet.service.RuoloService;
import com.perigea.tracker.timesheet.service.TimeSheetService;
import com.perigea.tracker.timesheet.service.UtenteService;
import com.perigea.tracker.timesheet.wrapper.CommessaFatturabileWrapper;
import com.perigea.tracker.timesheet.wrapper.CommessaNonFatturabileWrapper;
import com.perigea.tracker.timesheet.wrapper.TimeSheetWrapper;

//@ TODO controller advise, exception handler
//@ TODO mapstruct controllare cosa fa per gestire il get e le entity ( come metterlo nel pom)

@RestController
public class UtenteController {

	@Autowired
	private UtenteService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UtenteController.class);

	//@ TODO avere un builder per genericWrapperResponse ( costruttore o metodo di utilità per creare una response)
	// Metodo per creare un utente
	@PostMapping(value = "/create-user")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> createUser(@RequestBody UtenteDto dtoParam) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		UtenteDto dto=userService.createUser(dtoParam);
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per leggere un utente
	@GetMapping(value = "/read-user")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> readUser(@RequestParam String codicePersona) {
		UtenteDto dto=userService.readUser(codicePersona);
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per cancellare un utente
	@GetMapping(value = "/delete-user")
	public ResponseEntity <GenericWrapperResponse<UtenteDto>> deleteUser(@RequestParam String codicePersona) {
		UtenteDto dto=userService.deleteUser(codicePersona);
		GenericWrapperResponse<UtenteDto>genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per aggiornare un utente
	@PostMapping(value = "/update-user")
	public ResponseEntity <?> updateUser(@RequestBody UtenteDto dtoParam) {
		UtenteDto dto=userService.updateUser(dtoParam);
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per aggiornare lo status di un utente
	@PostMapping(value = "/edit-status-user")
	public ResponseEntity <?> editStatusUser(@RequestBody UtenteDto dtoParam) {
		UtenteDto dto=userService.editStatusUser(dtoParam);
		GenericWrapperResponse<UtenteDto> genericDto=GenericWrapperResponse.<UtenteDto>builder()
				.dataRichiesta(new Date())
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}


}
