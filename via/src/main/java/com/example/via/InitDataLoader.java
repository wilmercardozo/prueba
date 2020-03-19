package com.example.via;


import com.example.via.entity.Via;
import com.example.via.service.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitDataLoader {

    @Autowired
    ViaService viaService;

    public void loadData(){
        createData().forEach(
                v-> {
                    viaService.addVia(v);
                }
        );
    }

    private List<Via> createData(){
        List<Via> viaArrayList = new ArrayList<>();
        Via via = new Via();
        via.setDescripcion("cali");
        via.setTipoVia(new Long(1));
        viaArrayList.add(via);
        Via via2 = new Via();
        via2.setDescripcion("melgar");
        via2.setTipoVia(new Long(1));
        viaArrayList.add(via2);
        Via via3 = new Via();
        via3.setDescripcion("villavicencio");
        via3.setTipoVia(new Long(1));
        viaArrayList.add(via3);

        return viaArrayList;
    }

}
