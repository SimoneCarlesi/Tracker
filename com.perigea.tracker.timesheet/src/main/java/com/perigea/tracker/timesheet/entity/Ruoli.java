package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ruoli")
public class Ruoli {

	@Id
	@Column(name="ruolo")
	private String ruoloType;
	@Column(name="descrizione_ruolo")
	private String descrizioneRuolo;
	
	@OneToMany(mappedBy = "ruolo")
	private List<UtenteRuolo> utenteRuolo = new ArrayList<>();

	public String getRuoloType() {
		return ruoloType;
	}

	public void setRuoloType(String ruoloType) {
		this.ruoloType = ruoloType;
	}

	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}

	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}

//	public List<Utente> getUtenti() {
//		return utenti;
//	}
//
//	public void setUtenti(List<Utente> utenti) {
//		this.utenti = utenti;
//	} 
	
	
}