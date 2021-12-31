package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.compositekeys.RelazioneIdNotaSpeseEntity;
import com.perigea.tracker.timesheet.entity.NotaSpese;

@Repository
public interface NotaSpeseRepository extends JpaRepository<NotaSpese, RelazioneIdNotaSpeseEntity> {

	 @Query(value = "some query", nativeQuery = true)
	    Long findAmountOfFriends(@Param("userId") Long userId);
} 
