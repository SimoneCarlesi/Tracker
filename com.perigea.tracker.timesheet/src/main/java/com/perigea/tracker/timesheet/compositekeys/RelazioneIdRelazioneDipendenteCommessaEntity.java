package com.perigea.tracker.timesheet.compositekeys;

import java.io.Serializable;

public class RelazioneIdRelazioneDipendenteCommessaEntity implements Serializable {

	private String codicePersona;
	private String codiceCommessa;
	public String getCodicePersona() {
		return codicePersona;
	}
	public void setCodicePersona(String codicePersona) {
		this.codicePersona = codicePersona;
	}
	public String getCodiceCommessa() {
		return codiceCommessa;
	}
	public void setCodiceCommessa(String codiceCommessa) {
		this.codiceCommessa = codiceCommessa;
	}
	
	
	
}
