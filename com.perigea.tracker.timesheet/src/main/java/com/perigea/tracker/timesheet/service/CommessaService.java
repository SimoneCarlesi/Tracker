package com.perigea.tracker.timesheet.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.UserController;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaFatturabileDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.CommessaFatturabile;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;
import com.perigea.tracker.timesheet.mapstruct.DtoEntityMapper;
import com.perigea.tracker.timesheet.repository.CommessaFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.repository.CommessaRepository;
import com.perigea.tracker.timesheet.repository.OrdineCommessaRepository;
import com.perigea.tracker.timesheet.utility.TSUtils;
import com.perigea.tracker.timesheet.wrapper.CommessaFatturabileWrapper;

@Service
public class CommessaService{

	@Autowired
	private CommessaNonFatturabileRepository commessaNonFatturabileRepo;

	@Autowired
	private CommessaFatturabileRepository commessaFatturabileRepo;
	
	@Autowired
	private CommessaRepository commessaRepo;
	
	@Autowired
	private OrdineCommessaRepository ordineCommessaRepo;
	
	@Autowired
	private ClientService trackerClient;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	public CommessaFatturabileDto createCommessaFatturabile(CommessaFatturabileWrapper bodyConverter) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		CommessaFatturabile entity=new CommessaFatturabile();
		
		//AnagraficaCliente relazionata
		AnagraficaClienteDto ana=trackerClient.createCustomerPersonalData(bodyConverter.getAnagraficaCliente());
		AnagraficaCliente anaEntity=DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaCliente(ana);
		entity.setRagioneSociale(anaEntity);
		//Commessa relazionata
		CommessaDto commessaDto=createCommessa(bodyConverter.getDtoCommessa());
		Commessa commessa=DtoEntityMapper.INSTANCE.fromDtoToEntityCommessa(commessaDto);
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
		CommessaFatturabileDto dto=DtoEntityMapper.INSTANCE.fromEntityToDtoCommessaFatturabile(entity);
		return dto;
	}
	
	public CommessaNonFatturabileDto createCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam,CommessaDto dtoCommessa) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		CommessaNonFatturabile entity=new CommessaNonFatturabile();
		CommessaDto commessaDto=createCommessa(dtoCommessa);
		Commessa commessa=DtoEntityMapper.INSTANCE.fromDtoToEntityCommessa(commessaDto);
		entity.setCommessaNonFatturabile(commessa);
		entity.setCreateUser("");
		entity.setDescrizione(dtoParam.getDescrizione());
		commessa.setCommessaNonFatturabile(entity);
		commessaNonFatturabileRepo.save(entity);
		CommessaNonFatturabileDto dto=fromEntityToDtoCommessaNonFatturabile(entity);
		return dto;
	}
	
	public CommessaDto createCommessa(CommessaDto dto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Commessa entity= new Commessa();
		entity.setCodiceCommessa(TSUtils.UUDI());
		entity.setCommessaType(dto.getTipoCommessaType());
		entity.setCreateUser("");
		entity.setCommessaType(dto.getTipoCommessaType());
		return dto;
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
		CommessaNonFatturabileDto dto=fromEntityToDtoCommessaNonFatturabile(entity);
		return dto;
	}

	public void deleteCommessaNonFatturabile(String codiceCommessa) {
		CommessaNonFatturabile entity=commessaNonFatturabileRepo.findByCodiceCommessa(codiceCommessa);
		if(entity != null) {
			commessaNonFatturabileRepo.delete(entity);
		}
	}
	
	public CommessaNonFatturabileDto fromEntityToDtoCommessaNonFatturabile(CommessaNonFatturabile entity) {
		CommessaNonFatturabileDto dto=new CommessaNonFatturabileDto();
		dto.setCodiceCommessa(entity.getCodiceCommessa());
		dto.setDescrizione(entity.getDescrizione());
		return dto;
	}

	public OrdineCommessa createOrdineCommessa (CommessaFatturabileWrapper bodyConverter) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		OrdineCommessa entityOrdineCommessa = new OrdineCommessa();
		CommessaFatturabileDto commessaFatturabileDto=createCommessaFatturabile(bodyConverter);
		CommessaFatturabile entityCommessaFatturabile=DtoEntityMapper.INSTANCE.fromDtoToEntityCommessaFatturabile(commessaFatturabileDto);
		entityOrdineCommessa.setCommessaFatturabile(entityCommessaFatturabile);
		entityCommessaFatturabile.setOrdineCommessa(entityOrdineCommessa);
		entityOrdineCommessa.setCreateUser("");
		entityOrdineCommessa.setDataInizio(bodyConverter.getOrdineCommessa().getDataInizio());
		entityOrdineCommessa.setDataFine(bodyConverter.getOrdineCommessa().getDataFine());
		entityOrdineCommessa.setDataOrdine(bodyConverter.getOrdineCommessa().getDataOrdine());
		entityOrdineCommessa.setImportoOrdine(bodyConverter.getOrdineCommessa().getImportoOrdine());
		entityOrdineCommessa.setImportoResiduo(bodyConverter.getOrdineCommessa().getImportoResiduo());
		entityOrdineCommessa.setNumeroOrdineCliente(bodyConverter.getOrdineCommessa().getNumeroOrdineCliente());
		ordineCommessaRepo.save(entityOrdineCommessa);
		LOGGER.info("Ordine commessa creato e salvato a database");
		return entityOrdineCommessa;
	}
}