package com.example.mantenimiento.controller;

import com.example.mantenimiento.entity.Mantenimiento;
import com.example.mantenimiento.exception.ResourceNotFoundException;
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

    @GetMapping("tiposmantenimiento")
    public Iterable<Mantenimiento> getAll(){
        log.info("mantenimiento  - MantenimientoController - getAll ");
        return mantenimientoService.findAll();
    }

    @GetMapping("/tiposmantenimiento/{id}")
    public Mantenimiento getTiposMantenimientoById(@PathVariable(value = "id") Long id){
        log.info("mantenimiento  - MantenimientoController - getAll ");
        Optional<Mantenimiento> container = mantenimientoService.findMantenimientoById(id);
        return container.isPresent()?container.get():null;
    }

    @PostMapping("/tiposmantenimiento")
    public Mantenimiento addMantenimiento(@Valid @RequestBody String descripcion){
        log.info("mantenimiento  - MantenimientoController - addMantenimiento ");
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setDescripcion(descripcion);
        return mantenimientoService.addMantenimiento(mantenimiento);
    }

    @PutMapping("/tiposmantenimiento/{id}")
    public Mantenimiento updateMantenimiento(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody String descripcion) {
        log.info("mantenimiento  - MantenimientoController - updateMantenimiento ");
        Optional<Mantenimiento> container = mantenimientoService.findMantenimientoById(id);
        Mantenimiento mantenimiento = container.isPresent()?container.get():null;

        if(mantenimiento == null){
            throw new ResourceNotFoundException("mantenimientp/{id}", "PUT", "id" , id+"","No existe en la base de datos");
        }

        mantenimiento.setDescripcion(descripcion);
        return mantenimientoService.addMantenimiento(mantenimiento);
    }

    @DeleteMapping("/tiposmantenimiento/{id}")
    public ResponseEntity<ResponseEntity.BodyBuilder> deleteMantenimiento(@PathVariable(value = "id") Long id) {
        log.info("mantenimiento  - MantenimientoController - deleteMantenimiento ");
        Mantenimiento mantenimiento = mantenimientoService.findMantenimientoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("tiposvia", "DELETE", "id" ,id+"" ,"No existe en la base de datos"));
        mantenimientoService.deleteMantenimientoById(mantenimiento);
        return ResponseEntity.ok().build();
    }
}
