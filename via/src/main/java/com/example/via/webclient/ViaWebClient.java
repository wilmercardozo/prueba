package com.example.via.webclient;

import com.example.via.entity.TipoVia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ViaWebClient {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public TipoVia getTipoVia(Long id){
        TipoVia tipoVia= new TipoVia();
        try {
            String url="http://zuul-api-gateway-server/tv/api/tiposvia/"+id;
            Mono<ResponseEntity<String>> mono = webClientBuilder.build().get()
                    .uri(url)
                    .accept(MediaType.APPLICATION_JSON)
                    .header("Content-Type","application/json")
                    .exchange()
                    .flatMap(resp -> resp.toEntity(String.class));

            ResponseEntity<String> resp=mono.block();
            if(resp!=null && resp.getStatusCode().equals(HttpStatus.OK)){
                ObjectMapper om = new ObjectMapper();
                tipoVia = om.readValue(resp.getBody(), TipoVia.class);
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return tipoVia;
    }

}
