package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;
import java.util.UUID;

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
import com.perigea.tracker.timesheet.entity.NotaSpese;
import com.perigea.tracker.timesheet.repository.CommessaFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaRepository;
import com.perigea.tracker.timesheet.service.TrackerCommessaInterface;
//@ TODO creare una classe di utilità per gl iID
@Service
public class TrackerCommessaImpl implements TrackerCommessaInterface {

	@Autowired
	private CommessaNonFatturabileRepository commessaNonFatturabileRepo;

	@Autowired
	private CommessaFatturabileRepository commessaFatturabileRepo;
	
	@Autowired
	private CommessaRepository commessaRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);
	
	public void createCommessaFatturabile(BodyConverterCommessaFatturabile bodyConverter/*CommessaDto dtoCommessa*/) {
//		CommessaFatturabile entity=new CommessaFatturabile();
//		NotaSpese notaSpese=createNotaSpese();
//		Commessa commessa=createCommessa(dtoCommessa);
//		//entity.setCommessaType(bodyConverter.getCommessaFatturabileDto().getTipoCommessaType());
//		entity.setCreateUser(bodyConverter.getCommessaFatturabileDto().getCreateUser());
//		Date date=new Date();
//		entity.setDataInizioCommessa(date);
//		entity.setTipoCommessaFatturabileType(bodyConverter.getCommessaFatturabileDto().getTipoCommessa());
//		entity.setDataFineCommessa(bodyConverter.getCommessaFatturabileDto().getDataFineCommessa());
//		entity.setImportoCommessaInizialePresunto(bodyConverter.getCommessaFatturabileDto().getImportoCommessaInizialePresunto());
//		entity.setDescrizioneCommessaCliente(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaCliente());
//		entity.setDescrizioneCommessaPerigea(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaPerigea());
//		entity.setMargineDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioAnno());
//		entity.setMargineDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioCommessa());
//		entity.setMargineIniziale(bodyConverter.getCommessaFatturabileDto().getMargineIniziale());
//		entity.setOrdineCommessa(bodyConverter.getOrdineCommessa());
//		entity.setOrdineInternoCorrente(bodyConverter.getCommessaFatturabileDto().getOrdineInternoCorrente());
//		//entity.setNotaSpese(bodyConverter.getNotaSpese());
//		entity.setTotaleCostiDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioAnno());
//		entity.setTotaleCostiDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioCommessa());
//		entity.setTotaleEstensioni(bodyConverter.getCommessaFatturabileDto().getTotaleEstensioni());
//		entity.setTotaleFatturatoDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoDaInizioAnno());
//		entity.setTotaleFatturatoreDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoreDaInizioCommessa());
//		entity.setTotaleOrdine(bodyConverter.getCommessaFatturabileDto().getTotaleOrdine());
//		entity.setTotaleOrdineClienteFormale(bodyConverter.getCommessaFatturabileDto().getTotaleOrdineClienteFormale());
//		entity.setTotaleRicaviDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioAnno());
//		entity.setTotaleRicaviDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioCommessa());
//		commessaFatturabileRepo.save(entity);
//		LOGGER.info("CommessaFatturabile creata e salvata a database");
	}
	
	public CommessaNonFatturabile createCommessaNonFatturabile(CommessaNonFatturabileDto dto,CommessaDto dtoCommessa) {
		CommessaNonFatturabile entity=new CommessaNonFatturabile();
		Commessa commessa=createCommessa(dtoCommessa);
		entity.setCommessaNonFatturabile(commessa);
		entity.setCreateUser("");
		entity.setDescrizione(dto.getDescrizione());
		commessa.setCommessaNonFatturabile(entity);
		commessaNonFatturabileRepo.save(entity);
		return entity;
	}
	
	public Commessa createCommessa(CommessaDto dto) {
		Commessa entity= new Commessa();
		entity.setCodiceCommessa(UUID.randomUUID().toString());
		entity.setCommessaType(dto.getTipoCommessaType());
		entity.setCreateUser("");
		return entity;
	}
	
	public void deleteCommessa(String codiceCommessa) {
		Commessa entity=commessaRepo.findByCodiceCommessa(codiceCommessa);
		if(entity != null) {
			commessaRepo.delete(entity);
		}
	}

	public CommessaNonFatturabile readCommessaNonFatturabile(String codiceCommessa) {
		CommessaNonFatturabile commessa=commessaNonFatturabileRepo.findByCodiceCommessa(codiceCommessa);
		return commessa;
	}

	public CommessaNonFatturabileDto updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
		if(entity != null) {
			entity.setCodiceCommessa(dtoParam.getCodiceCommessa());
			entity.setDescrizione(dtoParam.getDescrizione());
			entity.setLastUpdateUser("");
			commessaNonFatturabileRepo.save(entity);
		}
		CommessaNonFatturabileDto dto=fromEntityToDto(entity);
		return dto;
	}

	public void deleteCommessaNonFatturabile(String codiceCommessa) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(codiceCommessa);
		if(entity != null) {
			commessaNonFatturabileRepo.delete(entity);
		}
	}
	
	public CommessaNonFatturabileDto fromEntityToDto(CommessaNonFatturabile entity) {
		CommessaNonFatturabileDto dto=new CommessaNonFatturabileDto();
		dto.setCodiceCommessa(entity.getCodiceCommessa());
		dto.setDescrizione(entity.getDescrizione());
		return dto;
	}

}
