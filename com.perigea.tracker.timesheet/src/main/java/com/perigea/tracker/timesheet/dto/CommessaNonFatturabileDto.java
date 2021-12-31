package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;

public class CommessaNonFatturabileDto extends CommessaDto {
	
	private String descrizione;
	
	public CommessaNonFatturabileDto() {
		super();
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
