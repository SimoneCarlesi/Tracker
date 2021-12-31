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
public class CommessaNonFatturabileEntity extends CommessaEntity {

	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;
	
	@MapsId
	@OneToOne
	@JoinColumn(name = "codice_commessa", referencedColumnName = "codice_commessa", nullable = false)
	private CommessaEntity commessaNoFat;

	@Column(name = "descrizione")
	private String descrizione;

	public CommessaEntity getCommessaNoFat() {
		return commessaNoFat;
	}

	public void setCommessaNoFat(CommessaEntity commessaNoFat) {
		this.commessaNoFat = commessaNoFat;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}