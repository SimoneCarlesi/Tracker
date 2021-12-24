package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.StatoType;

public class TimeSheet {
	private int annoDiRiferimento;
	private int meseDiRiferimento;
	private String codicePersona;
	private String codiceCommessa;
	private int giornoDiRiferimento;
	private int ore;
	private boolean trasferta;
	private StatoType statoType;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	
	
	public TimeSheet(int annoDiRiferimento, int meseDiRiferimento, String codicePersona, String codiceCommessa,
			int giornoDiRiferimento, int ore, boolean trasferta, StatoType statoType, Date createTimestamp,
			Date lastUpdateTimestamp, String createUser, String lastUpdateUser) {
		super();
		this.annoDiRiferimento = annoDiRiferimento;
		this.meseDiRiferimento = meseDiRiferimento;
		this.codicePersona = codicePersona;
		this.codiceCommessa = codiceCommessa;
		this.giornoDiRiferimento = giornoDiRiferimento;
		this.ore = ore;
		this.trasferta = trasferta;
		this.statoType = statoType;
		this.createTimestamp = createTimestamp;
		this.lastUpdateTimestamp = lastUpdateTimestamp;
		this.createUser = createUser;
		this.lastUpdateUser = lastUpdateUser;
	}
	
	public int getAnnoDiRiferimento() {
		return annoDiRiferimento;
	}
	public void setAnnoDiRiferimento(int annoDiRiferimento) {
		this.annoDiRiferimento = annoDiRiferimento;
	}
	public int getMeseDiRiferimento() {
		return meseDiRiferimento;
	}
	public void setMeseDiRiferimento(int meseDiRiferimento) {
		this.meseDiRiferimento = meseDiRiferimento;
	}
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
	public int getGiornoDiRiferimento() {
		return giornoDiRiferimento;
	}
	public void setGiornoDiRiferimento(int giornoDiRiferimento) {
		this.giornoDiRiferimento = giornoDiRiferimento;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore = ore;
	}
	public boolean isTrasferta() {
		return trasferta;
	}
	public void setTrasferta(boolean trasferta) {
		this.trasferta = trasferta;
	}
	public StatoType getStatoType() {
		return statoType;
	}
	public void setStatoType(StatoType statoType) {
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
