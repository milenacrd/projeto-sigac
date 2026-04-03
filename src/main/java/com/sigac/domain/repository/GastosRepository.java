package com.sigac.domain.repository;

import com.sigac.domain.model.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastosRepository extends JpaRepository<Gastos, Long> {
}
