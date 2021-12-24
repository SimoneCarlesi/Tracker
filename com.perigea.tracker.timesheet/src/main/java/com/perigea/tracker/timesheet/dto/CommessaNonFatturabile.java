package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;

public class CommessaNonFatturabile extends Commessa {
	
	private String descrizione;
	
	public CommessaNonFatturabile(String codiceCommessa, TipoCommessaType tipoCommessaType, Date createTimestamp,
			Date lastUpdateTimestamp, String createUser, String lastUpdateUser, String descrizione) {
		super(codiceCommessa,tipoCommessaType, createTimestamp, lastUpdateTimestamp, createUser, lastUpdateUser);
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	

}
