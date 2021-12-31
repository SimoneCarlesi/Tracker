package com.perigea.tracker.timesheet.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.Controller;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.RelazioneDipendenteCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.AnagraficaClienteEntity;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabileEntity;
import com.perigea.tracker.timesheet.entity.OrdineCommessaEntity;
import com.perigea.tracker.timesheet.entity.RelazioneDipendenteCommessaEntity;
import com.perigea.tracker.timesheet.entity.RuoliEntity;
import com.perigea.tracker.timesheet.entity.TimeSheetEntity;
import com.perigea.tracker.timesheet.entity.UtenteEntity;
import com.perigea.tracker.timesheet.repository.AnagraficaClienteRepository;
import com.perigea.tracker.timesheet.repository.CommessaNonFatturabileRepository;
import com.perigea.tracker.timesheet.repository.OrdineCommessaRepository;
import com.perigea.tracker.timesheet.repository.RelazioneDipendenteCommessaRepository;
import com.perigea.tracker.timesheet.repository.RuoliRepository;
import com.perigea.tracker.timesheet.repository.TimeSheetRepository;
import com.perigea.tracker.timesheet.repository.UtenteRepository;


@Service
public class ServiceImpl implements ServiceInterface {
	
	@Autowired
	private TimeSheetRepository timeSheetRepo;
	
	@Autowired
	private UtenteRepository userRepo;
	
	@Autowired
	private RuoliRepository roleRepo;
	
	@Autowired
	private AnagraficaClienteRepository anagraficaClienteRepo;
	
	@Autowired
	private CommessaNonFatturabileRepository commessaNonFatturabileRepo;
	
	@Autowired
	private OrdineCommessaRepository ordineCommessaRepo;
	
	@Autowired
	private RelazioneDipendenteCommessaRepository relazioneDipComRepo;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	private static final Map<String,String> mapEditUser=new HashMap<>();
	
	public void login(String psw, String createUser) {
		mapEditUser.put(psw, createUser);
	}
	
	
	public void createUser(UtenteDto userParam, String key){
		if(mapEditUser.containsKey(key)) {
			UtenteEntity user=new UtenteEntity();
			user.setCodicePersona(userParam.getCodicePersona());
			user.setNome(userParam.getNome());
			user.setCognome(userParam.getCognome());
			user.setPassword(userParam.getPassword());
			user.setStatoUtenteType(userParam.getStatoUtenteType().toString());
			Date date=new Date();
			user.setCreateTimestamp(date);
			user.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			LOGGER.info("Utente creato");
			userRepo.save(user);
			LOGGER.info("Utente salvato a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void readUser(UtenteDto userParam, String key) {
		if(mapEditUser.containsKey(key)) {
			userRepo.findByCodicePersona(userParam.getCodicePersona());
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void updateUser(UtenteDto userParam, String key) {
		if(mapEditUser.containsKey(key)) {
			UtenteEntity entity=userRepo.findByCodicePersona(userParam.getCodicePersona());
			if(entity != null) {
				userRepo.delete(entity);
				Date date=new Date();
				entity.setLastUpdateTimestamp(date);
				entity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
				entity.setPassword(userParam.getPassword());
				entity.setStatoUtenteType(userParam.getStatoUtenteType().toString());
				userRepo.save(entity);
			} else {
				LOGGER.info("CreateUser non trovato");
			}
		}
	}
	
	public void deleteUser(String userParam, String key) {
		if(mapEditUser.containsKey(key)) {
			List<UtenteEntity> entity=(List<UtenteEntity>) userRepo.findAll();
			for(UtenteEntity u: entity) {
				if(u.getCodicePersona().equalsIgnoreCase(userParam)) {
					userRepo.delete(u);
				} else {
					LOGGER.info("CodicePersona non trovato");
				}
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	//--------------------------------------------------------------------------------------------
	public void editStatusUser(UtenteDto userParam, String key) {
		if(mapEditUser.containsKey(key)) {
			UtenteEntity entity=userRepo.findByCodicePersona(userParam.getCodicePersona());
			if(entity != null) {
				userRepo.delete(entity);
				Date date=new Date();
				entity.setCodicePersona(userParam.getCodicePersona());
				entity.setNome(userParam.getNome());
				entity.setCognome(userParam.getCognome());
				entity.setPassword(userParam.getPassword());
				entity.setStatoUtenteType(userParam.getStatoUtenteType().toString());
				entity.setLastUpdateTimestamp(date);
				entity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
				userRepo.save(entity);
			} else {
				LOGGER.info("CodicePersona non trovato");
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void createRole(RuoliDto roleParam,String key) {
		if(mapEditUser.containsKey(key)) {
			RuoliEntity role=new RuoliEntity();
			role.setDescrizioneRuolo(roleParam.getDescrizioneRuolo());
			role.setRuoloType(roleParam.getRuoloType().toString());
			LOGGER.info("Role creato");
			roleRepo.save(role);
			LOGGER.info("Role aggiunto a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void readRole(RuoliDto roleParam,String key) {
		if(mapEditUser.containsKey(key)) {
			roleRepo.findByRuoloType(roleParam.getRuoloType());
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void updateRole(RuoliDto roleParam, String key) {
		if(mapEditUser.containsKey(key)) {
			RuoliEntity entity=roleRepo.findByRuoloType(roleParam.getRuoloType());	
			if(entity != null) {
				roleRepo.delete(entity);
				entity.setDescrizioneRuolo(roleParam.getDescrizioneRuolo());
				entity.setRuoloType(roleParam.getRuoloType().toString());
				roleRepo.save(entity);
			} else {
				LOGGER.info("CreateUser non trovato");
			}
		}
	}
	
	public void deleteRole(RuoliDto roleParam, String key) {
		if(mapEditUser.containsKey(key)) {
			RuoliEntity entity=roleRepo.findByRuoloType(roleParam.getRuoloType());	
			if(entity != null) {
				roleRepo.delete(entity);
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
//	public void roleAssignmentToUser(RuoliDto roleParam, UtenteDto userParam, String key) {
//		if(mapEditUser.containsKey(key)) {
//			List<UtenteEntity> entity=userRepo.findByRuoloType(roleParam.getRuoloType());
//			for(UtenteEntity u: entity) {
//				if(u.getCodicePersona().equalsIgnoreCase(userParam.getCodicePersona())) {
//					u.setStatoUtenteType(userParam.getStatoUtenteType().toString());
//				}
//			}
//		} else {
//			LOGGER.info("CreateUser non trovato");
//		}
//	}
	
	
	public void createTimeSheet(TimeSheetDto timeSheetParam, String key) {
		if(mapEditUser.containsKey(key)) {
			TimeSheetEntity timeSheetEntity= new TimeSheetEntity();
			Date date=new Date();
			timeSheetEntity.setAnnoDiRiferimento(timeSheetParam.getAnnoDiRiferimento());
			timeSheetEntity.setMeseDiRiferimento(timeSheetParam.getMeseDiRiferimento());
			timeSheetEntity.setGiornoDiRiferimento(timeSheetParam.getGiornoDiRiferimento());
			timeSheetEntity.setStatoType(timeSheetParam.getStatoType().toString());
//			timeSheetEntity.setUtenteTime(timeSheetParam.getCodicePersona());
//			timeSheetEntity.setCommessaTime(timeSheetParam.getCodiceCommessa());
			timeSheetEntity.setOre(timeSheetParam.getOre());
			timeSheetEntity.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			timeSheetEntity.setCreateTimestamp(date);
			timeSheetRepo.save(timeSheetEntity);
			LOGGER.info("TimeSheet creato e aggiunto a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	
	public void editTimeSheet(TimeSheetDto timeSheetParam, String key) {
		if(mapEditUser.containsKey(key)) {
			TimeSheetEntity timeSheetEntity=timeSheetRepo.findByCodicePersona(timeSheetParam.getCodicePersona());
			if(timeSheetEntity != null) {
				timeSheetRepo.delete(timeSheetEntity);
				Date date=new Date();
				timeSheetEntity.setAnnoDiRiferimento(timeSheetParam.getAnnoDiRiferimento());
				timeSheetEntity.setMeseDiRiferimento(timeSheetParam.getMeseDiRiferimento());
				timeSheetEntity.setGiornoDiRiferimento(timeSheetParam.getGiornoDiRiferimento());
				timeSheetEntity.setStatoType(timeSheetParam.getStatoType().toString());
//				timeSheetEntity.setUtenteTime(timeSheetParam.getCodicePersona());
//				timeSheetEntity.setCommessaTime(timeSheetParam.getCodiceCommessa());
				timeSheetEntity.setOre(timeSheetParam.getOre());
				timeSheetEntity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
				timeSheetEntity.setLastUpdateTimestamp(date);
				timeSheetRepo.save(timeSheetEntity);
				LOGGER.info("TimeSheet modificato");
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	//-------------------------------------------------------------------------------------------
	public void editStatusTimeSheet(TimeSheetDto timeSheetParam, String key) {
		if(mapEditUser.containsKey(key)) {
			TimeSheetEntity timeSheetEntity=timeSheetRepo.findByCodicePersona(timeSheetParam.getCodiceCommessa());
			if(timeSheetEntity != null) {
				timeSheetEntity.setStatoType(timeSheetParam.getStatoType().toString());
				timeSheetRepo.save(timeSheetEntity);
			} else {
				LOGGER.info("CodicePersona non trovato");
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void createCustomerPersonalData(AnagraficaClienteDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			AnagraficaClienteEntity entity=new AnagraficaClienteEntity();
			Date date= new Date();
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
			entity.setCreateTimestamp(date);
			entity.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			LOGGER.info("Entity dati anagrafici cliente creato e aggiunto a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam,String key) {
		if(mapEditUser.containsKey(key)) {
			anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			AnagraficaClienteEntity entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
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
				entity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
				anagraficaClienteRepo.save(entity);
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			AnagraficaClienteEntity entity=anagraficaClienteRepo.findByRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			if(entity != null) {
				anagraficaClienteRepo.delete(entity);
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam, String key){
		if(mapEditUser.containsKey(key)) {
			CommessaNonFatturabileEntity entity=new CommessaNonFatturabileEntity();
			Date date=new Date();
			entity.setCodiceCommessa(commessaParam.getCodiceCommessa());
			entity.setDescrizione(commessaParam.getDescrizione());
			entity.setCommessaType(commessaParam.getTipoCommessaType().toString());
			entity.setCreateTimestamp(date);
			entity.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			commessaNonFatturabileRepo.save(entity);
			LOGGER.info("Commessa creata e salvata a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void readCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam,String key) {
		if(mapEditUser.containsKey(key)) {
			commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			CommessaNonFatturabileEntity entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
			if(entity != null) {
				commessaNonFatturabileRepo.delete(entity);
				Date date=new Date();
				entity.setCodiceCommessa(dtoParam.getCodiceCommessa());
				entity.setDescrizione(dtoParam.getDescrizione());
				entity.setCommessaType(dtoParam.getTipoCommessaType().toString());
				entity.setLastUpdateTimestamp(date);
				entity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
				commessaNonFatturabileRepo.save(entity);
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void deleteCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			CommessaNonFatturabileEntity entity=commessaNonFatturabileRepo.findByCodiceCommessa(dtoParam.getCodiceCommessa());
			if(entity != null) {
				commessaNonFatturabileRepo.delete(entity);
			}
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void createOrdineCommessa (OrdineCommessaDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			OrdineCommessaEntity entity = new OrdineCommessaEntity();
			Date date=new Date();
//			entity.set(dtoParam.getCodiceCommessa().toString());
			entity.setCreateTimestamp(date);
			entity.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			entity.setDataInizio(dtoParam.getDataInizio());
			entity.setDataFine(dtoParam.getDataFine());
			entity.setDataOrdine(dtoParam.getDataOrdine());
			entity.setImportoOrdine(dtoParam.getImportoOrdine());
			entity.setImportoResiduo(dtoParam.getImportoResiduo());
			entity.setNumeroOrdineCliente(dtoParam.getNumeroOrdineCliente());
//			entity.setRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			ordineCommessaRepo.save(entity);
			LOGGER.info("Ordine commessa creato e salvato a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}
	
	public void createRelazioneDipendenteCommessa(RelazioneDipendenteCommessaDto dtoParam, String key) {
		if(mapEditUser.containsKey(key)) {
			RelazioneDipendenteCommessaEntity entity = new RelazioneDipendenteCommessaEntity();
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
			entity.setCreateUser(mapEditUser.get(key)+mapEditUser.get(key));
			entity.setLastUpdateUser(mapEditUser.get(key)+mapEditUser.get(key));
			relazioneDipComRepo.save(entity);
			LOGGER.info("Relazione Dipendente-commessa creata e salvata a database");
		} else {
			LOGGER.info("CreateUser non trovato");
		}
	}


	@Override
	public void roleAssignmentToUser(RuoliDto roleParam, UtenteDto userParam, String key) {
		// TODO Auto-generated method stub
		
	}



}
