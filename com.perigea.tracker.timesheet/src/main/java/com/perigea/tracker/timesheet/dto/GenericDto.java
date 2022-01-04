package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class GenericDto {
	
	private Date dataRichiesta;
	private String utenteModifica;
	private String risultato;
	
	public Date getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public String getUtente() {
		return utenteModifica;
	}
	public void setUtente(String utenteModifica) {
		this.utenteModifica = utenteModifica;
	}
	public String getRisultato() {
		return risultato;
	}
	public void setRisultato(String risultato) {
		this.risultato = risultato;
	}
	
	

}
