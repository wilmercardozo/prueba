package com.example.tipovia.controller;

import com.example.tipovia.entity.TipoVia;
import com.example.tipovia.exception.ResourceNotFoundException;
import com.example.tipovia.service.TipoViaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TipoViaController {
    private static final Logger log = LoggerFactory.getLogger(TipoViaController.class);

    @Autowired
    TipoViaService tipoViaService;

    @GetMapping("tiposvia")
    public Iterable<TipoVia> getAll(){
        log.info("tipo-via  - TipoViaController - getAll ");
        return tipoViaService.findAll();
    }

    @GetMapping("/tiposvia/{id}")
    public TipoVia getTiposViaById(@PathVariable(value = "id") Long id){
        log.info("tipo-via  - TipoViaController - getAll ");
        Optional<TipoVia> container = tipoViaService.findTipoViaById(id);
        return container.isPresent()?container.get():null;
    }

    @PostMapping("/tiposvia")
    public TipoVia addTipoVia(@Valid @RequestBody String descripcion){
        log.info("tipo-via  - TipoViaController - addTipoVia ");
        TipoVia tipoVia = new TipoVia();
        tipoVia.setDescripcion(descripcion);
        return tipoViaService.addTipoVia(tipoVia);
    }

    @PutMapping("/tiposvia/{id}")
    public TipoVia updateTipoVia(@PathVariable(value = "id") Long id,
                                     @Valid @RequestBody String descripcion) {
        log.info("tipo-via  - TipoViaController - updateTipoVia ");
        Optional<TipoVia> container = tipoViaService.findTipoViaById(id);
        TipoVia tipoVia = container.isPresent()?container.get():null;

        if(tipoVia == null){
            throw new ResourceNotFoundException("tiposvia/{id}", "PUT", "id" , id+"","No existe en la base de datos");
        }

        tipoVia.setDescripcion(descripcion);
        return tipoViaService.addTipoVia(tipoVia);
    }

    @DeleteMapping("/tiposvia/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteTipoVia(@PathVariable(value = "id") Long id) {
        log.info("tipo-via  - TipoViaController - deleteTipoVia ");
        TipoVia tipoVia = tipoViaService.findTipoViaById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tiposvia", "DELETE", "id" ,id+"" ,"No existe en la base de datos"));
        tipoViaService.deleteTipoViaById(tipoVia);
        return ResponseEntity.ok().build();
    }


}
