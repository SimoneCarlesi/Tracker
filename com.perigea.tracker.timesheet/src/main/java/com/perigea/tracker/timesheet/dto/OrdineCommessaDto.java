package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class OrdineCommessaDto {
	
	private String codiceCommessa;
	private String numeroOrdineCliente;
	private String ragioneSocialeCliente;
	private Date dataOrdine;
	private Double importoOrdine;
	private Date dataInizio;
	private Date dataFine;
	private Double importoResiduo;
	private String createUser;
	private String lastUpdateUser;
	
	public OrdineCommessaDto() {
		super();
	}

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

	public String getRagioneSocialeCliente() {
		return ragioneSocialeCliente;
	}

	public void setRagioneSocialeCliente(String ragioneSocialeCliente) {
		this.ragioneSocialeCliente = ragioneSocialeCliente;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public Double getImportoOrdine() {
		return importoOrdine;
	}

	public void setImportoOrdine(Double importoOrdine) {
		this.importoOrdine = importoOrdine;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Double getImportoResiduo() {
		return importoResiduo;
	}

	public void setImportoResiduo(Double importoResiduo) {
		this.importoResiduo = importoResiduo;
	}


	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
	
	

}
