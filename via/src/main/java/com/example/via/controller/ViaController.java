package com.example.via.controller;

import com.example.via.entity.Via;
import com.example.via.exception.ResourceNotFoundException;
import com.example.via.payload.ViaPayload;
import com.example.via.service.ViaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ViaController {
    private static final Logger log = LoggerFactory.getLogger(ViaController.class);

    @Autowired
    ViaService viaService;

    @GetMapping("via")
    public Iterable<Via> getAll(){
        log.info("via  - ViaController - getAll ");
        return viaService.findAll();
    }

    @GetMapping("/via/{id}")
    public Via getViaById(@PathVariable(value = "id") Long id){
        log.info("via  - ViaController - getViaById ");
        return viaService.findViaById(id);
    }

    @PostMapping("/via")
    public Via addVia(@Valid @RequestBody ViaPayload viaPayload){
        log.info("via  - ViaController - addVia ");
        Via via = new Via();
        via.setDescripcion(viaPayload.getDescripcion());
        via.setTipoVia(viaPayload.getTipoVia());

        return viaService.addVia(via);
    }

    @PutMapping("/via/{id}")
    public Via updateVia(@PathVariable(value = "id") Long id,
                                 @Valid @RequestBody ViaPayload viaPayload) {
        log.info("via  - ViaController - updateVia ");
        Via via = viaService.findViaById(id);

        if(via == null){
            throw new ResourceNotFoundException("via/{id}", "PUT", "id" , id+"","No existe en la base de datos");
        }

        via.setDescripcion(viaPayload.getDescripcion());
        via.setTipoVia(viaPayload.getTipoVia());
        return viaService.addVia(via);
    }

    @DeleteMapping("/via/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteVia(@PathVariable(value = "id") Long id) {
        log.info("via  - ViaController - deleteVia ");
        Via via = viaService.findViaById(id);

        viaService.deleteViaById(via);
        return ResponseEntity.ok().build();
    }
}
