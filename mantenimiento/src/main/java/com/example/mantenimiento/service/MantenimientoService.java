package com.example.mantenimiento.service;

import com.example.mantenimiento.entity.Mantenimiento;
import com.example.mantenimiento.entity.TipoMantenimiento;
import com.example.mantenimiento.entity.Via;
import com.example.mantenimiento.exception.ResourceNotFoundException;
import com.example.mantenimiento.repository.MantenimientoRepository;
import com.example.mantenimiento.webclient.WebClient;
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

    @Autowired
    WebClient webClient;

    public Iterable<Mantenimiento> findAll() {
        log.info("mantenimiento  - MantenimientoService - findAll ");
        return mantenimientoRepository.findAll();
    }

    public Mantenimiento addMantenimiento(Mantenimiento mantenimiento){
        log.info("mantenimiento  - MantenimientoService - addMantenimiento ");
        return mantenimientoRepository.save(mantenimiento);
    }

    public Mantenimiento findMantenimientoById(Long id){
        log.info("mantenimiento  - MantenimientoService - findMantenimientoById ");
        Mantenimiento mantenimiento = mantenimientoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("via", "GET", "id" ,id+"" ,"No existe en la base de datos"));
        Via via = webClient.getVia(mantenimiento.getIdVia());
        TipoMantenimiento  tipoMantenimiento = webClient.getTipoMantenimiento(mantenimiento.getIdTipoMantenimiento());

        mantenimiento.setDescVia(via.getDescripcion());
        mantenimiento.setDesctipomantenimiento(tipoMantenimiento.getDescripcion());
        return mantenimiento;
    }

    public void deleteMantenimientoById(Mantenimiento mantenimiento) {
        log.info("mantenimiento  - MantenimientoService - deleteMantenimientoById ");
        mantenimientoRepository.delete(mantenimiento);
    }
}
