package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;

public interface TrackerCommessaInterface {

	public CommessaNonFatturabile createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam,CommessaDto dtoCommessa);

	public CommessaNonFatturabile readCommessaNonFatturabile(String commessa);

	public CommessaNonFatturabileDto updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam);

	public void deleteCommessaNonFatturabile(String codiceCommessa);
	
	public Commessa createCommessa(CommessaDto dto);
	
	public CommessaNonFatturabileDto fromEntityToDto (CommessaNonFatturabile commessa);

}
