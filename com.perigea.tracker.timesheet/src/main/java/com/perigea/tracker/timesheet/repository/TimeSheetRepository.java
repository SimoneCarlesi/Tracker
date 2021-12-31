package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.compositekeys.RelazioneIdTimeSheetEntity;
import com.perigea.tracker.timesheet.entity.TimeSheet;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, RelazioneIdTimeSheetEntity> {
	
	public TimeSheet findByCodicePersona(String codicePersona);

	 @Query(value = "some query", nativeQuery = true)
	    Long findAmountOfFriends(@Param("userId") Long userId);
} 
