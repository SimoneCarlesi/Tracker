package com.perigea.tracker.timesheet.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerUserController;
import com.perigea.tracker.timesheet.converter.EnumConverter;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.enumerator.RuoloType;
import com.perigea.tracker.timesheet.mapstruct.DtoEntityMapper;
import com.perigea.tracker.timesheet.repository.RuoliRepository;
import com.perigea.tracker.timesheet.service.TrackerRoleInterface;

@Service
public class TrackerRoleImpl implements TrackerRoleInterface{

	@Autowired
	private RuoliRepository roleRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);

	//Metodo per creare un nuovo ruolo
	public RuoliDto createRole(RuoliDto roleParam) {
		Ruoli role = DtoEntityMapper.INSTANCE.fromDtoToEntityRuoli(roleParam);
		LOGGER.info("Role creato");
		roleRepo.save(role);
		LOGGER.info("Role aggiunto a database");
		RuoliDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoRuoli(role);
		return dto;
	}

	//Metodo per leggere le informazioni specifiche di un ruolo
	public RuoliDto readRole(String roleParam) {
		Ruoli entity=roleRepo.findByRuoloType(roleParam);
		RuoliDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoRuoli(entity);
		return dto;
	}

	//Metodo per aggiornare i dati di un ruolo già esistente
	public RuoliDto updateRole(RuoliDto roleParam) {
		Ruoli entity=roleRepo.findByRuoloType(roleParam.getRuoloType().toString());	
		if(entity != null) {
			roleRepo.delete(entity);
			entity = DtoEntityMapper.INSTANCE.fromDtoToEntityRuoli(roleParam);
			roleRepo.save(entity);
		}
		RuoliDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoRuoli(entity);
		return dto;
	}

	//Metodo per eliminare un ruolo da database
	public void deleteRole(String roleParam) {
		List<Ruoli> entity= roleRepo.findAll();
		for(Ruoli r: entity) {
			if(r.getRuoloType().equalsIgnoreCase(roleParam)) {
				roleRepo.delete(r);
			} else {
				LOGGER.info("RuoloType non trovato");
			}
		}
	}
	
}
