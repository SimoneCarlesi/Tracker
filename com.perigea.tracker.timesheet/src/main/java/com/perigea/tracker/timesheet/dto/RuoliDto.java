package com.perigea.tracker.timesheet.dto;

import com.perigea.tracker.timesheet.enumerator.RuoloType;

public class RuoliDto {
	private RuoloType ruoloType;
	private String descrizioneRuolo;
	
	public RuoliDto() {
	}
	public RuoloType getRuoloType() {
		return ruoloType;
	}
	public void setRuoloType(RuoloType ruoloType) {
		this.ruoloType = ruoloType;
	}
	public String getDescrizioneRuolo() {
		return descrizioneRuolo;
	}
	public void setDescrizioneRuolo(String descrizioneRuolo) {
		this.descrizioneRuolo = descrizioneRuolo;
	}
}
