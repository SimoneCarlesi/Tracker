package com.perigea.tracker.timesheet.dto;

import java.util.Date;

import com.perigea.tracker.timesheet.enumerator.TipoCommessaType;

public class CommessaDto {
	
	private String codiceCommessa;
	private TipoCommessaType tipoCommessaType;
	private Date createTimestamp;
	private Date lastUpdateTimestamp;
	private String createUser;
	private String lastUpdateUser;
	
	
	
	public CommessaDto() {
		super();
	}
	public String getCodiceCommessa() {
		return codiceCommessa;
	}
	public void setCodiceCommessa(String codiceCommessa) {
		this.codiceCommessa = codiceCommessa;
	}
	public TipoCommessaType getTipoCommessaType() {
		return tipoCommessaType;
	}
	public void setTipoCommessaType(TipoCommessaType tipoCommessaType) {
		this.tipoCommessaType = tipoCommessaType;
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
