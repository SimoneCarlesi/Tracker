package com.perigea.tracker.timesheet.converter;

import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.CommessaNonFatturabileDto;

public class BodyConverterCommessaNonFatturabile {
	
	private CommessaNonFatturabileDto commessaParam;
	private CommessaDto commessa;
	public CommessaNonFatturabileDto getCommessaParam() {
		return commessaParam;
	}
	public void setCommessaParam(CommessaNonFatturabileDto commessaParam) {
		this.commessaParam = commessaParam;
	}
	public CommessaDto getCommessa() {
		return commessa;
	}
	public void setCommessa(CommessaDto commessa) {
		this.commessa = commessa;
	}
	
	
	
	

}
