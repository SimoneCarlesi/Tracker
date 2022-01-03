package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerController;
import com.perigea.tracker.timesheet.converter.BodyConverterCommessaFatturabile;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.CommessaFatturabile;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;
import com.perigea.tracker.timesheet.repository.CommessaFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaRepository;
import com.perigea.tracker.timesheet.service.TrackerCommessaInterface;

@Service
public class TrackerCommessaImpl implements TrackerCommessaInterface {

	@Autowired
	private CommessaNonFatturabileRepository commessaNonFatturabileRepo;

	@Autowired
	private CommessaFatturabileRepository commessaFatturabileRepo;
	
	@Autowired
	private CommessaRepository commessaRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);
	
	public void createCommessaFatturabile(BodyConverterCommessaFatturabile bodyConverter) {
		CommessaFatturabile entity=new CommessaFatturabile();
		//entity.setCodiceCommessa(bodyConverter.getCommessaFatturabileDto().getCodiceCommessa());
		//entity.setCommessaType(bodyConverter.getCommessaFatturabileDto().getTipoCommessaType());
		entity.setCreateUser(bodyConverter.getCommessaFatturabileDto().getCreateUser());
		Date date=new Date();
		entity.setDataInizioCommessa(date);
		entity.setDataFineCommessa(bodyConverter.getCommessaFatturabileDto().getDataFineCommessa());
		entity.setImportoCommessaInizialePresunto(bodyConverter.getCommessaFatturabileDto().getImportoCommessaInizialePresunto());
		entity.setDescrizioneCommessaCliente(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaCliente());
		entity.setDescrizioneCommessaPerigea(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaPerigea());
		entity.setMargineDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioAnno());
		entity.setMargineDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioCommessa());
		entity.setMargineIniziale(bodyConverter.getCommessaFatturabileDto().getMargineIniziale());
		entity.setOrdineCommessa(bodyConverter.getOrdineCommessa());
		entity.setOrdineInternoCorrente(bodyConverter.getCommessaFatturabileDto().getOrdineInternoCorrente());
		//entity.setNotaSpese(bodyConverter.getNotaSpese());
		entity.setTotaleCostiDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioAnno());
		entity.setTotaleCostiDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioCommessa());
		entity.setTotaleEstensioni(bodyConverter.getCommessaFatturabileDto().getTotaleEstensioni());
		entity.setTotaleFatturatoDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoDaInizioAnno());
		entity.setTotaleFatturatoreDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoreDaInizioCommessa());
		entity.setTotaleOrdine(bodyConverter.getCommessaFatturabileDto().getTotaleOrdine());
		entity.setTotaleOrdineClienteFormale(bodyConverter.getCommessaFatturabileDto().getTotaleOrdineClienteFormale());
		entity.setTotaleRicaviDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioAnno());
		entity.setTotaleRicaviDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioCommessa());
		//entity.setTimeSheet(null);
		commessaFatturabileRepo.save(entity);
		LOGGER.info("CommessaFatturabile creata e salvata a database");
	}
	
	public void createCommessaNonFatturabile(CommessaNonFatturabileDto dto) {
		CommessaNonFatturabile entity=new CommessaNonFatturabile();
		entity.setCodiceCommessa(dto.getCodiceCommessa());
		entity.setCreateUser("");
		entity.setDescrizione(dto.getDescrizione());
		commessaNonFatturabileRepo.save(entity);
	}
	
	public void createCommessa(CommessaDto dto) {
		Commessa entity= new Commessa();
		entity.setCodiceCommessa(dto.getCodiceCommessa());
		entity.setCommessaType(dto.getTipoCommessaType());
		entity.setCreateUser("");
		commessaRepo.save(entity);
	}

	public void readCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
	}

	public void updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
		if(entity != null) {
			commessaNonFatturabileRepo.delete(entity);
			Date date=new Date();
			//entity.setCodiceCommessa(dtoParam.getCodiceCommessa());
			entity.setDescrizione(dtoParam.getDescrizione());
			//entity.setCommessaType(dtoParam.getTipoCommessaType());
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
