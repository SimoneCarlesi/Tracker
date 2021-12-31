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
import javax.persistence.Table;

import com.perigea.tracker.timesheet.compositekeys.RelationshipIdTimeSheetEntity;

@Entity
@IdClass(RelationshipIdTimeSheetEntity.class)
@Table(name = "time_sheet")
public class TimeSheetEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	@JoinColumn(name = "codice_persona", referencedColumnName = "codice_persona", nullable = false)
	private UtenteEntity utenteTime;

	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name = "codice_commessa", referencedColumnName = "codice_commessa", nullable = false)
	private CommessaEntity commessaTime;

	@Id
	@Column(name = "giorno_di_riferimento")
	private Integer giornoDiRiferimento;

	@Column(name = "ore")
	private Integer ore;

	@Column(name = "trasferta")
	private Boolean trasferta;

	@Column(name = "stato_time_Sheet")
	private String statoType;

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

	public UtenteEntity getUtenteTime() {
		return utenteTime;
	}

	public void setUtenteTime(UtenteEntity utenteTime) {
		this.utenteTime = utenteTime;
	}

	public CommessaEntity getCommessaTime() {
		return commessaTime;
	}

	public void setCommessaTime(CommessaEntity commessaTime) {
		this.commessaTime = commessaTime;
	}

	public Integer getGiornoDiRiferimento() {
		return giornoDiRiferimento;
	}

	public void setGiornoDiRiferimento(Integer giornoDiRiferimento) {
		this.giornoDiRiferimento = giornoDiRiferimento;
	}

	public Integer getOre() {
		return ore;
	}

	public void setOre(Integer ore) {
		this.ore = ore;
	}

	public Boolean getTrasferta() {
		return trasferta;
	}

	public void setTrasferta(Boolean trasferta) {
		this.trasferta = trasferta;
	}

	public String getStatoType() {
		return statoType;
	}

	public void setStatoType(String statoType) {
		this.statoType = statoType;
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