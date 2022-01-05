package com.perigea.tracker.timesheet.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.perigea.tracker.timesheet.dto.UtenteDto;
import com.perigea.tracker.timesheet.entity.Utente;


@Mapper
public interface DtoEntityMapper {
	
	DtoEntityMapper INSTANCE = Mappers.getMapper( DtoEntityMapper.class );
	
	Utente fromDtoToEntityUtente(UtenteDto dto);
	
	UtenteDto fromEntityToDtoUtente(Utente entity);
}
