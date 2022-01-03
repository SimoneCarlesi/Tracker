package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;

public interface TrackerClientInterface {

	public void createCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam);
	
	public void createOrdineCommessa (OrdineCommessaDto dtoParam);
	
}
