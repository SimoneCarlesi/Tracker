package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerUserController;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;
import com.perigea.tracker.timesheet.entity.Utente;
import com.perigea.tracker.timesheet.repository.AnagraficaClienteRepository;
import com.perigea.tracker.timesheet.repository.OrdineCommessaRepository;
import com.perigea.tracker.timesheet.service.TrackerClientInterface;

@Service
public class TrackerClientImpl implements TrackerClientInterface {
	
	@Autowired
	private AnagraficaClienteRepository anagraficaClienteRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerUserController.class);
	
	
	public AnagraficaClienteDto createCustomerPersonalData(AnagraficaClienteDto dto) {
			AnagraficaCliente entity=new AnagraficaCliente();
			entity.setAcronimoCliente(dto.getAcronimoCliente());
			entity.setCodiceDestinatario(dto.getCodiceDestinatario());
			entity.setCodiceFiscale(dto.getCodiceFiscale());
			entity.setNotePerLaFatturazione(dto.getNotePerLaFatturazione());
			entity.setPartitaIva(dto.getPartitaIva());
			entity.setRagioneSocialeCliente(dto.getRagioneSocialeCliente());
			entity.setSedeLegaleCap(dto.getSedeLegaleCap());
			entity.setSedeLegaleComune(dto.getSedeLegaleComune());
			entity.setSedeLegaleIndirizzo(dto.getSedeLegaleIndirizzo());
			entity.setSedeOperativaCap(dto.getSedeOperativaCap());
			entity.setSedeOperativaComune(dto.getSedeOperativaComune());
			entity.setSedeOperativaIndirizzo(dto.getSedeOperativaIndirizzo());
			entity.setProgressivoPerCommesse(dto.getProgressivoPerCommesse());
			entity.setTipologiaPagamentoType(dto.getTipologiaPagamentoType());
			entity.setCreateUser("");
			anagraficaClienteRepo.save(entity);
			LOGGER.info("Entity dati anagrafici cliente creato e aggiunto a database");
			AnagraficaClienteDto dtoParam=fromEntityToDto(entity);
			return dtoParam;
	}
	
	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam) {
			anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
	}
	
	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam) {
			AnagraficaCliente entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			if(entity != null) {
				anagraficaClienteRepo.delete(entity);
				Date date=new Date();
				entity.setRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
				entity.setAcronimoCliente(dtoParam.getAcronimoCliente());
				entity.setCodiceDestinatario(dtoParam.getCodiceDestinatario());
				entity.setCodiceFiscale(dtoParam.getCodiceFiscale());
				entity.setNotePerLaFatturazione(dtoParam.getNotePerLaFatturazione());
				entity.setPartitaIva(dtoParam.getPartitaIva());
				entity.setProgressivoPerCommesse(dtoParam.getProgressivoPerCommesse());
				entity.setSedeLegaleCap(dtoParam.getAcronimoCliente());
				entity.setSedeOperativaComune(dtoParam.getSedeLegaleComune());
				entity.setSedeOperativaIndirizzo(dtoParam.getSedeLegaleIndirizzo());
				entity.setLastUpdateTimestamp(date);
				entity.setLastUpdateUser("");
				anagraficaClienteRepo.save(entity);
			}
	}
	
	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam) {
			AnagraficaCliente entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			if(entity != null) {
				anagraficaClienteRepo.delete(entity);
			}
	}
	
	public AnagraficaClienteDto fromEntityToDto(AnagraficaCliente entity) {
		AnagraficaClienteDto dto=new AnagraficaClienteDto();
		dto.setAcronimoCliente(entity.getAcronimoCliente());
		dto.setCodiceDestinatario(entity.getCodiceDestinatario());
		dto.setCodiceFiscale(entity.getCodiceFiscale());
		dto.setNotePerLaFatturazione(entity.getNotePerLaFatturazione());
		dto.setPartitaIva(entity.getPartitaIva());
		dto.setProgressivoPerCommesse(entity.getProgressivoPerCommesse());
		dto.setRagioneSocialeCliente(entity.getRagioneSocialeCliente());
		dto.setSedeLegaleCap(entity.getSedeLegaleCap());
		dto.setSedeLegaleComune(entity.getSedeLegaleComune());
		dto.setSedeLegaleIndirizzo(entity.getSedeLegaleIndirizzo());
		dto.setSedeOperativaCap(entity.getSedeOperativaCap());
		dto.setSedeOperativaComune(entity.getSedeOperativaComune());
		dto.setSedeOperativaIndirizzo(entity.getSedeOperativaIndirizzo());
		dto.setCreateUser("");
		return dto;
	}
	
	public AnagraficaCliente fromDtoToEntity(AnagraficaClienteDto dto) {
		AnagraficaCliente entity=new AnagraficaCliente();
		entity.setAcronimoCliente(dto.getAcronimoCliente());
		entity.setCodiceDestinatario(dto.getCodiceDestinatario());
		entity.setCodiceFiscale(dto.getCodiceFiscale());
		entity.setNotePerLaFatturazione(dto.getNotePerLaFatturazione());
		entity.setPartitaIva(dto.getPartitaIva());
		entity.setRagioneSocialeCliente(dto.getRagioneSocialeCliente());
		entity.setSedeLegaleCap(dto.getSedeLegaleCap());
		entity.setSedeLegaleComune(dto.getSedeLegaleComune());
		entity.setSedeLegaleIndirizzo(dto.getSedeLegaleIndirizzo());
		entity.setSedeOperativaCap(dto.getSedeOperativaCap());
		entity.setSedeOperativaComune(dto.getSedeOperativaComune());
		entity.setSedeOperativaIndirizzo(dto.getSedeOperativaIndirizzo());
		entity.setCreateUser("");
		return entity;
	}
	

}
