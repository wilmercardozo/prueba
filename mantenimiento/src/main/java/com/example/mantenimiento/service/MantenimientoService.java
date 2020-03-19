package com.example.mantenimiento.service;

import com.example.mantenimiento.entity.Mantenimiento;
import com.example.mantenimiento.repository.MantenimientoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MantenimientoService {

    private static final Logger log = LoggerFactory.getLogger(MantenimientoService.class);

    @Autowired
    MantenimientoRepository mantenimientoRepository;

    public Iterable<Mantenimiento> findAll() {
        log.info("mantenimiento  - MantenimientoService - findAll ");
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento addMantenimiento(Mantenimiento mantenimiento){
        log.info("mantenimiento  - MantenimientoService - addMantenimiento ");
        return mantenimientoRepository.save(mantenimiento);
    }

    public Optional<Mantenimiento> findMantenimientoById(Long id){
        log.info("mantenimiento  - MantenimientoService - findMantenimientoById ");
        return mantenimientoRepository.findById(id);
    }

    public void deleteMantenimientoById(Mantenimiento mantenimiento) {
        log.info("mantenimiento  - MantenimientoService - deleteMantenimientoById ");
        mantenimientoRepository.delete(mantenimiento);
    }
}
