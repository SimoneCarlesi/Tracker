package com.perigea.tracker.timesheet.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commessa_non_fatturabile")
public class CommessaNonFatturabile extends Commessa {

	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "codice_commessa", referencedColumnName = "codice_commessa", nullable = false)
	private Commessa commessaNonFatturabile;

	@Column(name = "descrizione")
	private String descrizione;

	public Commessa getCommessaNoFat() {
		return commessaNonFatturabile;
	}

	public void setCommessaNonFatturabile(Commessa commessaNonFatturabile) {
		this.commessaNonFatturabile = commessaNonFatturabile;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}