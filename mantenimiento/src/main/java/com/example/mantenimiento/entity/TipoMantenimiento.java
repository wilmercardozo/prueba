package com.example.mantenimiento.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class TipoMantenimiento {
    private Long id;
    private String descripcion;
    private Date createdAt;
    private Date updatedAt;
}
