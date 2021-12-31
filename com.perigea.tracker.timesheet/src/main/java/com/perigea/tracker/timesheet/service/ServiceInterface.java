package com.perigea.tracker.timesheet.service;

import java.util.List;

import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.RelazioneDipendenteCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;

public interface ServiceInterface {
	
	public void login(String psw, String createUser);
	
	public void createUser(UtenteDto userParam, String key);
	
	public void readUser(UtenteDto userParam, String key);
	
	public void updateUser(UtenteDto userParam, String key);
	
	public void deleteUser(String userParam, String key);
	
	public void editStatusUser(UtenteDto userParam, String key);
	
	public void createRole(RuoliDto role, String key);
	
	public void readRole(RuoliDto role, String key);
	
	public void updateRole(RuoliDto role,String key);
	
	public void deleteRole(RuoliDto role,String key);
	
	public void roleAssignmentToUser(RuoliDto roleParam, UtenteDto userParam, String key);
	
	public void createTimeSheet(TimeSheetDto timeSheetParam,String key);
	
	public void editTimeSheet(TimeSheetDto timeSheetParam,String key);
	
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
