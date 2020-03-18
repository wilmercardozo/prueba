package com.example.tipomantenimiento.repository;

import com.example.tipomantenimiento.entity.TipoMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento,Long> {
}