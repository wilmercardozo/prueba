package com.example.mantenimiento.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class Via {

    private Long id;
    private String descripcion;
    private Long tipoVia;
    private String descTipoVia;
    private Date createdAt;
    private Date updatedAt;
}
