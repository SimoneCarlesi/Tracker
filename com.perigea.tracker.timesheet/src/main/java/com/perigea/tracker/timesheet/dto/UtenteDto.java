package com.perigea.tracker.timesheet.dto;


import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.StatoUtenteType;

public class UtenteDto {
	
	private String codicePersona;
	private String nome;
	private String cognome;
	private String password;
	private StatoUtenteType statoUtenteType;
	private String createUser;
	private String lastUpdateUser;
	
	public UtenteDto() {
		
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
