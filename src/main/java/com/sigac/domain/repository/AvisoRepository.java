package com.sigac.domain.repository;

import com.sigac.domain.model.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisoRepository extends JpaRepository<Aviso, Long> {
}
