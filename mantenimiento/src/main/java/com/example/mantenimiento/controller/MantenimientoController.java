package com.example.mantenimiento.controller;

import com.example.mantenimiento.entity.Mantenimiento;
import com.example.mantenimiento.exception.ResourceNotFoundException;
import com.example.mantenimiento.payload.ManteniminetoPayload;
import com.example.mantenimiento.service.MantenimientoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MantenimientoController {

    private static final Logger log = LoggerFactory.getLogger(MantenimientoController.class);

    @Autowired
    MantenimientoService mantenimientoService;

    @GetMapping("mantenimiento")
    public Iterable<Mantenimiento> getAll(){
        log.info("mantenimiento  - MantenimientoController - getAll ");
        return mantenimientoService.findAll();
    }

    @GetMapping("/mantenimiento/{id}")
    public Mantenimiento getTiposMantenimientoById(@PathVariable(value = "id") Long id){
        log.info("mantenimiento  - MantenimientoController - getAll ");
        return mantenimientoService.findMantenimientoById(id);
    }

    @PostMapping("/mantenimiento")
    public Mantenimiento addMantenimiento(@Valid @RequestBody ManteniminetoPayload manteniminetoPayload){
        log.info("mantenimiento  - MantenimientoController - addMantenimiento ");
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setDescripcion(manteniminetoPayload.getDescripcion());
        mantenimiento.setIdVia(manteniminetoPayload.getIdVia());
        mantenimiento.setIdTipoMantenimiento(manteniminetoPayload.getIdTipoMantenimiento());
        return mantenimientoService.addMantenimiento(mantenimiento);
    }

    @PutMapping("/mantenimiento/{id}")
    public Mantenimiento updateMantenimiento(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody ManteniminetoPayload manteniminetoPayload) {
        log.info("mantenimiento  - MantenimientoController - updateMantenimiento ");

        Mantenimiento mantenimiento = mantenimientoService.findMantenimientoById(id);

        if(mantenimiento == null){
            throw new ResourceNotFoundException("mantenimientp/{id}", "PUT", "id" , id+"","No existe en la base de datos");
        }

        mantenimiento.setDescripcion(manteniminetoPayload.getDescripcion());
        mantenimiento.setIdVia(manteniminetoPayload.getIdVia());
        mantenimiento.setIdTipoMantenimiento(manteniminetoPayload.getIdTipoMantenimiento());
        return mantenimientoService.addMantenimiento(mantenimiento);
    }

    @DeleteMapping("/mantenimiento/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteMantenimiento(@PathVariable(value = "id") Long id) {
        log.info("mantenimiento  - MantenimientoController - deleteMantenimiento ");
        Mantenimiento mantenimiento = mantenimientoService.findMantenimientoById(id);

        mantenimientoService.deleteMantenimientoById(mantenimiento);
        return ResponseEntity.ok().build();
    }
}
