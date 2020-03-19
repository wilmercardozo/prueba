package com.example.tipovia;

import com.example.tipovia.entity.TipoVia;
import com.example.tipovia.service.TipoViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class InitDataLoader {

    @Autowired
    TipoViaService tipoViaService;

    public void loadData(){
        createData().forEach(
                tv-> {
                    tipoViaService.addTipoVia(tv);
                }
        );
    }

    private List<TipoVia> createData(){
        List<TipoVia> tipoViaList = new ArrayList<>();
        TipoVia tipoVia = new TipoVia();
        tipoVia.setDescripcion("principal");
        tipoViaList.add(tipoVia);
        TipoVia tipoVia1 = new TipoVia();
        tipoVia1.setDescripcion("segundaria");
        tipoViaList.add(tipoVia1);
        TipoVia tipoVia2 = new TipoVia();
        tipoVia2.setDescripcion("tercearia");
        tipoViaList.add(tipoVia2);

        return tipoViaList;
    }

}
