package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class OrdineCommessa {
	
	private String codiceCommessa;
	private String numeroOrdineCliente;
	private String ragioneSocialeCliente;
	private Date dataOrdine;
	private double importoOrdine;
	private Date dataInizio;
	private Date dataFine;
	private double importoResiduo;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	public OrdineCommessa(String codiceCommessa, String numeroOrdineCliente, String ragioneSocialeCliente,
			Date dataOrdine, double importoOrdine, Date dataInizio, Date dataFine, double importoResiduo,
			Date createTimestamp, Date lastUpdateTimestamp, String createUser, String lastUpdateUser) {
		super();
		this.codiceCommessa = codiceCommessa;
		this.numeroOrdineCliente = numeroOrdineCliente;
		this.ragioneSocialeCliente = ragioneSocialeCliente;
		this.dataOrdine = dataOrdine;
		this.importoOrdine = importoOrdine;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.importoResiduo = importoResiduo;
		this.createTimestamp = createTimestamp;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.createUser = createUser;
		this.lastUpdateUser = lastUpdateUser;
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
	public double getImportoOrdine() {
		return importoOrdine;
	}
	public void setImportoOrdine(double importoOrdine) {
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
	public double getImportoResiduo() {
		return importoResiduo;
	}
	public void setImportoResiduo(double importoResiduo) {
		this.importoResiduo = importoResiduo;
	}
	public Date getCreateTimestamp() {
		return createTimestamp;
	}
	public void setCreateTimestamp(Date createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}
	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
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
