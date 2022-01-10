package com.perigea.tracker.timesheet.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.UserController;
import com.perigea.tracker.timesheet.dto.RelazioneDipendenteCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.RelazioneDipendenteCommessa;
import com.perigea.tracker.timesheet.entity.Utente;
import com.perigea.tracker.timesheet.mapstruct.DtoEntityMapper;
import com.perigea.tracker.timesheet.repository.RelazioneDipendenteCommessaRepository;
import com.perigea.tracker.timesheet.repository.UtenteRepository;
import com.perigea.tracker.timesheet.utility.TSUtils;


@Service
public class UserService{

	@Autowired
	private UtenteRepository userRepo;


	@Autowired
	private RelazioneDipendenteCommessaRepository relazioneDipComRepo;

	//@ TODO controllare spring security.
	//@ TODO parametri di autenticazione con le chiamate rest
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	//Metodo per creare un nuovo utente per poi inserirlo a database
	public UtenteDto createUser(UtenteDto userParam) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		Utente user = DtoEntityMapper.INSTANCE.fromDtoToEntityUtente(userParam);
		user.setCodicePersona(TSUtils.uuid());
		LOGGER.info("Utente creato");
		userRepo.save(user);
		LOGGER.info("Utente salvato a database");
		UtenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoUtente(user);
		return dto;
	}

	//Metodo per leggere i dati di un determinato utente
	public UtenteDto readUser(String userParam) {
		Utente entity=userRepo.findByCodicePersona(userParam);
		UtenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoUtente(entity);
		return dto;
	}

	//Metodo per aggiornare i dati di un utente
	public UtenteDto updateUser(UtenteDto userParam) {
		Utente entity=userRepo.findByCodicePersona(userParam.getCodicePersona());
		if(entity != null) {
			entity = DtoEntityMapper.INSTANCE.fromDtoToEntityUtente(userParam);
			userRepo.save(entity);
		}
		UtenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoUtente(entity);
		return dto;
	}

	//Metodo per eliminare un utente da database
	public UtenteDto deleteUser(String id) {
		Utente entity= userRepo.findByCodicePersona(id);
		UtenteDto dto=DtoEntityMapper.INSTANCE.fromEntityToDtoUtente(entity);
		return dto;
	}

	//Metodo per aggiornare lo stato (attivo/cessato) di un utente
	public UtenteDto editStatusUser(UtenteDto userParam) {
		Utente entity=userRepo.findByCodicePersona(userParam.getCodicePersona());
		if(entity != null) {
			entity.setStatoUtenteType(userParam.getStatoUtenteType());
			entity.setLastUpdateUser("");
			userRepo.save(entity);
		} else {
			LOGGER.info("CodicePersona non trovato");
		}
		UtenteDto dto = DtoEntityMapper.INSTANCE.fromEntityToDtoUtente(entity);
		return dto;
	}


	public void editRoleUser(RuoliDto roleParam, UtenteDto userParam) {
		//		if(mapEditUser.containsKey(key)) {
		//			List<UtenteEntity> entity=userRepo.findByRuoloType(roleParam.getRuoloType().toString());
		//			for(UtenteEntity u: entity) {
		//				if(u.getCodicePersona().equalsIgnoreCase(userParam.getCodicePersona())) {
		//					u.setStatoUtenteType(userParam.getStatoUtenteType().toString());
		//				}
		//			}
		//		} else {
		//			LOGGER.info("CreateUser non trovato");
		//		}
	}



	//-------------------------------------------------------------------------------------------
	public void editStatusTimeSheet(TimeSheetDto timeSheetParam) {
		//		if(mapEditUser.containsKey(key)) {
		//			TimeSheet timeSheetEntity=timeSheetRepo.findByCodicePersona(timeSheetParam.getCodiceCommessa());
		//			if(timeSheetEntity != null) {
		//				timeSheetEntity.setStatoType(timeSheetParam.getStatoType().toString());
		//				timeSheetRepo.save(timeSheetEntity);
		//			} else {
		//				LOGGER.info("CodicePersona non trovato");
		//			}
		//		} else {
		//			LOGGER.info("CreateUser non trovato");
		//		}
	}


	public void createRelazioneDipendenteCommessa(RelazioneDipendenteCommessaDto dtoParam) {
		RelazioneDipendenteCommessa entity = DtoEntityMapper.INSTANCE
				.fromDtoToEntityRelazioneDipendenteCommessa(dtoParam);
		Date date=new Date();
		//			entity.setCommessa(dtoParam.getCodiceCommessa());
		//			entity.setUtente(dtoParam.getCodicePersona());
		entity.setDataInizioAllocazione(dtoParam.getDataInizioAllocazione());
		entity.setDataFineAllocazione(dtoParam.getDataFineAllocazione());
		entity.setGiorniPrevisti(dtoParam.getGiorniPrevisti());
		entity.setGiorniErogati(dtoParam.getGiorniErogati());
		entity.setGiorniResidui(dtoParam.getGiorniResidui());
		entity.setImportoPrevisto(dtoParam.getImportoPrevisto());
		entity.setImportoErogato(dtoParam.getImportoErogato());
		entity.setImportoResiduo(dtoParam.getImportoResiduo());
		entity.setTariffa(dtoParam.getTariffa());
		entity.setCreateTimestamp(date);
		entity.setLastUpdateTimestamp(date);
		entity.setCreateUser("");
		entity.setLastUpdateUser("");
		relazioneDipComRepo.save(entity);
		LOGGER.info("Relazione Dipendente-commessa creata e salvata a database");
	}

}
