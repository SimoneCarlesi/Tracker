package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipologiaPagamentoType;

public class AnagraficaClienteDto {
	
	private String ragioneSocialeCliente;
	private String partitaIva;
	private String codiceFiscale;
	private String codiceDestinatario;
	private String sedeLegaleComune;
	private String sedeLegaleCap;
	private String sedeLegaleIndirizzo;
	private String sedeOperativaComune;
	private String sedeOperativaCap;
	private String sedeOperativaIndirizzo;
	private String acronimoCliente;
	private Integer progressivoPerCommesse;
	private TipologiaPagamentoType tipologiaPagamentoType;
	private String notePerLaFatturazione;
	private String createUser;
	private String lastUpdateUser;
	
	public AnagraficaClienteDto() {
		super();
	}
	
	public String getRagioneSocialeCliente() {
		return ragioneSocialeCliente;
	}
	public void setRagioneSocialeCliente(String ragioneSocialeCliente) {
		this.ragioneSocialeCliente = ragioneSocialeCliente;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getCodiceDestinatario() {
		return codiceDestinatario;
	}
	public void setCodiceDestinatario(String codiceDestinatario) {
		this.codiceDestinatario = codiceDestinatario;
	}
	public String getSedeLegaleComune() {
		return sedeLegaleComune;
	}
	public void setSedeLegaleComune(String sedeLegaleComune) {
		this.sedeLegaleComune = sedeLegaleComune;
	}
	public String getSedeLegaleCap() {
		return sedeLegaleCap;
	}
	public void setSedeLegaleCap(String sedeLegaleCap) {
		this.sedeLegaleCap = sedeLegaleCap;
	}
	public String getSedeLegaleIndirizzo() {
		return sedeLegaleIndirizzo;
	}
	public void setSedeLegaleIndirizzo(String sedeLegaleIndirizzo) {
		this.sedeLegaleIndirizzo = sedeLegaleIndirizzo;
	}
	public String getSedeOperativaComune() {
		return sedeOperativaComune;
	}
	public void setSedeOperativaComune(String sedeOperativaComune) {
		this.sedeOperativaComune = sedeOperativaComune;
	}
	public String getSedeOperativaCap() {
		return sedeOperativaCap;
	}
	public void setSedeOperativaCap(String sedeOperativaCap) {
		this.sedeOperativaCap = sedeOperativaCap;
	}
	public String getSedeOperativaIndirizzo() {
		return sedeOperativaIndirizzo;
	}
	public void setSedeOperativaIndirizzo(String sedeOperativaIndirizzo) {
		this.sedeOperativaIndirizzo = sedeOperativaIndirizzo;
	}
	public String getAcronimoCliente() {
		return acronimoCliente;
	}
	public void setAcronimoCliente(String acronimoCliente) {
		this.acronimoCliente = acronimoCliente;
	}
	public Integer getProgressivoPerCommesse() {
		return progressivoPerCommesse;
	}
	public void setProgressivoPerCommesse(Integer progressivoPerCommesse) {
		this.progressivoPerCommesse = progressivoPerCommesse;
	}
	public TipologiaPagamentoType getTipologiaPagamentoType() {
		return tipologiaPagamentoType;
	}
	public void setTipologiaPagamentoType(TipologiaPagamentoType tipologiaPagamentoType) {
		this.tipologiaPagamentoType = tipologiaPagamentoType;
	}
	public String getNotePerLaFatturazione() {
		return notePerLaFatturazione;
	}
	public void setNotePerLaFatturazione(String notePerLaFatturazione) {
		this.notePerLaFatturazione = notePerLaFatturazione;
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
