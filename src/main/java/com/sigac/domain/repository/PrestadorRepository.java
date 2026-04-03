package com.sigac.domain.repository;

import com.sigac.domain.model.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {
}
