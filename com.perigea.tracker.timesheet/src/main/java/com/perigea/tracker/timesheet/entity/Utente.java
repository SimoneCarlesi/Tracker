package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.perigea.tracker.timesheet.enumerator.StatoUtenteType;

@Entity
@Table(name = "utente")
public class Utente {

	@Id
	@Column(name = "codice_persona", nullable = false)
	private String codicePersona;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "cognome", nullable = false)
	private String cognome;

	@Column(name = "password")
	private String password;

	@Column(name = "stato_utente")
	private String statoUtenteType;

	@Column(name = "create_timestamp")
	private Date createTimestamp;

	@Column(name = "last_update_timestamp")
	private Date lastUpdateTimestamp;

	@Column(name = "create_user")
	private String createUser;

	@Column(name = "last_update_user")
	private String lastUpdateUser;
	

	@OneToMany(mappedBy = "utenteSpesa")
	private List<NotaSpese> spese = new ArrayList<>();

	@OneToOne(mappedBy = "utenteDipendente")
	private AnagraficaDipendente dipendente;

	@OneToMany(mappedBy = "utenteTimeSheet")
	private List<TimeSheet> timeSheet = new ArrayList<>();

	@OneToMany(mappedBy = "utente")
	private List<RelazioneDipendenteCommessa> relazione = new ArrayList<>();
	
//	@ManyToMany(mappedBy = "utenti")
//	private List<Ruoli> ruoli = new ArrayList<>();

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

	public String getStatoUtenteType() {
		return statoUtenteType;
	}

	public void setStatoUtenteType(String statoUtenteType) {
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

//	public List<NotaSpeseEntity> getSpese() {
//		return spese;
//	}
//
//	public void setSpese(List<NotaSpeseEntity> spese) {
//		this.spese = spese;
//	}
//
//	public AnagraficaDipendenteEntity getDipendente() {
//		return dipendente;
//	}
//
//	public void setDipendente(AnagraficaDipendenteEntity dipendente) {
//		this.dipendente = dipendente;
//	}
//
//	public List<TimeSheetEntity> getTimeSheet() {
//		return timeSheet;
//	}
//
//	public void setTimeSheet(List<TimeSheetEntity> timeSheet) {
//		this.timeSheet = timeSheet;
//	}
//
//	public List<RelazioneDipendenteCommessaEntity> getRelazione() {
//		return relazione;
//	}
//
//	public void setRelazione(List<RelazioneDipendenteCommessaEntity> relazione) {
//		this.relazione = relazione;
//	}
//
//	public List<RuoliEntity> getRuoli() {
//		return ruoli;
//	}
//
//	public void setRuoli(List<RuoliEntity> ruoli) {
//		this.ruoli = ruoli;
//	}

}