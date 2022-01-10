package com.perigea.tracker.timesheet.service;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perigea.tracker.timesheet.controller.UtenteController;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.exception.ClienteException;
import com.perigea.tracker.timesheet.mapstruct.DtoEntityMapper;
import com.perigea.tracker.timesheet.repository.AnagraficaClienteRepository;


@Service
public class ClienteService{
	
	@Autowired
	private AnagraficaClienteRepository anagraficaClienteRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UtenteController.class);
	
	
	public AnagraficaClienteDto createCustomerPersonalData(AnagraficaClienteDto dto) {
		try {
			AnagraficaCliente entity=DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaCliente(dto);
			anagraficaClienteRepo.save(entity);
			LOGGER.info("Entity dati anagrafici cliente creato e aggiunto a database");
			AnagraficaClienteDto dtoParam=fromEntityToDto(entity);
			return dtoParam;
		} catch (Exception ex) {
			throw new ClienteException("Anagrafica cliente non creata");
		}
	}
	
	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam) {
		try {
			anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
		} catch (Exception ex) {
			throw new EntityNotFoundException("Anagrafica cliente non trovata");
		}
	}
	
	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam) {
		try {
			AnagraficaCliente entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			if(entity != null) {
				entity=DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaCliente(dtoParam);
				anagraficaClienteRepo.save(entity);
			}
		} catch (Exception ex) {
			throw new EntityNotFoundException("Anagrafica cliente non trovata");
		}
	}
	
	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam) {
		try {
			AnagraficaCliente entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			if(entity != null) {
				anagraficaClienteRepo.delete(entity);
			}
		} catch (Exception ex) {
			throw new EntityNotFoundException("Anagrafica cliente non trovata");
		}
	}
	
	public AnagraficaClienteDto fromEntityToDto(AnagraficaCliente entity) {
		try {
			AnagraficaClienteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoAnagraficaCliente(entity);
			//		dto.setCreateUser("");
			return dto;
		} catch (Exception ex) {
			throw new EntityNotFoundException("Anagrafica cliente non trovata");
		}
	}

	public AnagraficaCliente fromDtoToEntity(AnagraficaClienteDto dto) {
		try {
			AnagraficaCliente entity = DtoEntityMapper.INSTANCE.fromDtoToEntityAnagraficaCliente(dto);
			//		entity.setCreateUser("");
			return entity;
		} catch (Exception ex) {
			throw new EntityNotFoundException("Anagrafica cliente non trovata");
		}
	}
	

}
