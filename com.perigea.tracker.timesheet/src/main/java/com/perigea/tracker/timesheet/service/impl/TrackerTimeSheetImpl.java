package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerUserController;
import com.perigea.tracker.timesheet.converter.TimeSheetWrapper;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.TimeSheet;
import com.perigea.tracker.timesheet.entity.Utente;
import com.perigea.tracker.timesheet.repository.TimeSheetRepository;
import com.perigea.tracker.timesheet.service.TrackerTimeSheetInterface;

@Service
public class TrackerTimeSheetImpl implements TrackerTimeSheetInterface{

	@Autowired
	private TimeSheetRepository timeSheetRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);

	public void createTimeSheet( TimeSheetWrapper bodyConverter) {
		TimeSheet timeSheetEntity= new TimeSheet();
		timeSheetEntity.setAnnoDiRiferimento(bodyConverter.getTimeDto().getAnnoDiRiferimento());
		timeSheetEntity.setMeseDiRiferimento(bodyConverter.getTimeDto().getMeseDiRiferimento());
		timeSheetEntity.setGiornoDiRiferimento(bodyConverter.getTimeDto().getGiornoDiRiferimento());
		timeSheetEntity.setStatoType(bodyConverter.getTimeDto().getStatoType().toString());
		timeSheetEntity.setUtenteTime(bodyConverter.getUtente());
		timeSheetEntity.setCommessaTimeSheed(bodyConverter.getCommessa());
		timeSheetEntity.setOre(bodyConverter.getTimeDto().getOre());
		timeSheetEntity.setCreateUser("");
		timeSheetRepo.save(timeSheetEntity);
		LOGGER.info("TimeSheet creato e aggiunto a database");
	}


	public void editTimeSheet(TimeSheetDto timeSheetParam, Commessa commessa, Utente utente) {
		TimeSheet timeSheetEntity=timeSheetRepo.findByUtenteTimeSheet(utente);
		if(timeSheetEntity != null) {
			timeSheetRepo.delete(timeSheetEntity);
			Date date=new Date();
			timeSheetEntity.setAnnoDiRiferimento(timeSheetParam.getAnnoDiRiferimento());
			timeSheetEntity.setMeseDiRiferimento(timeSheetParam.getMeseDiRiferimento());
			timeSheetEntity.setGiornoDiRiferimento(timeSheetParam.getGiornoDiRiferimento());
			timeSheetEntity.setStatoType(timeSheetParam.getStatoType().toString());
			timeSheetEntity.setUtenteTime(utente);
			timeSheetEntity.setCommessaTimeSheed(commessa);
			timeSheetEntity.setOre(timeSheetParam.getOre());
			timeSheetEntity.setLastUpdateUser("");
			timeSheetEntity.setLastUpdateTimestamp(date);
			timeSheetRepo.save(timeSheetEntity);
			LOGGER.info("TimeSheet modificato");
		}
	}

}
