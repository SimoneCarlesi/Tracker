package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.perigea.tracker.timesheet.enumerator.StatoUtenteType;

@Entity
@Table(name = "utente")
public class Utente extends Base {

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
	@Enumerated(EnumType.STRING)
	private StatoUtenteType statoUtenteType;
	

	@OneToMany(mappedBy = "utenteSpesa")
	private List<NotaSpese> noteSpese = new ArrayList<>();

	@OneToOne(mappedBy = "utenteDipendente")
	private AnagraficaDipendente dipendente;

	@OneToMany(mappedBy = "utenteTimeSheet")
	private List<TimeSheet> timeSheet = new ArrayList<>();

	@OneToMany(mappedBy = "utente")
	private List<RelazioneDipendenteCommessa> relazioneCommessa = new ArrayList<>();
	
	@OneToMany(mappedBy = "utente")
	private List<UtenteRuolo> utenteRuolo = new ArrayList<>();

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

	public List<NotaSpese> getNoteSpese() {
		return noteSpese;
	}

	public void setNoteSpese(List<NotaSpese> noteSpese) {
		this.noteSpese = noteSpese;
	}

	public AnagraficaDipendente getDipendente() {
		return dipendente;
	}

	public void setDipendente(AnagraficaDipendente dipendente) {
		this.dipendente = dipendente;
	}

	public List<TimeSheet> getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(List<TimeSheet> timeSheet) {
		this.timeSheet = timeSheet;
	}

	public List<RelazioneDipendenteCommessa> getRelazioneCommessa() {
		return relazioneCommessa;
	}

	public void setRelazioneCommessa(List<RelazioneDipendenteCommessa> relazioneCommessa) {
		this.relazioneCommessa = relazioneCommessa;
	}

	public List<UtenteRuolo> getUtenteRuolo() {
		return utenteRuolo;
	}

	public void setUtenteRuolo(List<UtenteRuolo> utenteRuolo) {
		this.utenteRuolo = utenteRuolo;
	}

	

}