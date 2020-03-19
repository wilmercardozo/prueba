package com.example.tipomantenimiento;

import com.example.tipomantenimiento.entity.TipoMantenimiento;
import com.example.tipomantenimiento.service.TipoMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitDataLoader {

    @Autowired
    TipoMantenimientoService tipoMantenimientoService;

    public void loadData(){
        createData().forEach(
                tm-> {
                    tipoMantenimientoService.addTipoMantenimiento(tm);
                }
        );
    }

    private List<TipoMantenimiento> createData(){
        List<TipoMantenimiento> tipoMantenimientoList = new ArrayList<>();
        TipoMantenimiento tipoMantenimiento = new TipoMantenimiento();
        tipoMantenimiento.setDescripcion("reparcheo");
        tipoMantenimientoList.add(tipoMantenimiento);
        TipoMantenimiento tipoMantenimiento1 = new TipoMantenimiento();
        tipoMantenimiento1.setDescripcion("señalizacion");
        tipoMantenimientoList.add(tipoMantenimiento1);
        TipoMantenimiento tipoMantenimiento2 = new TipoMantenimiento();
        tipoMantenimiento2.setDescripcion("pavimentacion");
        tipoMantenimientoList.add(tipoMantenimiento2);

        return tipoMantenimientoList;
    }

}
