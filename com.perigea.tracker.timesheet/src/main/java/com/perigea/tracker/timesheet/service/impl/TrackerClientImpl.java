package com.perigea.tracker.timesheet.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perigea.tracker.timesheet.controller.TrackerController;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;
import com.perigea.tracker.timesheet.repository.AnagraficaClienteRepository;
import com.perigea.tracker.timesheet.repository.OrdineCommessaRepository;
import com.perigea.tracker.timesheet.service.TrackerClientInterface;

@Service
public class TrackerClientImpl implements TrackerClientInterface {
	
	@Autowired
	private AnagraficaClienteRepository anagraficaClienteRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TrackerController.class);
	
	@Autowired
	private OrdineCommessaRepository ordineCommessaRepo;
	
	public void createCustomerPersonalData(AnagraficaClienteDto dtoParam) {
			AnagraficaCliente entity=new AnagraficaCliente();
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
			entity.setCreateUser("");
			LOGGER.info("Entity dati anagrafici cliente creato e aggiunto a database");
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
	
	public void createOrdineCommessa (OrdineCommessaDto dtoParam) {
			OrdineCommessa entity = new OrdineCommessa();
			Date date=new Date();
//			entity.set(dtoParam.getCodiceCommessa().toString());
			entity.setCreateTimestamp(date);
			entity.setCreateUser("");
			entity.setDataInizio(dtoParam.getDataInizio());
			entity.setDataFine(dtoParam.getDataFine());
			entity.setDataOrdine(dtoParam.getDataOrdine());
			entity.setImportoOrdine(dtoParam.getImportoOrdine());
			entity.setImportoResiduo(dtoParam.getImportoResiduo());
			entity.setNumeroOrdineCliente(dtoParam.getNumeroOrdineCliente());
//			entity.setRagioneSocialeCliente(dtoParam.getRagioneSocialeCliente());
			ordineCommessaRepo.save(entity);
			LOGGER.info("Ordine commessa creato e salvato a database");
	}

}
