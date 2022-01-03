package com.perigea.tracker.timesheet.converter;


import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.enumerator.RuoloType;

public class EnumConverter {
	
	public RuoloType fromStringToEnum(Ruoli entity) {
	 
	    String string = entity.getRuoloType();
	    RuoloType ruolo
	      = RuoloType.valueOf(string);
	    return ruolo;
	}
}
