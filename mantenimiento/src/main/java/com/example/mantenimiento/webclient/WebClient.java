package com.example.mantenimiento.webclient;

import com.example.mantenimiento.entity.TipoMantenimiento;
import com.example.mantenimiento.entity.Via;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WebClient {

    @Autowired
    private org.springframework.web.reactive.function.client.WebClient.Builder webClientBuilder;

    public TipoMantenimiento getTipoMantenimiento(Long id){
        TipoMantenimiento tipoMantenimiento= new TipoMantenimiento();
        try {
            String url="http://zuul-api-gateway-server/tm/api/tiposmantenimiento/"+id;
            Mono<ResponseEntity<String>> mono = webClientBuilder.build().get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .header("Content-Type","application/json")
                    .exchange()
                    .flatMap(resp -> resp.toEntity(String.class));

            ResponseEntity<String> resp=mono.block();
            if(resp!=null && resp.getStatusCode().equals(HttpStatus.OK)){
                ObjectMapper om = new ObjectMapper();
                tipoMantenimiento = om.readValue(resp.getBody(), TipoMantenimiento.class);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tipoMantenimiento;
    }

    public Via getVia(Long id){
        Via via= new Via();
        try {
            String url="http://zuul-api-gateway-server/v/api/via/"+id;
            Mono<ResponseEntity<String>> mono = webClientBuilder.build().get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .header("Content-Type","application/json")
                    .exchange()
                    .flatMap(resp -> resp.toEntity(String.class));

            ResponseEntity<String> resp=mono.block();
            if(resp!=null && resp.getStatusCode().equals(HttpStatus.OK)){
                ObjectMapper om = new ObjectMapper();
                via = om.readValue(resp.getBody(), Via.class);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return via;
    }

}
