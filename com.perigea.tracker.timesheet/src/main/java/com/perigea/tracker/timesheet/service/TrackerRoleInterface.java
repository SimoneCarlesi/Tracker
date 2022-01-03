package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.EnumConverter;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.entity.Utente;

public interface TrackerRoleInterface {

	public void createRole(RuoliDto role);

	public RuoliDto readRole(String role);

	public RuoliDto updateRole(RuoliDto role);

	public void deleteRole(String role);
	
	public RuoliDto fromEntityToDto (Ruoli entity);

}
