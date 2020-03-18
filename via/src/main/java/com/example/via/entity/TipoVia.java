package com.example.via.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class TipoVia {
    private Long id;
    private String descripcion;
    private Date createdAt;
    private Date updatedAt;
}
