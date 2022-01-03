package com.perigea.tracker.timesheet.converter;

import com.perigea.tracker.timesheet.dto.CommessaFatturabileDto;
import com.perigea.tracker.timesheet.entity.NotaSpese;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;

public class BodyConverterCommessaFatturabile {
	
	private CommessaFatturabileDto commessaFatturabileDto;
	private OrdineCommessa ordineCommessa;
	private NotaSpese notaSpese;

	
	public CommessaFatturabileDto getCommessaFatturabileDto() {
		return commessaFatturabileDto;
	}
	public void setCommessaFatturabileDto(CommessaFatturabileDto commessaFatturabileDto) {
		this.commessaFatturabileDto = commessaFatturabileDto;
	}
	public OrdineCommessa getOrdineCommessa() {
		return ordineCommessa;
	}
	public void setOrdineCommessa(OrdineCommessa ordineCommessa) {
		this.ordineCommessa = ordineCommessa;
	}
	public NotaSpese getNotaSpese() {
		return notaSpese;
	}
	public void setNotaSpese(NotaSpese notaSpese) {
		this.notaSpese = notaSpese;
	}
	
	

}
