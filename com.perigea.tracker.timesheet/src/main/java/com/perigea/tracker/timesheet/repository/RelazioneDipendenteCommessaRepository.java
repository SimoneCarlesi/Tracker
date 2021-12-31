package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.compositekeys.RelationshipIdRelazioneDipendenteCommessaEntity;
import com.perigea.tracker.timesheet.entity.RelazioneDipendenteCommessaEntity;

@Repository
public interface RelazioneDipendenteCommessaRepository extends JpaRepository<RelazioneDipendenteCommessaEntity, RelationshipIdRelazioneDipendenteCommessaEntity> {

	 @Query(value = "some query", nativeQuery = true)
	    Long findAmountOfFriends(@Param("userId") Long userId);
} 
