package com.perigea.tracker.timesheet.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.perigea.tracker.timesheet.compositekeys.RelazioneIdNotaSpeseKey;

@Entity
@IdClass(RelazioneIdNotaSpeseKey.class)
@Table(name = "nota_spese")
public class NotaSpese {

	@Id
	@Column(name = "anno_di_riferimento")
	private Integer annoDiRiferimento;

	@Id
	@Column(name = "mese_di_riferimento")
	private Integer meseDiRiferimento;

	@Id
	@Column(name="codice_persona")
	private String codicePersona;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name = "codice_persona", referencedColumnName = "codice_persona")
	private Utente utenteSpesa;

	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "codice_commessa", nullable = false, referencedColumnName = "codice_commessa")
	private Commessa commessaSpesa;

	@Id
	@Column(name = "giorno_di_riferimento")
	private Integer giornoDiRiferimento;

	@Id
	@Column(name = "tipo_costo")
	private String tipoCostoNotaSpeseType;

	@Column(name = "importo")
	private Double importo;

	@Column(name = "create_timestamp")
	private Date createTimestamp;

	@Column(name = "last_update_timestamp")
	private Date lastUpdateTimestamp;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "last_update_user")
	private String lastUpdateUser;

	public Integer getAnnoDiRiferimento() {
		return annoDiRiferimento;
	}

	public void setAnnoDiRiferimento(Integer annoDiRiferimento) {
		this.annoDiRiferimento = annoDiRiferimento;
	}

	public Integer getMeseDiRiferimento() {
		return meseDiRiferimento;
	}

	public void setMeseDiRiferimento(Integer meseDiRiferimento) {
		this.meseDiRiferimento = meseDiRiferimento;
	}

	public Utente getUtenteSpesa() {
		return utenteSpesa;
	}

	public void setUtenteSpesa(Utente utenteSpesa) {
		this.utenteSpesa = utenteSpesa;
	}

	public Commessa getCommessaSpesa() {
		return commessaSpesa;
	}

	public void setCommessaSpesa(Commessa commessaSpesa) {
		this.commessaSpesa = commessaSpesa;
	}

	public Integer getGiornoDiRiferimento() {
		return giornoDiRiferimento;
	}

	public void setGiornoDiRiferimento(Integer giornoDiRiferimento) {
		this.giornoDiRiferimento = giornoDiRiferimento;
	}

	public String getTipoCostoNotaSpeseType() {
		return tipoCostoNotaSpeseType;
	}

	public void setTipoCostoNotaSpeseType(String tipoCostoNotaSpeseType) {
		this.tipoCostoNotaSpeseType = tipoCostoNotaSpeseType;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
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