package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.converter.BodyConverterTimeSheet;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.Utente;

public interface TrackerTimeSheetInterface {

	public void createTimeSheet( BodyConverterTimeSheet bodyConverter);

	public void editTimeSheet(TimeSheetDto timeSheetParam, Commessa commessa, Utente utente);

}
