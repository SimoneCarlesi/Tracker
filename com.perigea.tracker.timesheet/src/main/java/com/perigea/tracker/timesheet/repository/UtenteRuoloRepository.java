package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.entity.RelazioneUtenteRuolo;
import com.perigea.tracker.timesheet.entity.keys.RelazioneIdUtenteRuoloKey;

@Repository
public interface UtenteRuoloRepository extends JpaRepository<RelazioneUtenteRuolo, RelazioneIdUtenteRuoloKey> {

	 @Query(value = "some query", nativeQuery = true)
	    Long findAmountOfFriends(@Param("userId") Long userId);
} 
