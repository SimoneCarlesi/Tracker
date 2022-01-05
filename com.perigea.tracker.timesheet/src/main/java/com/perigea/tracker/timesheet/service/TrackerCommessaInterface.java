package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.CommessaFatturabileWrapper;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.CommessaNonFatturabile;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;

public interface TrackerCommessaInterface {

	public CommessaNonFatturabile createCommessaNonFatturabile(CommessaNonFatturabileDto commessaParam,CommessaDto dtoCommessa);

	public CommessaNonFatturabile readCommessaNonFatturabile(String commessa);

	public CommessaNonFatturabileDto updateCommessaNonFatturabile(CommessaNonFatturabileDto dtoParam);

	public void deleteCommessaNonFatturabile(String codiceCommessa);
	
	public Commessa createCommessa(CommessaDto dto);
	
	public CommessaNonFatturabileDto fromEntityToDto (CommessaNonFatturabile commessa);
	
	public OrdineCommessa createOrdineCommessa (CommessaFatturabileWrapper bodyConverter);

}
