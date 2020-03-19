package com.example.mantenimiento.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ManteniminetoPayload {
    private String descripcion;
    private Long idVia;
    private Long idTipoMantenimiento;
}
