package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.BodyConverter;
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

public interface ServiceInterface {
	
	public void login(String key, String username);
	
	public void createUser(UtenteDto userParam, String key);
	
	public Utente readUser(String id, String key);
	
	public Utente updateUser(UtenteDto userParam, String key);
	
	public void deleteUser(String id, String key);
	
	public Utente editStatusUser(UtenteDto userParam, String key);
	
	public void editRoleUser(RuoliDto roleParam, UtenteDto userParam, String key);
	
	public void createRole(RuoliDto role, String key);
	
	public Ruoli readRole(String role, String key);
	
	public Ruoli updateRole(RuoliDto role,String key);
	
	public void deleteRole(String role,String key);	
	
	public void createTimeSheet(String key, BodyConverter bodyConverter);
	
	public void editTimeSheet(TimeSheetDto timeSheetParam,String key, Commessa commessa, Utente utente);
	
	public void createCustomerPersonalData(AnagraficaClienteDto dtoParam, String key);
	
	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam, String key);
	
	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam, String key);
	
	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam, String key);
	
	public void createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam, String key);
	
	public void readCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam,String key);
	
	public void updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam, String key);
	
	public void deleteCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam, String key);
	
	public void createOrdineCommessa (OrdineCommessaDto dtoParam, String key);
	
	public void createRelazioneDipendenteCommessa(RelazioneDipendenteCommessaDto dtoParam, String key);
}
