package com.perigea.tracker.timesheet.dto;


import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.StatoUtenteType;

public class UtenteDto {
	
	private String codicePersona;
	private String nome;
	private String cognome;
	private String password;
	private StatoUtenteType statoUtenteType;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	
	
	public UtenteDto(String codicePersona, String nome, String cognome, String password,
			StatoUtenteType statoUtenteType, Date createTimestamp, Date lastUpdateTimestamp, String createUser,
			String lastUpdateUser) {
		super();
		this.codicePersona = codicePersona;
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.statoUtenteType = statoUtenteType;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StatoUtenteType getStatoUtenteType() {
		return statoUtenteType;
	}
	public void setStatoUtenteType(StatoUtenteType statoUtenteType) {
		this.statoUtenteType = statoUtenteType;
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
