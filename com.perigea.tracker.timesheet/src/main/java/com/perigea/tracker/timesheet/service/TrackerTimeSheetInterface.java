package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.TimeSheetWrapper;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.Utente;

public interface TrackerTimeSheetInterface {

	public TimeSheetDto createTimeSheet(Utente utente,Commessa commessa,TimeSheetDto timeSheetParam);

	public TimeSheetDto editTimeSheet(TimeSheetDto timeSheetParam, Commessa commessa, Utente utente);

}
