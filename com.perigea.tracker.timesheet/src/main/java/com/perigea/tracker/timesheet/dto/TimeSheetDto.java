package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.StatoType;

public class TimeSheetDto {
	
	private Integer annoDiRiferimento;
	private Integer meseDiRiferimento;
	private String codicePersona;
	private String codiceCommessa;
	private Integer giornoDiRiferimento;
	private Integer ore;
	private Boolean trasferta;
	private StatoType statoType;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	
	
	public TimeSheetDto() {
		super();
	}



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
