package com.perigea.tracker.timesheet.dto;

import com.perigea.tracker.timesheet.enumerator.RuoloType;

public class UtenteRuoloDto {
	private String codicePersona;
	private RuoloType ruoloType; 
	
	public UtenteRuoloDto() {
		super();

	}
	public String getCodicePersona() {
		return codicePersona;
	}
	public void setCodicePersona(String codicePersona) {
		this.codicePersona = codicePersona;
	}
	public RuoloType getRuoloType() {
		return ruoloType;
	}
	public void setRuoloType(RuoloType ruoloType) {
		this.ruoloType = ruoloType;
	}
	
	

}
