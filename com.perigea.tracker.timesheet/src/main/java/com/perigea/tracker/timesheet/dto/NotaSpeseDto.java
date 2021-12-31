package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCostoNotaSpeseType;

public class NotaSpeseDto {

	private Integer annoDiRiferimento;
	private Integer meseDiRiferimento;
	private String codicePersona;
	private String codiceCommessa;
	private Integer giornoDiRiferimento;
	private TipoCostoNotaSpeseType tipoCostoNotaSpeseType;
	private Double importo;
	private String createUser;
	private String lastUpdateUser;
	
	public NotaSpeseDto() {
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

	public TipoCostoNotaSpeseType getTipoCostoNotaSpeseType() {
		return tipoCostoNotaSpeseType;
	}

	public void setTipoCostoNotaSpeseType(TipoCostoNotaSpeseType tipoCostoNotaSpeseType) {
		this.tipoCostoNotaSpeseType = tipoCostoNotaSpeseType;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
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
