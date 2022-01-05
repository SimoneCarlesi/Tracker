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
import com.perigea.tracker.timesheet.repository.RuoliRepository;
import com.perigea.tracker.timesheet.service.TrackerRoleInterface;

@Service
public class TrackerRoleImpl implements TrackerRoleInterface{

	@Autowired
	private RuoliRepository roleRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);

	//Metodo per creare un nuovo ruolo
	public void createRole(RuoliDto roleParam) {
		Ruoli role=new Ruoli();
		role.setDescrizioneRuolo(roleParam.getDescrizioneRuolo());
		role.setRuoloType(roleParam.getRuoloType().toString());
		LOGGER.info("Role creato");
		roleRepo.save(role);
		LOGGER.info("Role aggiunto a database");
	}

	//Metodo per leggere le informazioni specifiche di un ruolo
	public RuoliDto readRole(String roleParam) {
		Ruoli entity=roleRepo.findByRuoloType(roleParam);
		RuoliDto dto=fromEntityToDto(entity);
		return dto;
	}

	//Metodo per aggiornare i dati di un ruolo già esistente
	public RuoliDto updateRole(RuoliDto roleParam) {
		Ruoli entity=roleRepo.findByRuoloType(roleParam.getRuoloType().toString());	
		if(entity != null) {
			roleRepo.delete(entity);
			entity.setDescrizioneRuolo(roleParam.getDescrizioneRuolo());
			entity.setRuoloType(roleParam.getRuoloType().toString());
			roleRepo.save(entity);
		}
		RuoliDto dto=fromEntityToDto(entity);
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
	
	public RuoliDto fromEntityToDto(Ruoli entity) {
		RuoliDto dto=new RuoliDto();
		dto.setDescrizioneRuolo(entity.getDescrizioneRuolo());
		EnumConverter enumConverter=new EnumConverter();
		RuoloType ruolo=enumConverter.fromStringToEnum(entity);
		dto.setRuoloType(ruolo);
		return dto;
	}

}
