package com.perigea.tracker.timesheet.compositekeys;

import java.io.Serializable;

public class RelazioneIdOrdineCommessaEntity implements Serializable{

	private String codiceCommessa;
	private String numeroOrdineCliente;
	public String getCodiceCommessa() {
		return codiceCommessa;
	}
	public void setCodiceCommessa(String codiceCommessa) {
		this.codiceCommessa = codiceCommessa;
	}
	public String getNumeroOrdineCliente() {
		return numeroOrdineCliente;
	}
	public void setNumeroOrdineCliente(String numeroOrdineCliente) {
		this.numeroOrdineCliente = numeroOrdineCliente;
	}
	
	
}
