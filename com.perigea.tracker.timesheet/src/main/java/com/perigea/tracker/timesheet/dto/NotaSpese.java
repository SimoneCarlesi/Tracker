package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCostoNotaSpeseType;

public class NotaSpese {

	private int annoDiRiferimento;
	private int meseDiRiferimento;
	private String codicePersona;
	private String codiceCommessa;
	private int giornoDiRiferimento;
	private TipoCostoNotaSpeseType tipoCostoNotaSpeseType;
	private double importo;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	public NotaSpese(int annoDiRiferimento, int meseDiRiferimento, String codicePersona, String codiceCommessa,
			int giornoDiRiferimento, TipoCostoNotaSpeseType tipoCostoNotaSpeseType, double importo,
			Date createTimestamp, Date lastUpdateTimestamp, String createUser, String lastUpdateUser) {
		super();
		this.annoDiRiferimento = annoDiRiferimento;
		this.meseDiRiferimento = meseDiRiferimento;
		this.codicePersona = codicePersona;
		this.codiceCommessa = codiceCommessa;
		this.giornoDiRiferimento = giornoDiRiferimento;
		this.tipoCostoNotaSpeseType = tipoCostoNotaSpeseType;
		this.importo = importo;
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

	public TipoCostoNotaSpeseType getTipoCostoNotaSpeseType() {
		return tipoCostoNotaSpeseType;
	}

	public void setTipoCostoNotaSpeseType(TipoCostoNotaSpeseType tipoCostoNotaSpeseType) {
		this.tipoCostoNotaSpeseType = tipoCostoNotaSpeseType;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
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
