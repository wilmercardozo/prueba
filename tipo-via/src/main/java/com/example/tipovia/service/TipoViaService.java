package com.example.tipovia.service;

import com.example.tipovia.entity.TipoVia;
import com.example.tipovia.repository.TipoViaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoViaService {

    private static final Logger log = LoggerFactory.getLogger(TipoViaService.class);

    @Autowired
    TipoViaRepository tipoViaRepository;

    public Iterable<TipoVia> findAll() {
        log.info("tipo-via  - TipoViaService - findAll ");
        return tipoViaRepository.findAll();
    }

    public TipoVia addTipoVia(TipoVia tipoVia){
        log.info("tipo-via  - TipoViaService - findAll ");
        return tipoViaRepository.save(tipoVia);
    }

    public Optional<TipoVia> findTipoViaById(Long id){
        log.info("tipo-via  - TipoViaService - findTipoViaById ");
        return tipoViaRepository.findById(id);
    }


    public void deleteTipoViaById(TipoVia tipoVia) {
        log.info("tipo-via  - TipoViaService - findTipoViaById ");
        tipoViaRepository.delete(tipoVia);
    }
}
