package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.compositekeys.RelationshipIdTimeSheetEntity;
import com.perigea.tracker.timesheet.entity.TimeSheetEntity;

@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheetEntity, RelationshipIdTimeSheetEntity> {
	
	public TimeSheetEntity findByCodicePersona(String codicePersona);

	 @Query(value = "some query", nativeQuery = true)
	    Long findAmountOfFriends(@Param("userId") Long userId);
} 
