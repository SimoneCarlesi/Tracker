package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.entity.CommessaNonFatturabileEntity;

@Repository
public interface CommessaNonFatturabileRepository extends JpaRepository<CommessaNonFatturabileEntity,Long> {
	
	public CommessaNonFatturabileEntity findByCodiceCommessa(String codiceCommessa);

} 