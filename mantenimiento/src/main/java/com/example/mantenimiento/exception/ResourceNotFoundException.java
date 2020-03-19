package com.example.mantenimiento.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    private final String resourceName;
    private final String fieldName;
    private final String verb;
    private final String msj;
    private final String fieldValue;

    public ResourceNotFoundException( String resourceName, String verb,String fieldName,  String fieldValue,String msj) {
        super(String.format("Metodo : %s Verbo : %s  Campo : %s  Valor : %s  Mensaje : %s '", resourceName,verb ,fieldName,fieldValue , msj));
        this.resourceName = resourceName;
        this.verb = verb;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.msj = msj;
    }
}