package com.perigea.tracker.timesheet.dto;

import java.util.Date;

public class AnagraficaDipendenteDto {
	
	private String codicePersona;
	private String luogoDiNascita;
	private Date dataDiNascita;
	private String mailAziendale;
	private String mailPrivata;
	private String cellulare;
	private String provinciaDiDomicilio;
	private String comuneDiDomicilio;
	private String indirizzoDiDomicilio;
	private String provinciaDiResidenza;
	private String comuneDiResidenza;
	private String indirizzoDiResidenza;
	private String nomeContattoEmergenza;
	private String cellulareContattoEmergenza;
	private Date dataAssunzione;
	private String iban;
	private Date dataCessazione;
	private String codiceFiscale;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	
	public AnagraficaDipendenteDto(String codicePersona, String luogoDiNascita, Date dataDiNascita, String mailAziendale,
			String mailPrivata, String cellulare, String provinciaDiDomicilio, String comuneDiDomicilio,
			String indirizzoDiDomicilio, String provinciaDiResidenza, String comuneDiResidenza,
			String indirizzoDiResidenza, String nomeContattoEmergenza, String cellulareContattoEmergenza,
			Date dataAssunzione, String iban, Date dataCessazione, String codiceFiscale, Date createTimestamp,
			Date lastUpdateTimestamp, String createUser, String lastUpdateUser) {
		super();
		this.codicePersona = codicePersona;
		this.luogoDiNascita = luogoDiNascita;
		this.dataDiNascita = dataDiNascita;
		this.mailAziendale = mailAziendale;
		this.mailPrivata = mailPrivata;
		this.cellulare = cellulare;
		this.provinciaDiDomicilio = provinciaDiDomicilio;
		this.comuneDiDomicilio = comuneDiDomicilio;
		this.indirizzoDiDomicilio = indirizzoDiDomicilio;
		this.provinciaDiResidenza = provinciaDiResidenza;
		this.comuneDiResidenza = comuneDiResidenza;
		this.indirizzoDiResidenza = indirizzoDiResidenza;
		this.nomeContattoEmergenza = nomeContattoEmergenza;
		this.cellulareContattoEmergenza = cellulareContattoEmergenza;
		this.dataAssunzione = dataAssunzione;
		this.iban = iban;
		this.dataCessazione = dataCessazione;
		this.codiceFiscale = codiceFiscale;
		this.createTimestamp = createTimestamp;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.createUser = createUser;
		this.lastUpdateUser = lastUpdateUser;
	}
	public String getCodicePersona() {
		return codicePersona;
	}
	public void setCodicePersona(String codicePersona) {
		this.codicePersona = codicePersona;
	}
	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getMailAziendale() {
		return mailAziendale;
	}
	public void setMailAziendale(String mailAziendale) {
		this.mailAziendale = mailAziendale;
	}
	public String getMailPrivata() {
		return mailPrivata;
	}
	public void setMailPrivata(String mailPrivata) {
		this.mailPrivata = mailPrivata;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}
	public String getProvinciaDiDomicilio() {
		return provinciaDiDomicilio;
	}
	public void setProvinciaDiDomicilio(String provinciaDiDomicilio) {
		this.provinciaDiDomicilio = provinciaDiDomicilio;
	}
	public String getComuneDiDomicilio() {
		return comuneDiDomicilio;
	}
	public void setComuneDiDomicilio(String comuneDiDomicilio) {
		this.comuneDiDomicilio = comuneDiDomicilio;
	}
	public String getIndirizzoDiDomicilio() {
		return indirizzoDiDomicilio;
	}
	public void setIndirizzoDiDomicilio(String indirizzoDiDomicilio) {
		this.indirizzoDiDomicilio = indirizzoDiDomicilio;
	}
	public String getProvinciaDiResidenza() {
		return provinciaDiResidenza;
	}
	public void setProvinciaDiResidenza(String provinciaDiResidenza) {
		this.provinciaDiResidenza = provinciaDiResidenza;
	}
	public String getComuneDiResidenza() {
		return comuneDiResidenza;
	}
	public void setComuneDiResidenza(String comuneDiResidenza) {
		this.comuneDiResidenza = comuneDiResidenza;
	}
	public String getIndirizzoDiResidenza() {
		return indirizzoDiResidenza;
	}
	public void setIndirizzoDiResidenza(String indirizzoDiResidenza) {
		this.indirizzoDiResidenza = indirizzoDiResidenza;
	}
	public String getNomeContattoEmergenza() {
		return nomeContattoEmergenza;
	}
	public void setNomeContattoEmergenza(String nomeContattoEmergenza) {
		this.nomeContattoEmergenza = nomeContattoEmergenza;
	}
	public String getCellulareContattoEmergenza() {
		return cellulareContattoEmergenza;
	}
	public void setCellulareContattoEmergenza(String cellulareContattoEmergenza) {
		this.cellulareContattoEmergenza = cellulareContattoEmergenza;
	}
	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Date getDataCessazione() {
		return dataCessazione;
	}
	public void setDataCessazione(Date dataCessazione) {
		this.dataCessazione = dataCessazione;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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
