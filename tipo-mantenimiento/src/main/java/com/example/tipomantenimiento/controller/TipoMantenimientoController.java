package com.example.tipomantenimiento.controller;

import com.example.tipomantenimiento.entity.TipoMantenimiento;
import com.example.tipomantenimiento.exception.ResourceNotFoundException;
import com.example.tipomantenimiento.service.TipoMantenimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TipoMantenimientoController {
    private static final Logger log = LoggerFactory.getLogger(TipoMantenimientoController.class);

    @Autowired
    TipoMantenimientoService tipoMantenimientoService;

    @GetMapping("tiposmantenimiento")
    public Iterable<TipoMantenimiento> getAll(){
        log.info("tipo-mantenimiento  - TipoMantenimientoController - getAll ");
        return tipoMantenimientoService.findAll();
    }

    @GetMapping("/tiposmantenimiento/{id}")
    public TipoMantenimiento getTiposMantenimientoById(@PathVariable(value = "id") Long id){
        log.info("tipo-mantenimiento  - TipoMantenimientoController - getTiposMantenimientoById ");
        Optional<TipoMantenimiento> container = tipoMantenimientoService.findTipoMantenimientoById(id);
        return container.isPresent()?container.get():null;
    }

    @PostMapping("/tiposmantenimiento")
    public TipoMantenimiento addTipoMantenimiento(@Valid @RequestBody String descripcion){
        log.info("tipo-mantenimiento  - TipoMantenimientoController - addTipoMantenimiento ");
        TipoMantenimiento tipoMantenimiento = new TipoMantenimiento();
        tipoMantenimiento.setDescripcion(descripcion);
        return tipoMantenimientoService.addTipoMantenimiento(tipoMantenimiento);
    }

    @PutMapping("/tiposmantenimiento/{id}")
    public TipoMantenimiento updateTipoVia(@PathVariable(value = "id") Long id,
                                 @Valid @RequestBody String descripcion) {
        log.info("tipo-mantenimiento  - TipoMantenimientoController - getAll ");
        Optional<TipoMantenimiento> container = tipoMantenimientoService.findTipoMantenimientoById(id);
        TipoMantenimiento tipoMantenimiento = container.isPresent()?container.get():null;

        if(tipoMantenimiento == null){
            throw new ResourceNotFoundException("tiposvia/{id}", "PUT", "id" , id+"","No existe en la base de datos");
        }

        tipoMantenimiento.setDescripcion(descripcion);
        return tipoMantenimientoService.addTipoMantenimiento(tipoMantenimiento);
    }

    @DeleteMapping("/tiposmantenimiento/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteTipoVia(@PathVariable(value = "id") Long id) {
        log.info("tipo-mantenimiento  - TipoMantenimientoController - getAll ");
        TipoMantenimiento tipoVia = tipoMantenimientoService.findTipoMantenimientoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tiposvia", "DELETE", "id" ,id+"" ,"No existe en la base de datos"));
        tipoMantenimientoService.deleteTipoMantenimientoById(tipoVia);
        return ResponseEntity.ok().build();
    }
}
