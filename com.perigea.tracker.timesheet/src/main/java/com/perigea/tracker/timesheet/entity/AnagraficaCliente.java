package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.perigea.tracker.timesheet.enumerator.TipologiaPagamentoType;

@Entity
@Table(name = "anagrafica_cliente")
public class AnagraficaCliente {

	@Id
	@Column(name = "ragione_sociale_cliente")
	private String ragioneSocialeCliente;

	@Column(name = "partita_iva", nullable = false)
	private String partitaIva;

	@Column(name = "codice_fiscale", nullable = false)
	private String codiceFiscale;

	@Column(name = "codice_destinatario")
	private String codiceDestinatario;

	@Column(name = "sede_legale_comune")
	private String sedeLegaleComune;

	@Column(name = "sede_legale_cap")
	private String sedeLegaleCap;

	@Column(name = "sede_legale_indirizzo")
	private String sedeLegaleIndirizzo;

	@Column(name = "sede_operativa_comune")
	private String sedeOperativaComune;

	@Column(name = "sede_operativa_cap")
	private String sedeOperativaCap;

	@Column(name = "sede_operativa_indirizzo")
	private String sedeOperativaIndirizzo;

	@Column(name = "acronimo_cliente")
	private String acronimoCliente;

	@Column(name = "progressivo_per_commesse")
	private Integer progressivoPerCommesse;

	@Column(name = "tipologia_pagamento")
	private String tipologiaPagamentoType;

	@Column(name = "nota_per_la_fatturazione")
	private String notePerLaFatturazione;

	@Column(name = "create_timestamp")
	private Date createTimestamp;

	@Column(name = "last_update_timestamp")
	private Date lastUpdateTimestamp;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "last_update_user")
	private String lastUpdateUser;

	@OneToMany(mappedBy = "ragioneSociale")
	private List<CommessaFatturabile> commessaFat = new ArrayList<>();

	@OneToMany(mappedBy = "ragioneSocialeCliente")
	private List<OrdineCommessa> ordineComm = new ArrayList<>();

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

	public String getTipologiaPagamentoType() {
		return tipologiaPagamentoType;
	}

	public void setTipologiaPagamentoType(String tipologiaPagamentoType) {
		this.tipologiaPagamentoType = tipologiaPagamentoType;
	}

	public String getNotePerLaFatturazione() {
		return notePerLaFatturazione;
	}

	public void setNotePerLaFatturazione(String notePerLaFatturazione) {
		this.notePerLaFatturazione = notePerLaFatturazione;
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

	public List<CommessaFatturabile> getCommessaFat() {
		return commessaFat;
	}

	public void setCommessaFat(List<CommessaFatturabile> commessaFat) {
		this.commessaFat = commessaFat;
	}

	public List<OrdineCommessa> getOrdineComm() {
		return ordineComm;
	}

	public void setOrdineComm(List<OrdineCommessa> ordineComm) {
		this.ordineComm = ordineComm;
	}
	 
}
