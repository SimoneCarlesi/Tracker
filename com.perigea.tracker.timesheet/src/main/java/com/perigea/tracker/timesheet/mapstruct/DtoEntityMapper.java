package com.perigea.tracker.timesheet.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.tracker.timesheet.dto.AnagraficaClienteDto;
import com.perigea.tracker.timesheet.dto.CommessaDto;
import com.perigea.tracker.timesheet.dto.RelazioneDipendenteCommessaDto;
import com.perigea.tracker.timesheet.dto.RuoliDto;
import com.perigea.tracker.timesheet.dto.TimeSheetDto;
import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.AnagraficaCliente;
import com.perigea.tracker.timesheet.entity.Commessa;
import com.perigea.tracker.timesheet.entity.RelazioneDipendenteCommessa;
import com.perigea.tracker.timesheet.entity.Ruoli;
import com.perigea.tracker.timesheet.entity.TimeSheet;
import com.perigea.tracker.timesheet.entity.Utente;


@Mapper
public interface DtoEntityMapper {
	
	DtoEntityMapper INSTANCE = Mappers.getMapper(DtoEntityMapper.class);

	Utente fromDtoToEntityUtente(UtenteDto dto);

	UtenteDto fromEntityToDtoUtente(Utente entity);

	AnagraficaCliente fromDtoToEntityAnagraficaCliente(AnagraficaClienteDto dto);

	AnagraficaClienteDto fromEntityToDtoAnagraficaCliente(AnagraficaCliente entity);
	
	Ruoli fromDtoToEntityRuoli(RuoliDto dto);
	
	RuoliDto fromEntityToDtoRuoli(Ruoli entity);
	
	Commessa fromDtoToEntityCommessa(CommessaDto dto);
	
	CommessaDto fromEntityToDtoCommessa(Commessa entity);
	
	TimeSheet fromDtoToEntityTimeSheet(TimeSheetDto dto);
	
	TimeSheetDto fromEntityToDtoTimeSheet(TimeSheet entity);
	
	RelazioneDipendenteCommessa fromDtoToEntityRelazioneDipendenteCommessa(RelazioneDipendenteCommessaDto dto);
}
