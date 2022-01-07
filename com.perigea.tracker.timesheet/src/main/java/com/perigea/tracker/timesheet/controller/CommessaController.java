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
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaFatturabileDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.GenericWrapperResponse;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.service.CommessaService;

@RestController
public class CommessaController {

	@Autowired
	private CommessaService commessaService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-commessa-fatturabile")
	public ResponseEntity <GenericWrapperResponse<CommessaFatturabileDto>> createCommessaFatturabile(@RequestBody CommessaFatturabileWrapper commessaParam, @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		CommessaFatturabileDto dto=commessaService.createCommessaFatturabile(commessaParam);
		Date date=new Date();
		GenericWrapperResponse<CommessaFatturabileDto>genericDto=GenericWrapperResponse.<CommessaFatturabileDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}
	
	// Metodo per creare un timesheet
	@PostMapping(value = "/create-commessa-non-fatturabile")
	public ResponseEntity <GenericWrapperResponse<CommessaNonFatturabileDto>> createCommessaNonFatturabile(@RequestBody CommessaNonFatturabileWrapper body,@RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		CommessaNonFatturabileDto dto=commessaService.createCommessaNonFatturabile(body.getCommessaParam(),body.getCommessa());
		Date date=new Date();
		GenericWrapperResponse<CommessaNonFatturabileDto>genericDto=GenericWrapperResponse.<CommessaNonFatturabileDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per creare un timesheet
	@GetMapping(value = "/delete-commessa-non-fatturabile")
	public ResponseEntity <GenericWrapperResponse<String>> deleteCommessaNonFatturabile(@RequestParam String codiceCommessa,  @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		commessaService.deleteCommessaNonFatturabile(codiceCommessa);
		Date date=new Date();
		GenericWrapperResponse<String>genericDto=GenericWrapperResponse.<String>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato("Commessa non fatturabile eliminata")
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per creare un timesheet
	@PostMapping(value = "/create-commessa")
	public ResponseEntity <GenericWrapperResponse<CommessaDto>> createCommessa(@RequestBody CommessaDto commessaParam,@RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		CommessaDto dto=commessaService.createCommessa(commessaParam);
		Date date=new Date();
		GenericWrapperResponse<CommessaDto>genericDto=GenericWrapperResponse.<CommessaDto>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato(dto)
				.build();
		return ResponseEntity.ok(genericDto);
	}

	// Metodo per creare un timesheet
	@GetMapping(value = "/delete-commessa")
	public ResponseEntity <GenericWrapperResponse<String>> deleteCommessa(@RequestParam String codiceCommessa, @RequestParam String nomeModifica, @RequestParam String cognomeModifica) {
		commessaService.deleteCommessa(codiceCommessa);
		Date date=new Date();
		GenericWrapperResponse<String>genericDto=GenericWrapperResponse.<String>builder()
				.dataRichiesta(date)
				.utenteModifica(nomeModifica+cognomeModifica)
				.risultato("Commessa eliminata")
				.build();
		return ResponseEntity.ok(genericDto);
	}
}
