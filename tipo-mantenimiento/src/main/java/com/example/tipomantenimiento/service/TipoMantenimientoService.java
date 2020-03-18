package com.example.tipomantenimiento.service;

import com.example.tipomantenimiento.entity.TipoMantenimiento;
import com.example.tipomantenimiento.repository.TipoMantenimientoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipoMantenimientoService {

    private static final Logger log = LoggerFactory.getLogger(TipoMantenimientoService.class);

    @Autowired
    TipoMantenimientoRepository tipoMantenimientoRepository;

    public Iterable<TipoMantenimiento> findAll() {
        log.info("tipo-mantenimiento  - TipoMantenimientoService - findAll ");
        return tipoMantenimientoRepository.findAll();
    }

    public TipoMantenimiento addTipoMantenimiento(TipoMantenimiento tipoMantenimiento){
        log.info("tipo-mantenimiento  - TipoMantenimientoService - findAll ");
        return tipoMantenimientoRepository.save(tipoMantenimiento);
    }

    public Optional<TipoMantenimiento> findTipoMantenimientoById(Long id){
        log.info("tipo-mantenimiento  - TipoMantenimientoService - findTipoViaById ");
        return tipoMantenimientoRepository.findById(id);
    }

    public void deleteTipoMantenimientoById(TipoMantenimiento tipoMantenimiento) {
        log.info("tipo-via  - TipoViaService - findTipoViaById ");
        tipoMantenimientoRepository.delete(tipoMantenimiento);
    }
}
