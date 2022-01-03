package com.perigea.tracker.timesheet.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;


@Entity
@Table(name="commessa")
public class Commessa extends Base {

	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;

	@Column(name="tipo_commessa")
	private String commessaType;
	

	
	@OneToOne(mappedBy="commessaSpesa")
	private NotaSpese notaSpese;
	
	@OneToMany(mappedBy = "commessaTimeSheet")
	private List<TimeSheet> timeSheet = new ArrayList<>();
	
	@OneToOne(mappedBy = "commessaNonFatturabile")
	private CommessaNonFatturabile commessaNonFatturabile;
	
	@OneToMany(mappedBy= "commessa")
	private List<RelazioneDipendenteCommessa> relazione = new ArrayList<>();
	
	@OneToOne(mappedBy = "commessaFatturabile")
	private CommessaFatturabile commessaFatturabile;

	public String getCodiceCommessa() {
		return codiceCommessa;
	}

	public void setCodiceCommessa(String codiceCommessa) {
		this.codiceCommessa = codiceCommessa;
	}

	public String getCommessaType() {
		return commessaType;
	}

	public void setCommessaType(String commessaType) {
		this.commessaType = commessaType;
	}

	public NotaSpese getNotaSpese() {
		return notaSpese;
	}

	public void setNotaSpese(NotaSpese notaSpese) {
		this.notaSpese = notaSpese;
	}

	public List<TimeSheet> getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(List<TimeSheet> timeSheet) {
		this.timeSheet = timeSheet;
	}

	public CommessaNonFatturabile getCommessaNonFatturabile() {
		return commessaNonFatturabile;
	}

	public void setCommessaNonFatturabile(CommessaNonFatturabile commessaNonFatturabile) {
		this.commessaNonFatturabile = commessaNonFatturabile;
	}

	public List<RelazioneDipendenteCommessa> getRelazione() {
		return relazione;
	}

	public void setRelazione(List<RelazioneDipendenteCommessa> relazione) {
		this.relazione = relazione;
	}

	public CommessaFatturabile getCommessaFatturabile() {
		return commessaFatturabile;
	}

	public void setCommessaFatturabile(CommessaFatturabile commessaFatturabile) {
		this.commessaFatturabile = commessaFatturabile;
	}
	
}