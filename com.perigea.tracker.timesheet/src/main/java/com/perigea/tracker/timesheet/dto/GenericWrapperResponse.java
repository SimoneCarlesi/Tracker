package com.perigea.tracker.timesheet.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericWrapperResponse<T> {
	
	private Date dataRichiesta;
	private String utenteModifica;
	private T risultato;

}
