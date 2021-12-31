package com.perigea.tracker.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.perigea.tracker.timesheet.entity.AnagraficaClienteEntity;

@Repository
public interface AnagraficaClienteRepository extends JpaRepository<AnagraficaClienteEntity,Long> {

	public AnagraficaClienteEntity findByRagioneSocialeCliente(String ragioneSocialeCliente);
}
