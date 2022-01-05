package com.perigea.tracker.timesheet.service;

import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.OrdineCommessaDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.OrdineCommessa;

public interface TrackerClientInterface {

	public AnagraficaClienteDto createCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void readCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void updateCustomerPersonalData(AnagraficaClienteDto dtoParam);

	public void deleteCustomerPersonalData(AnagraficaClienteDto dtoParam);
	
	
}
