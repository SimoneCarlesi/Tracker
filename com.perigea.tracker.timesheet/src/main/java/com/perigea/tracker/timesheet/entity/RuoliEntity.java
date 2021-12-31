package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;
import com.perigea.tracker.timesheet.enumerator.RuoloType;

@Entity
@Table(name="ruoli")
public class RuoliEntity {

	@Id
	@Column(name="ruolo")
	private String ruoloType;
	@Column(name="descrizione_ruolo")
	private String descrizioneRuolo;
	
	@MapsId
	@ManyToMany
	@JoinTable(
			name = "utente_ruolo",
			joinColumns = @JoinColumn(name = "ruolo"),
			inverseJoinColumns = @JoinColumn(name="codice_persona")
			)
	private List<UtenteEntity> utenti = new ArrayList();

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

	public List<UtenteEntity> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<UtenteEntity> utenti) {
		this.utenti = utenti;
	} 
	
	
}