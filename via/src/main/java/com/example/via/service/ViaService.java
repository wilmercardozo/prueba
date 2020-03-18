package com.example.via.service;

import com.example.via.entity.TipoVia;
import com.example.via.entity.Via;
import com.example.via.exception.ResourceNotFoundException;
import com.example.via.repository.ViaRepository;
import com.example.via.webclient.ViaWebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ViaService {
    private static final Logger log = LoggerFactory.getLogger(ViaService.class);

    @Autowired
    ViaRepository viaRepository;

    @Autowired
    ViaWebClient viaWebClient;

    public Iterable<Via> findAll() {
        log.info("via  - ViaService - findAll ");
        return viaRepository.findAll();
    }

    public Via addVia(Via via){
        log.info("via  - ViaService - addTipoVia ");
        return viaRepository.save(via);
    }

    public Via findViaById(Long id){
        log.info("via  - ViaService - findViaById ");

        Via via = viaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("via", "GET", "id" ,id+"" ,"No existe en la base de datos"));;

        TipoVia tipoVia = new TipoVia();
        tipoVia = viaWebClient.getTipoVia(via.getId());
        via.setDescTipoVia(tipoVia.getDescripcion());
        return via;
    }


    public void deleteViaById(Via via) {
        log.info("via  - ViaService - deleteTipoViaById ");
        viaRepository.delete(via);
    }
}
