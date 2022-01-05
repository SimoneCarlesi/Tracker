package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerController;
import com.perigea.tracker.timesheet.converter.CommessaFatturabileWrapper;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.CommessaFatturabile;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;
import com.perigea.tracker.timesheet.repository.CommessaFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaRepository;
import com.perigea.tracker.timesheet.repository.OrdineCommessaRepository;
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
	
	@Autowired
	private OrdineCommessaRepository ordineCommessaRepo;
	
	@Autowired
	private TrackerClientImpl trackerClient;
	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);
	
	//@ TODO fare
	public CommessaFatturabile createCommessaFatturabile(CommessaFatturabileWrapper bodyConverter) {
		CommessaFatturabile entity=new CommessaFatturabile();
		
		//AnagraficaCliente relazionata
		AnagraficaClienteDto ana=trackerClient.createCustomerPersonalData(bodyConverter.getAnagraficaCliente());
		AnagraficaCliente anaEntity=trackerClient.fromDtoToEntity(ana);
		entity.setRagioneSociale(anaEntity);
		//Commessa relazionata
		Commessa commessa=createCommessa(bodyConverter.getDtoCommessa());
		entity.setCommessaFatturabile(commessa);
		commessa.setCommessaFatturabile(entity);
		
		entity.setCreateUser("");
		Date date=new Date();
		entity.setDataInizioCommessa(date);
		entity.setTipoCommessaFatturabileType(bodyConverter.getCommessaFatturabileDto().getTipoCommessa());
		entity.setDataFineCommessa(bodyConverter.getCommessaFatturabileDto().getDataFineCommessa());
		entity.setImportoCommessaInizialePresunto(bodyConverter.getCommessaFatturabileDto().getImportoCommessaInizialePresunto());
		entity.setDescrizioneCommessaCliente(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaCliente());
		entity.setDescrizioneCommessaPerigea(bodyConverter.getCommessaFatturabileDto().getDescrizioneCommessaPerigea());
		entity.setMargineDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioAnno());
		entity.setMargineDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getMargineDaInizioCommessa());
		entity.setMargineIniziale(bodyConverter.getCommessaFatturabileDto().getMargineIniziale());
		entity.setOrdineInternoCorrente(bodyConverter.getCommessaFatturabileDto().getOrdineInternoCorrente());
		entity.setResponsabileCommerciale(bodyConverter.getCommessaFatturabileDto().getResponsabileCommerciale());
		entity.setPercentualeAvanzamentoCosti(bodyConverter.getCommessaFatturabileDto().getPercentualeAvanzamentoCosti());
		entity.setPercentualeAvanzamentoFatturazione(bodyConverter.getCommessaFatturabileDto().getPercentualeAvanzamentoFatturazione());
		entity.setPercentualeSconto(bodyConverter.getCommessaFatturabileDto().getPercentualeSconto());
		entity.setTotaleCostiDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioAnno());
		entity.setTotaleCostiDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleCostiDaInizioCommessa());
		entity.setTotaleEstensioni(bodyConverter.getCommessaFatturabileDto().getTotaleEstensioni());
		entity.setTotaleFatturatoDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoDaInizioAnno());
		entity.setTotaleFatturatoreDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleFatturatoreDaInizioCommessa());
		entity.setTotaleOrdine(bodyConverter.getCommessaFatturabileDto().getTotaleOrdine());
		entity.setTotaleOrdineClienteFormale(bodyConverter.getCommessaFatturabileDto().getTotaleOrdineClienteFormale());
		entity.setTotaleRicaviDaInizioAnno(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioAnno());
		entity.setTotaleRicaviDaInizioCommessa(bodyConverter.getCommessaFatturabileDto().getTotaleRicaviDaInizioCommessa());
		commessaFatturabileRepo.save(entity);
		LOGGER.info("CommessaFatturabile creata e salvata a database");
		return entity;
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
		entity.setCommessaType(dto.getTipoCommessaType());
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

	public OrdineCommessa createOrdineCommessa (CommessaFatturabileWrapper bodyConverter) {
		OrdineCommessa entity = new OrdineCommessa();
		CommessaFatturabile commessaFatturabile=createCommessaFatturabile(bodyConverter);
		entity.setCommessaFatturabile(commessaFatturabile);
		commessaFatturabile.setOrdineCommessa(entity);
		entity.setCreateUser("");
		entity.setDataInizio(bodyConverter.getOrdineCommessa().getDataInizio());
		entity.setDataFine(bodyConverter.getOrdineCommessa().getDataFine());
		entity.setDataOrdine(bodyConverter.getOrdineCommessa().getDataOrdine());
		entity.setImportoOrdine(bodyConverter.getOrdineCommessa().getImportoOrdine());
		entity.setImportoResiduo(bodyConverter.getOrdineCommessa().getImportoResiduo());
		entity.setNumeroOrdineCliente(bodyConverter.getOrdineCommessa().getNumeroOrdineCliente());
		ordineCommessaRepo.save(entity);
		LOGGER.info("Ordine commessa creato e salvato a database");
		return entity;
	}



}
