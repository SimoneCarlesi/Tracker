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
public class CommessaEntity {


	@Id
	@Column(name="codice_commessa")
	private String codiceCommessa;

	@Column(name="tipo_commessa")
	private String commessaType;

	@Column(name="create_timestamp")
	private Date createTimestamp;

	@Column(name="last_update_timestamp")
	private Date lastUpdateTimestamp;

	@Column(name="create_user")
	private String createUser;

	@Column(name="last_update_user")
	private String lastUpdateUser;
	

	
	@OneToOne(mappedBy="commessaSpesa")
	private NotaSpeseEntity notaSpese;
	
	@OneToMany(mappedBy = "commessaTime", cascade = CascadeType.ALL)
	private List<TimeSheetEntity> timeSheet = new ArrayList<>();
	
	@OneToOne(mappedBy = "commessaNoFat")
	private CommessaNonFatturabileEntity commNoFat;
	
	@OneToMany(mappedBy= "commessa", cascade = CascadeType.ALL)
	private List<RelazioneDipendenteCommessaEntity> relazione = new ArrayList<>();
	
	@OneToOne(mappedBy = "commessaFat")
	private CommessaFatturabileEntity commFat;

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

	public NotaSpeseEntity getNotaSpese() {
		return notaSpese;
	}

	public void setNotaSpese(NotaSpeseEntity notaSpese) {
		this.notaSpese = notaSpese;
	}

	public List<TimeSheetEntity> getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(List<TimeSheetEntity> timeSheet) {
		this.timeSheet = timeSheet;
	}

	public CommessaNonFatturabileEntity getCommNoFat() {
		return commNoFat;
	}

	public void setCommNoFat(CommessaNonFatturabileEntity commNoFat) {
		this.commNoFat = commNoFat;
	}

	public List<RelazioneDipendenteCommessaEntity> getRelazione() {
		return relazione;
	}

	public void setRelazione(List<RelazioneDipendenteCommessaEntity> relazione) {
		this.relazione = relazione;
	}

	public CommessaFatturabileEntity getCommFat() {
		return commFat;
	}

	public void setCommFat(CommessaFatturabileEntity commFat) {
		this.commFat = commFat;
	}
	
}