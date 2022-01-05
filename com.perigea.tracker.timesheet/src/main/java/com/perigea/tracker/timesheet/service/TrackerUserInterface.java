package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.TimeSheetWrapper;
import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.RelazioneDipendenteCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.entity.Utente;

public interface TrackerUserInterface {
	
	
	public UtenteDto createUser(UtenteDto userParam);
	
	public UtenteDto readUser(String id);
	
	public UtenteDto updateUser(UtenteDto userParam);
	
	public void deleteUser(String id);
	
	public UtenteDto editStatusUser(UtenteDto userParam);
	
	public void editRoleUser(RuoliDto roleParam, UtenteDto userParam);
	
	public void createRelazioneDipendenteCommessa(RelazioneDipendenteCommessaDto dtoParam);
	
	public UtenteDto fromEntityToDto (Utente entity);
}
