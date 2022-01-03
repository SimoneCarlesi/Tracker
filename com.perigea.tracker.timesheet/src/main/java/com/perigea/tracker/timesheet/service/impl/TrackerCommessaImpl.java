package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.perigea.tracker.timesheet.controller.TrackerController;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.service.TrackerCommessaInterface;

public class TrackerCommessaImpl implements TrackerCommessaInterface {

	@Autowired
	private CommessaNonFatturabileRepository commessaNonFatturabileRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);

	public void createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam){
		CommessaNonFatturabile entity=new CommessaNonFatturabile();
		Date date=new Date();
		entity.setCodiceCommessa(commessaParam.getCodiceCommessa());
		entity.setDescrizione(commessaParam.getDescrizione());
		entity.setCommessaType(commessaParam.getTipoCommessaType().toString());
		entity.setCreateTimestamp(date);
		entity.setCreateUser("");
		commessaNonFatturabileRepo.save(entity);
		LOGGER.info("Commessa creata e salvata a database");
	}

	public void readCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
	}

	public void updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
		if(entity != null) {
			commessaNonFatturabileRepo.delete(entity);
			Date date=new Date();
			entity.setCodiceCommessa(dtoParam.getCodiceCommessa());
			entity.setDescrizione(dtoParam.getDescrizione());
			entity.setCommessaType(dtoParam.getTipoCommessaType().toString());
			entity.setLastUpdateTimestamp(date);
			entity.setLastUpdateUser("");
			commessaNonFatturabileRepo.save(entity);
		}
	}

	public void deleteCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
		if(entity != null) {
			commessaNonFatturabileRepo.delete(entity);
		}
	}

}
