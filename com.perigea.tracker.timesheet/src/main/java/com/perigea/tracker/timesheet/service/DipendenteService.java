package com.perigea.tracker.timesheet.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.UtenteController;
import com.perigea.tracker.timesheet.dto.AnagraficaDipendenteDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.AnagraficaDipendente;
import com.perigea.tracker.timesheet.entity.Utente;
import com.perigea.tracker.timesheet.exception.EntityNotFoundException;
import com.perigea.tracker.timesheet.exception.UtenteException;
import com.perigea.tracker.timesheet.mapstruct.DtoEntityMapper;
import com.perigea.tracker.timesheet.repository.AnagraficaDipendenteRepository;
import com.perigea.tracker.timesheet.utility.TSUtils;

@Service
public class DipendenteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UtenteController.class);

	@Autowired
	private AnagraficaDipendenteRepository dipendenteRepo;

	public AnagraficaDipendenteDto createDipendente(AnagraficaDipendenteDto dipendenteParam, UtenteDto dtoParam) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		try {
			Utente utente=DtoEntityMapper.INSTANCE.fromDtoToEntityUtente(dtoParam);
			AnagraficaDipendente dipendente = DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaDipendente(dipendenteParam);
			dipendente.setCodicePersona(TSUtils.uuid());
			dipendente.setUtenteDipendente(utente);
			utente.setDipendente(dipendente);
			dipendenteRepo.save(dipendente);
			AnagraficaDipendenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoAnagraficaDipendente(dipendente);
			return dto;
		}catch(Exception ex) {
			throw new UtenteException("Dipendente non creato");	
		}
	}

	//Metodo per leggere i dati di un determinato dipendente
	public AnagraficaDipendenteDto readDipendente(String dipendenteParam) {
		try {
			AnagraficaDipendente entity=dipendenteRepo.findByCodicePersona(dipendenteParam);
			AnagraficaDipendenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoAnagraficaDipendente(entity);
			return dto;
		}catch(Exception ex) {
			throw new EntityNotFoundException("Dipendente non trovato");	
		}
	}

	//Metodo per aggiornare i dati di un dipendente
	public AnagraficaDipendenteDto updateDipendente(AnagraficaDipendenteDto dipendenteParam) {
		try {
			AnagraficaDipendente entity=dipendenteRepo.findByCodicePersona(dipendenteParam.getCodicePersona());
			if(entity != null) {
				entity = DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaDipendente(dipendenteParam);
				dipendenteRepo.save(entity);
			}
			AnagraficaDipendenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoAnagraficaDipendente(entity);
			return dto;
		}catch(Exception ex) {
			throw new EntityNotFoundException("Dipendente non trovato");	
		}
	}

	//Metodo per eliminare un utente da database
	public AnagraficaDipendenteDto deleteDipendente(String id) {
		try {
			AnagraficaDipendente entity= dipendenteRepo.findByCodicePersona(id);
			AnagraficaDipendenteDto dto=DtoEntityMapper.INSTANCE.fromEntityToDtoAnagraficaDipendente(entity);
			return dto;
		}catch(Exception ex) {
			throw new EntityNotFoundException("Dipendente non trovato");	
		}
	}

}
